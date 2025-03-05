package es.etg.dam.pmdm14.practica_final_moviles.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import es.etg.dam.pmdm14.practica_final_moviles.data.database.ExcercisesDatabase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    private const val EXCERCISE_DATABASE_NAME = "Excercise_database"

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, ExcercisesDatabase::class.java, EXCERCISE_DATABASE_NAME).build()

    @Singleton
    @Provides
    fun provideClienteDao(db: ExcercisesDatabase) = db.excerciseDao()
}