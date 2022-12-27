package zengqiang.composestudy.widgets

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import zengqiang.composestudy.module.*
import zengqiang.composestudy.module.animator.AnimatedContentPage
import zengqiang.composestudy.module.animator.AnimatedVisibilityPage
import zengqiang.composestudy.module.animator.CrossFadePage
import zengqiang.composestudy.module.animator.RememberInfiniteTransitionPage
import zengqiang.composestudy.module.custom_view.LayoutModifierPage
import zengqiang.composestudy.module.layout.*
import zengqiang.composestudy.module.side_effects.*
import zengqiang.composestudy.module.widget.*
import zengqiang.composestudy.module.widget.remember_savable.RememberSavablePage
import zengqiang.composestudy.module.widget.viewmodel.ViewModelPage

enum class Routes {
    // 根页面
    HOME, WIDGETS, LAYOUT, ANIMATION, SIDE_EFFECTS, CUSTOM_VIEW,

    // WIDGETS
    BUTTON, ICON, ICON_TOGGLE_BUTTON, IMAGE, OUTLINE_BUTTON, OUTLINED_TEXT_FIELD, RADIO_BUTTON, SWITCH, TAB_ROW, TEXT, CLICKABLE_TEXT, TEXT_BUTTON, TEXT_FIELD, BASIC_TEXT_FIELD, TOP_APPBAR, SELECTION_CONTAINER, TRI_STATE_CHECKBOX, SLIDER, DIALOG, ALERT_DIALOG, PROGRESS_BAR, SCAFFOLD, REMEMBER_SAVABLE, VIEW_MODEL,

    // LAYOUT
    CONSTRAINT_LAYOUT, CONSTRAINT_LAYOUT_2, COLUMN, ROW, BOX,

    // ANIMATORS
    ANIMATED_CONTENT, ANIMATED_VISIBILITY, CROSS_FADE, REMEMBER_INFINITE_TRANSITION,

    //SIDE EFFECTS
    DISPOSABLE_EFFECT, SIDE_EFFECT, LAUNCH_EFFECT, REMEMBER_COROUTINE_SCOPE, REMEMBER_UPDATED_STATE, SNAP_FLOW,

    //CUSTOM_VIEW
    LAYOUT_MODIFIER,

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
        composable(Routes.SIDE_EFFECTS.name) {
            SideEffectsPage(navController = navController)
        }
        composable(Routes.CUSTOM_VIEW.name) {
            CustomPage(navController = navController)
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
        composable(Routes.CLICKABLE_TEXT.name) {
            ClickableTextPage()
        }

        composable(Routes.TEXT_BUTTON.name) {
            TextButtonPage()
        }
        composable(Routes.TEXT_FIELD.name) {
            TextFieldPage()
        }
        composable(Routes.BASIC_TEXT_FIELD.name) {
            BasicTextFieldPage()
        }

        composable(Routes.TOP_APPBAR.name) {
            TopAppBarPage(navController)
        }
        composable(Routes.SELECTION_CONTAINER.name) {
            SelectionContainerPage()
        }
        composable(Routes.TRI_STATE_CHECKBOX.name) {
            TriStateCheckboxPage()
        }
        composable(Routes.SLIDER.name) {
            SliderPage()
        }
        composable(Routes.DIALOG.name) {
            DialogPage()
        }
        composable(Routes.ALERT_DIALOG.name) {
            AlertDialogPage()
        }

        composable(Routes.PROGRESS_BAR.name) {
            ProgressBarPage()
        }
        composable(Routes.SCAFFOLD.name) {
            ScaffoldPage(navController)
        }
        composable(Routes.VIEW_MODEL.name) {
            ViewModelPage()
        }
        composable(Routes.REMEMBER_SAVABLE.name) {
            RememberSavablePage()
        }


        // Layout 页面
        composable(Routes.CONSTRAINT_LAYOUT.name) {
            ConstraintLayoutPage()
        }
        composable(Routes.CONSTRAINT_LAYOUT_2.name) {
            ConstraintLayoutPage2()
        }
        composable(Routes.CONSTRAINT_LAYOUT_2.name) {
            ConstraintLayoutPage2()
        }

        composable(Routes.COLUMN.name) {
            ColumnPage()
        }

        composable(Routes.ROW.name) {
            RowPage()
        }
        composable(Routes.BOX.name) {
            BoxPage()
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
        // SideEffects 页面
        composable(Routes.DISPOSABLE_EFFECT.name) {
            DisposableEffectPage()
        }
        composable(Routes.SIDE_EFFECT.name) {
            SideEffectPage()
        }
        composable(Routes.LAUNCH_EFFECT.name) {
            LaunchEffectPage()
        }
        composable(Routes.REMEMBER_COROUTINE_SCOPE.name) {
            RememberCoroutineScopePage()
        }
        composable(Routes.REMEMBER_UPDATED_STATE.name) {
            RememberUpdatedStatePage()
        }
        composable(Routes.SNAP_FLOW.name) {
            SnapFlowPage()
        }

        // CUSTOM_VIEW
        composable(Routes.LAYOUT_MODIFIER.name) {
            LayoutModifierPage()
        }

    }
}