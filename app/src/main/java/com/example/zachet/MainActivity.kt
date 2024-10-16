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
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Image(
            painter = painterResource(id = R.drawable.image1),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp),
            contentScale = ContentScale.Crop
        )
        Text(
            text = "За яркими эмоциями -\n" +
                    "в «Парк чудес Галилео»",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = "Устройте уникальное познавательное приключение! Галилео - это командный, семейный интерактив. Он сочетает интеллектуальный и активный отдых. Будет интересно как детям, так и взрослым.",
            fontSize = 18.sp,
            textAlign = TextAlign.Center,
            fontStyle = FontStyle.Italic
        )
        Text(
            text = "Экспонаты и пространства парка взаимодействуют\n" +
                    "с посетителем в разной форме - интерактивной, развлекательной, учебно-познавательной. Первый этаж разбудит в вас настоящего исследователя. Трогайте, нажимайте, кричите и экспериментируйте! Комнаты второго этажа полностью погрузят вас в необычные ощущения. Вас закружит крутящийся коридор, наклонная комната изменит гравитацию, а темный лабиринт проверит нервы на прочность. И напоследок вы запутаетесь в реальности в большом зеркальном лабиринте. Внимание! Остаться без впечатлений не удастся никому!",
            fontSize = 18.sp,
            textAlign = TextAlign.Center,
            fontStyle = FontStyle.Italic
        )
        Text(
            text = "Лаборатория чудес",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = "Испытайте чудеса науки на практикумах\n" +
                    "и мастер-классах Лаборатории чудес. Каждый практикум - это захватывающие истории об окружающем мире с химическими и физическими лабораторными опытами. Программы «Жжём про холод», «ALLХимия», «Наука огня» и другие превратят детей и взрослых в настоящих ученых-экспериментаторов.",
            fontSize = 18.sp,
            textAlign = TextAlign.Center,
            fontStyle = FontStyle.Italic
        )
        Text(
            text = "Детский день рождения",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = "Отметьте детский день рождения весело и познавательно в нашем парке. На ваш выбор несколько программ разной длительности. Они включают посещение главного пространства парка, практикум в Лаборатории чудес, чаепитие. Также вы можете воспользоваться уникальной возможностью и пригласить «Парк чудес Галилео» на праздник. Мы приедем к вам домой с завораживающим криошоу и вместе создадим криоугощения для праздничного стола.",
            fontSize = 18.sp,
            textAlign = TextAlign.Center,
            fontStyle = FontStyle.Italic
        )
    }
}

@Composable
fun PosterPage() {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Image(
            painter = painterResource(id = R.drawable.image2),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp),
            contentScale = ContentScale.Crop
        )
        Text(
            text = "Скидка для многодетных",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = "День рождение - отличный повод прийти в «Парк чудес Галилео».\n" +
                    "Весь месяц именинник проходит бесплатно в основное пространство парка.\n" +
                    "Чтобы воспользоваться предложением, покажите кассиру-администратору свидетельство о рождении или паспорт.\n" +
                    "\n" +
                    "Акция не распространяется на программы «МиниГений», «Гений», «МегаГений» и «Лабораторию чудес Галилео».",
            fontSize = 18.sp,
            textAlign = TextAlign.Center,
            fontStyle = FontStyle.Italic
        )
        Text(
            text = "Хотите уникальную свадебную фотосессию? Тогда вам точно в «Парк чудес Галилео». В день свадьбы молодожены и фотограф могут прийти бесплатно. Для этого покажите свидетельство о браке кассиру-администратору.\n" +
                    "Акция не распространяется на мастер-классы «Лаборатории чудес Галилео»",
            fontSize = 18.sp,
            textAlign = TextAlign.Center,
            fontStyle = FontStyle.Italic
        )
        Text(
            text = "А еще есть Скидки",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = "Особые условия в парке действуют для многодетных семей. Стоимость детского билета в основное пространство парка составляет 450₽. Чтобы воспользоваться предложением, при покупке билетов предъявите документ, подтверждающий статус многодетной семьи.",
            fontSize = 18.sp,
            textAlign = TextAlign.Center,
            fontStyle = FontStyle.Italic
        )
    }
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
            text = "Парк чудес галилео\n" +
                    "— \uFEFF отдых для всей семьи",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = "«Парк чудес Галилео» - это по-настоящему командообразующее мероприятие. Вам непременно захочется разделить удивление, восторг, радость, а также громко смеяться вместе с вашими спутниками. Калейдоскоп эмоций - то, что нужно для классного детского дня рождения или групповой экскурсии для школьников.\n" +
                    "\n" +
                    "Вы также можете привнести частичку научно-популярного веселья на ваше мероприятие. Организовать выездной мастер-класс поможет «Лаборатория чудес Галилео».",
            fontSize = 18.sp,
            textAlign = TextAlign.Center,
            fontStyle = FontStyle.Italic
        )
        Text(
            text = "Хотите посетить парк всей семьей? Непременно берите с собой не только самых маленьких, но и бабушек с дедушками. Путешествие по парку всеми поколениями станет семейно- укрепляющим развлечением. Пока взрослые веселятся и разгадывают тайны парка, малыши могут порисовать на песке, запускать по воздушной трубе самолеты и еще много чего!",
            fontSize = 18.sp,
            textAlign = TextAlign.Center,
            fontStyle = FontStyle.Italic
        )
        Text(
            text = "Парк",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = "«Парк чудес Галилео» уже много лет увлекает, захватывает и впечатляет своих посетителей. В 2010 году появилось основное пространство\n" +
                    "в Екатеринбурге. Постепенно парк стал открываться и в других городах России - Челябинске, Новосибирске, Красноярске, Нижнем Новгороде, Самаре и Санкт-Петербурге. Зеркальный лабиринт екатеринбургского парка является одним из самых больших в Европе. Экспозиция регулярно обновляется и появляются новые захватывающие экспонаты.\n" +
                    "\n" +
                    "За это время в нашей книге отзывов отметились путешественники\n" +
                    "со всей России и разных уголков мира со словами благодарности\n" +
                    "об испытанных эмоциях.",
            fontSize = 18.sp,
            textAlign = TextAlign.Center,
            fontStyle = FontStyle.Italic
        )
        Text(
            text = "ЛАБОРАТОРИЯ",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = "«Лаборатория чудес Галилео» - самое молодое пространство парка. Она появилась в 2020 году, но уже покорила сердца многих детей\n" +
                    "и родителей. Мы проводим не просто научное шоу. Практикумы «Лаборатории чудес» - это яркие опыты, заключенные в увлекательные истории и факты, применимые к жизни. На наших Практикумах\n" +
                    "вы узнаете не просто случайный научный факт, а как работает явление, что для него нужно и как это можно использовать.\n" +
                    "\n" +
                    "Особый участник программы - уникальное оборудование, которое собирается специально для парка, для иллюстрации разных физических и химических явлений.",
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
            text = "Касса:\n" +
                    "+7 (343) 2-06-06-07\n" +
                    "WhatsApp:\n" +
                    "+7 (902) 155-89-38",
            fontSize = 18.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = "г. Екатеринбург, пр. Ленина, 50Ж, павильон №2\n" +
                    "Со стороны ул. Кузнечной зайдите в главный вход Свердловской киностудии,\n" +
                    "внутри поверните направо, идите по коридору до вывески «Парк чудес Галилео».",
            fontSize = 18.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = "Каждый день с 10-00 до 20-00\n" +
                    "Без перерывов\n" +
                    "Касса работает до 19-00",
            fontSize = 18.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = "galileo66@mail.ru",
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
