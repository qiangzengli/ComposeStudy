package zengqiang.composestudy.widgets

import androidx.compose.foundation.ExperimentalFoundationApi
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
    // 根页面
    HOME,
    WIDGETS,
    LAYOUT,
    ANIMATION,

    // WIDGETS
    BUTTON,
    ICON,
    ICON_TOGGLE_BUTTON,
    IMAGE,
    OUTLINE_BUTTON,
    OUTLINED_TEXT_FIELD,
    RADIO_BUTTON,
    SWITCH,
    TAB_ROW,
    TEXT,
    TEXT_BUTTON,
    TEXT_FIELD,
    TOP_APPBAR,
    SELECTION_CONTAINER,

    // LAYOUT
    CONSTRAINT_LAYOUT,
    ROW,

    // ANIMATORS
    ANIMATED_CONTENT,
    ANIMATED_VISIBILITY,
    CROSS_FADE,
    REMEMBER_INFINITE_TRANSITION,


}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ComposeNavHost(navController: NavHostController, startDestination: String) {
    NavHost(navController = navController, startDestination = startDestination) {
        // 一级页面
        composable(Routes.HOME.name) {
            HomePage(navController = navController)
        }
        composable(Routes.WIDGETS.name) {
            WidgetPage(navController = navController)
        }
        composable(Routes.LAYOUT.name) {
            LayoutPage(navController = navController)
        }
        composable(Routes.ANIMATION.name) {
            AnimationPage(navController = navController)
        }
        // Widgets 页面
        composable(Routes.BUTTON.name) {
            ButtonPage(navController = navController)
        }
        composable(Routes.ICON.name) {
            IconPage(navController = navController)
        }

        composable(Routes.ICON_TOGGLE_BUTTON.name) {
            IconToggleButtonPage()
        }

        composable(Routes.IMAGE.name) {
            ImagePage(navController = navController)
        }
        composable(Routes.OUTLINE_BUTTON.name) {
            OutLineButtonPage()
        }
        composable(Routes.OUTLINED_TEXT_FIELD.name) {
            OutlinedTextFieldPage()
        }
        composable(Routes.RADIO_BUTTON.name) {
            RadioButtonPage()
        }
        composable(Routes.SWITCH.name) {
            SwitchPage()
        }

        composable(Routes.TAB_ROW.name) {
            TabRowPage()
        }

        composable(Routes.TEXT.name) {
            TextPage()
        }

        composable(Routes.TEXT_BUTTON.name) {
            TextButtonPage()
        }
        composable(Routes.TEXT_FIELD.name) {
            TextFieldPage()
        }
        composable(Routes.TEXT.name) {
            TextPage()
        }
        composable(Routes.TOP_APPBAR.name) {
            TopAppBarPage(navController)
        }
        composable(Routes.SELECTION_CONTAINER.name) {
            SelectionContainerPage()
        }

        // Layout 页面
        composable(Routes.CONSTRAINT_LAYOUT.name) {
            ConstraintLayoutPage()
        }

        composable(Routes.ROW.name) {
            RowPage()
        }
        // Animations 页面
        composable(Routes.ANIMATED_CONTENT.name) {
            AnimatedContentPage()
        }
        composable(Routes.ANIMATED_VISIBILITY.name) {
            AnimatedVisibilityPage()
        }

        composable(Routes.CROSS_FADE.name) {
            CrossFadePage()
        }
        composable(Routes.REMEMBER_INFINITE_TRANSITION.name) {
            RememberInfiniteTransitionPage()
        }


    }
}