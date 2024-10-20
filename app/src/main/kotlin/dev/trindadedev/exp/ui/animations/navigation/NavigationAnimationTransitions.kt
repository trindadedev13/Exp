package dev.trindadedev.exp.ui.animations.navigation

import soup.compose.material.motion.animation.materialSharedAxisXIn
import soup.compose.material.motion.animation.materialSharedAxisXOut

object NavigationAnimationTransitions {

    val enterTransition =
        materialSharedAxisXIn(
            forward = true,
            slideDistance = NavigationAnimationValues.SlideDistance,
            durationMillis = NavigationAnimationValues.SlideDuration,
        )

    val exitTransition =
        materialSharedAxisXOut(
            forward = true,
            slideDistance = NavigationAnimationValues.SlideDistance,
            durationMillis = NavigationAnimationValues.SlideDuration,
        )

    val popEnterTransition =
        materialSharedAxisXIn(
            forward = false,
            slideDistance = NavigationAnimationValues.SlideDistance,
            durationMillis = NavigationAnimationValues.SlideDuration,
        )

    val popExitTransition =
        materialSharedAxisXOut(
            forward = false,
            slideDistance = NavigationAnimationValues.SlideDistance,
            durationMillis = NavigationAnimationValues.SlideDuration,
        )
}
