package com.example.newsapp.presentation.ui.home

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.newsapp.data.model.Article
import com.example.newsapp.data.model.home.HomeScreenTO
import com.example.newsapp.presentation.HeaderTitleTextComponent
import com.example.newsapp.presentation.Loader
import com.example.newsapp.presentation.TitleTextComponent

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    navController: NavController,
    homeScreenTO: HomeScreenTO,
) {

    val context = LocalContext.current

    Surface(modifier = Modifier.fillMaxSize()) {
        when (homeScreenTO) {
            is HomeScreenTO.Loading -> {
                Loader()
            }

            is HomeScreenTO.Success -> {
                val newsResponse = homeScreenTO.data
                val totalResults = newsResponse.totalResults
                val pagerState = rememberPagerState(
                    initialPage = 0,
                    initialPageOffsetFraction = 0f,
                )
                VerticalPager(
                    state = pagerState,
                    pageCount = totalResults,
                    modifier = Modifier.fillMaxSize(),
                    pageSize = PageSize.Fill,
                ) { page ->
                    val article = newsResponse.articles[page]
                    NewsList(article, page)
                }
            }

            is HomeScreenTO.Error -> {
                Toast.makeText(context, "Something went wrong, Please try again later!!",Toast.LENGTH_SHORT).show()
            }
        }
    }
}

@Composable
private fun NewsList(article: Article, page: Int) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
            .background(Color.White),
    ) {
        AsyncImage(
            modifier = Modifier
                .fillMaxWidth()
                .height(240.dp)
                .wrapContentHeight(Alignment.Top),
            model = article.urlToImage,
            contentDescription = "image $page",
            contentScale = ContentScale.Fit
        )

        Spacer(modifier = Modifier.size(20.dp))

        HeaderTitleTextComponent(textValue = article.title?: "")
        Spacer(modifier = Modifier.size(10.dp))
        TitleTextComponent(textValue = article.content)
    }

}

@Preview(showBackground = true)
@Composable
fun NewsListPreview() {
    val article = Article(
        author = "Book",
        title = "Book is very good",
        urlToImage = "https://media.cnn.com/api/v1/images/stellar/prod/2023-10-25t195321z-1966779931-rc2oz3avkjti-rtrmadp-3-usa-trump-new-york.jpg?c=16x9&q=w_800"
    )
    NewsList(article, 1)
}