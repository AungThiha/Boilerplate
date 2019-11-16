package thiha.aung.boilerplate.di

import thiha.aung.boilerplate.core.di.coreModule
import thiha.aung.boilerplate.photo.di.photoModule

val appModule = coreModule + dbModule + photoModule