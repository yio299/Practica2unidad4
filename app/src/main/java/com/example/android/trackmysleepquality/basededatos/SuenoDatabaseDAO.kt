
package com.example.android.trackmysleepquality.basededatos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface SuenoDatabaseDAO {

    @Insert
    suspend fun insertar(noche: SuenoNoche)

    @Update
    suspend fun actualizar(noche: SuenoNoche)

    @Query(value = "SELECT * FROM tabla_caliad_sueno_diaria WHERE nocheId = :Key")
    suspend fun obtener(Key: Long): SuenoNoche?

    @Query(value= "DELETE FROM tabla_caliad_sueno_diaria")
    suspend fun limpiar()

    @Query( value="SELECT * FROM tabla_caliad_sueno_diaria ORDER BY nocheId DESC" )
    fun obtenerTodasLasNoches(): LiveData<List<SuenoNoche>>

    @Query(value= "SELECT * FROM tabla_caliad_sueno_diaria ORDER BY nocheId DESC LIMIT 1")
    suspend fun obtenerUltimaNoche(): SuenoNoche?


}