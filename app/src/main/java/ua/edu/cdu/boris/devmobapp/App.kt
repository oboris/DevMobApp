package ua.edu.cdu.boris.devmobapp

import android.app.Application

class App: Application() {
    val db by lazy {AppDb.getDb(this)}
    val repo by lazy {AppRepo(db.bookDao(), db.telephoneDao())}
}