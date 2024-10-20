package dev.trindadedev.exp.ui.animations.navigation

import soup.compose.material.motion.animation.materialSharedAxisZIn
import soup.compose.material.motion.animation.materialSharedAxisZOut

object NavigationAnimationTransitions {

    val enterTransition =
        materialSharedAxisZIn(
            forward = true,
            slideDistance = NavigationAnimationValues.SlideDistance,
            durationMillis = NavigationAnimationValues.SlideDuration,
        )

    val exitTransition =
        materialSharedAxisZOut(
            forward = true,
            slideDistance = NavigationAnimationValues.SlideDistance,
            durationMillis = NavigationAnimationValues.SlideDuration,
        )

    val popEnterTransition =
        materialSharedAxisZIn(
            forward = false,
            slideDistance = NavigationAnimationValues.SlideDistance,
            durationMillis = NavigationAnimationValues.SlideDuration,
        )

    val popExitTransition =
        materialSharedAxisZOut(
            forward = false,
            slideDistance = NavigationAnimationValues.SlideDistance,
            durationMillis = NavigationAnimationValues.SlideDuration,
        )
}
