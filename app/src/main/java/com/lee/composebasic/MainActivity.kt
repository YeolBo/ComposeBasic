package com.lee.composebasic

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.graphics.Color
import android.inputmethodservice.Keyboard
import android.os.Bundle
import android.util.Log
import android.view.Surface
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lee.composebasic.ui.theme.ComposeBasicTheme
import org.w3c.dom.Text

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeBasicTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greeting("룰루랄라")
                }
            }
        }
    }
}

// 뷰, 핵스칼라 사용시 앞에 0xff
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Greeting(name: String) {
    Scaffold( topBar = {
        TopAppBar(title = { Text("composeTest") }
            ,backgroundColor = Color(0xffFF8FB1))},
        floatingActionButtonPosition = FabPosition.End,
        floatingActionButton = { FloatingActionButton(onClick = {}){
            Text("클릭")
        } }
    ){
//        Text(text = "안녕! $name")
        MyComposableView()
    }
}

@Composable
fun MyRowItem(){
    Log.d(TAG, " - MyComposableView() called")
    // 호리젠탈 리니어 레이아웃이랑 비슷
    Keyboard.Row(
        Modifier
            .padding(10.dp)
            .background(Color(0x80CDDC39))
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "가나다라마",
            Modifier
                .padding(all = 10.dp)
                .background(Color(0xffFF8FB1))
        )
        Spacer(modifier = Modifier.size(10.dp))
        Text(text = "바사아자차")
        Spacer(modifier = Modifier.size(10.dp))
        Text(text = "카타파하")
    }
}

@Composable
fun MyComposableView(){
    Log.d(TAG, " - MyComposableView() called")

    // 버티칼 리니어 레이아웃
    Column(
        Modifier
            .background(Color(0xFF2196F3))
            .verticalScroll(rememberScrollState())
    ){
        for (i in 0..30){
            MyRowItem()
        }
    }
}

// 미리보기, 어느 창에서든 사용가능
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeBasicTheme {
        Greeting("룰루랄라")
    }
}