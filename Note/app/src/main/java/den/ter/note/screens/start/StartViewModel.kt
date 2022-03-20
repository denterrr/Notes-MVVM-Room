package den.ter.note.screens.start

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import den.ter.note.REPOSITORY
import den.ter.note.db.NoteDatabase
import den.ter.note.db.repository.NoteRealization
import den.ter.note.model.NoteModel

class StartViewModel(application: Application): AndroidViewModel(application) {

    val context = application

    fun initDatabase(){
        val daoNote = NoteDatabase.getInstance(context).getNoteDao()
        REPOSITORY = NoteRealization(daoNote)
    }

    fun getAllNotes(): LiveData<List<NoteModel>>{
        return REPOSITORY.allNotes
    }

}