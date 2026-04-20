package uk.co.fintaxtech.demo.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uk.co.fintaxtech.demo.ui.AppColorPalette
import uk.co.fintaxtech.ui.theme.FTTColorPalette
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class ColorModule {

    @Binds
    @Singleton
    abstract fun bindColorPalette(palette: AppColorPalette): FTTColorPalette

}