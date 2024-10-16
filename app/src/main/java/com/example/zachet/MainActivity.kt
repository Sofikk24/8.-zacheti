package com.example.zachet

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.zIndex

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CultureApp()
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun CultureApp() {
    var currentPage by remember { mutableStateOf(1) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(Color.LightGray)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
                .align(Alignment.TopCenter)
                .zIndex(1f),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            SquareButton("Главная") { currentPage = 1 }
            SquareButton("Афиша") { currentPage = 2 }
            SquareButton("О нас") { currentPage = 3 }
            SquareButton("Контакты") { currentPage = 4 }
        }

        ScrollablePage {
            when (currentPage) {
                1 -> HomePage()
                2 -> PosterPage()
                3 -> AboutPage()
                4 -> ContactPage()
            }
        }
    }
}

@Composable
fun ScrollablePage(content: @Composable () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(top = 100.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        content()
    }
}

@Composable
fun SquareButton(text: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .size(80.dp)
            .padding(4.dp),
        contentPadding = PaddingValues(0.dp)
    ) {
        Text(
            text = text,
            fontSize = 10.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun HomePage() {
    PageContent(
        imageRes = R.drawable.image1,
        title = "Добро пожаловать",
        description = "Насладитесь прекрасными выставками и произведениями искусства."
    )
}

@Composable
fun PosterPage() {
    PageContent(
        imageRes = R.drawable.image2,
        title = "Афиша",
        description = "Современное искусство и ближайшие мероприятия."
    )
}

@Composable
fun AboutPage() {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Image(
            painter = painterResource(id = R.drawable.image3),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp),
            contentScale = ContentScale.Crop
        )
        Text(
            text = "Возможности сцены",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = "Театральная площадка XXI века — это оснащенный по последнему слову техники комплекс, который позволяет воплотить любую, самую необычную режиссерскую фантазию.",
            fontSize = 18.sp,
            textAlign = TextAlign.Center,
            fontStyle = FontStyle.Italic
        )
        Text(
            text = "В числе крупнейших европейских театральных реконструкций начала милленниума — реконструкция Национального академического Большого театра оперы и балета Республики Беларусь, начатая в 2006 и продлившаяся три года. Перед архитекторами, проектировщиками, инженерами, строителями были поставлены две непростые задачи: реконструкция и реставрация. С одной стороны, театр — национальное достояние, поэтому необходимо было учитывать мнение историков и сохранить материальные и духовные ценности, заложенные в данном конкретном проекте. С другой — главный театр страны должен иметь самые современные сценические технологии, новейшее оборудование, эксклюзивные материалы. В результате зрителям представили интерьер, восстановленный весьма деликатно — облик театра максимально приближен к замыслу автора проекта здания — архитектора Иосифа Лангбарда. А за занавесом — уникальная сценическая площадка — одна из лучших в Европе.",
            fontSize = 18.sp,
            textAlign = TextAlign.Center,
            fontStyle = FontStyle.Italic
        )
    }
}

@Composable
fun ContactPage() {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Image(
            painter = painterResource(id = R.drawable.image4),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp),
            contentScale = ContentScale.Crop
        )
        Text(
            text = "Контакты",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
        )
        Text(
            text = "Государственное театрально-зрелищное учреждение \"Национальный академический Большой театр оперы и балета Республики Беларусь\" (Большой театр Беларуси)",
            fontSize = 18.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = "пл. Парижской Коммуны, 1, Минск, 220029 e-mail: teatr@bolshoibelarus.by",
            fontSize = 18.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = "В дни, являющиеся государственными праздниками, кассы театра не работают!\n" +
                    "Реализация и бронирование билетов: тел/факс +375 (17) 272 28 64, 263 10 74, 318 06 66\n" +
                    "Время работы: пн-пт. с 09.00 до 18.00. Обед с 13.00 до 14.00\n" +
                    "Касса: +375 17 243-10-41. Время работы: с 10.00 до 20.00 без выходных.",
            fontSize = 18.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = "ticket@belarusopera.by",
            modifier = Modifier.clickable {
                val intent = Intent(Intent.ACTION_SENDTO).apply {
                    data = Uri.parse("mailto:contact@culture.com")
                }
                context.startActivity(intent)
            },
            fontSize = 16.sp,
            color = Color.Blue,
            textAlign = TextAlign.Center
        )
        Text(
            text = "Cправочный круглосуточный: +375 (17) 361 54 93\n" +
                    "Факс: \n" +
                    "По вопросам служебной переписки (тел/факс): +375 (17) 215 25 83\n" +
                    "Мобильный: \n" +
                    "Проведение экскурсий и фотосессий: +375 (17) 379 11 56 , +375 (33) 901 28 89",
            fontSize = 18.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun PageContent(
    imageRes: Int,
    title: String,
    description: String
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp),
            contentScale = ContentScale.Crop
        )
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            modifier = Modifier.padding(vertical = 8.dp)
        )
        Text(
            text = description,
            fontSize = 18.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CultureApp()
}
