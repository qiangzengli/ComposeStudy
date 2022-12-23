package zengqiang.composestudy.widgets

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import zengqiang.composestudy.module.AnimationPage
import zengqiang.composestudy.module.HomePage
import zengqiang.composestudy.module.LayoutPage
import zengqiang.composestudy.module.WidgetPage
import zengqiang.composestudy.module.animator.AnimatedContentPage
import zengqiang.composestudy.module.animator.AnimatedVisibilityPage
import zengqiang.composestudy.module.animator.CrossFadePage
import zengqiang.composestudy.module.animator.RememberInfiniteTransitionPage
import zengqiang.composestudy.module.layout.ConstraintLayoutPage
import zengqiang.composestudy.module.layout.RowPage
import zengqiang.composestudy.module.widget.*

enum class Routes {
    home,
    widgets,
    layout,
    animation,

    // widgets
    button,
    icon,
    icon_toggle_button,
    image,
    outline_button,
    outlined_text_field,
    radio_button,
    switch,
    tab_row,
    text,
    text_button,
    text_field,
    top_appbar,

    // layout
    constraint_layout,
    row,

    // animators
    animated_content,
    animated_visibility,
    cross_fade,
    remember_infinite_transition,


}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ComposeNavHost(navController: NavHostController, startDestination: String) {
    NavHost(navController = navController, startDestination = startDestination) {
        composable(Routes.home.name) {
            HomePage(navController = navController)
        }
        composable(Routes.widgets.name) {
            WidgetPage(navController = navController)
        }
        composable(Routes.layout.name) {
            LayoutPage(navController = navController)
        }
        composable(Routes.animation.name) {
            AnimationPage(navController = navController)
        }
        composable(Routes.button.name) {
            ButtonPage(navController = navController)
        }
        composable(Routes.icon.name) {
            IconPage(navController = navController)
        }

        composable(Routes.icon_toggle_button.name) {
            IconToggleButtonPage()
        }

        composable(Routes.image.name) {
            ImagePage(navController = navController)
        }
        composable(Routes.outline_button.name) {
            OutLineButtonPage()
        }
        composable(Routes.outlined_text_field.name) {
            OutlinedTextFieldPage()
        }
        composable(Routes.radio_button.name) {
            RadioButtonPage()
        }
        composable(Routes.switch.name) {
            SwitchPage()
        }

        composable(Routes.tab_row.name) {
            TabRowPage()
        }

        composable(Routes.text.name) {
            TextPage()
        }

        composable(Routes.text_button.name) {
            TextButtonPage()
        }
        composable(Routes.text_field.name) {
            TextFieldPage()
        }
        composable(Routes.text.name) {
            TextPage()
        }
        composable(Routes.top_appbar.name) {
            TopAppBarPage(navController)
        }

        composable(Routes.constraint_layout.name) {
            ConstraintLayoutPage()
        }

        composable(Routes.row.name) {
            RowPage()
        }
        composable(Routes.animated_content.name) {
            AnimatedContentPage()
        }
        composable(Routes.animated_visibility.name) {
            AnimatedVisibilityPage()
        }

        composable(Routes.cross_fade.name) {
            CrossFadePage()
        }
        composable(Routes.remember_infinite_transition.name) {
            RememberInfiniteTransitionPage()
        }


    }
}