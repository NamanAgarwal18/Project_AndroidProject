package com.nimitsajal.studentconnectapp

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.GestureDetector
import android.view.MotionEvent
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.GestureDetectorCompat
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.GridLayoutManager
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Item
import kotlinx.android.synthetic.main.activity_current_chats.*
import kotlinx.android.synthetic.main.activity_current_chats.etSearch
import kotlinx.android.synthetic.main.activity_main_feed.btnFeed
import kotlinx.android.synthetic.main.activity_main_feed.btnLogout
import kotlinx.android.synthetic.main.activity_main_feed.btnProfile
import kotlinx.android.synthetic.main.activity_new_chat.*
import kotlinx.android.synthetic.main.current_chat_adapter.view.*
import kotlinx.android.synthetic.main.new_chat_adapter.*
import kotlinx.android.synthetic.main.post_adapter_cardiew.view.*

class currentChats : AppCompatActivity() {
    private lateinit var detector: GestureDetectorCompat
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_current_chats)
//        var username = ""

        val adapter = GroupAdapter<GroupieViewHolder>()


        //TODO: GRID VIEW
//        val mLayoutManager = GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false)
//        rvCurrentChats.layoutManager = mLayoutManager

        var arrayUser = mutableListOf<usersList>()

        var username = intent.getStringExtra("username")
        val db = FirebaseFirestore.getInstance()
        val auth = FirebaseAuth.getInstance()
        val user = auth.currentUser
        if(user != null){
            val user_table = db.collection("User Table").document(user.uid.toString())
            user_table.get().addOnSuccessListener { result ->
                if(result != null){
                    username = result.getString("Username").toString()
                    Log.d("profilePage", username.toString())
                    detector = GestureDetectorCompat(this,DiaryGestureListener(username))
                    adapter.clear()
                    fetchUser(username!!, adapter, arrayUser)
                }
                else{
                    showToast("ERROR", 1)
                    return@addOnSuccessListener
                }
            }
        }

        detector = GestureDetectorCompat(this,DiaryGestureListener(username))
        btnLogout.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            val intent = Intent(this, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            startActivity(intent)
            finish()
        }

//        btnChat.setOnClickListener {
//            val intent = Intent(this, currentChats::class.java)
//            intent.putExtra("username", username)
//            startActivity(intent)
//        }

        btnProfile.setOnClickListener {
            goToProfile(username!!)
        }

        btnFeed.setOnClickListener {
            val intent = Intent(this, mainFeed::class.java)
            intent.putExtra("username", username)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right)
            finish()
        }

        btnNewChat.setOnClickListener {
            goToNewChats(username!!)
        }

        etSearch.addTextChangedListener(){
            if(etSearch.text.toString() == "")
            {
                etSearch.isVisible=false

                studentConnectCurrentChat.isVisible = true
            }
            else{
                etSearch.isVisible = true

                studentConnectCurrentChat.isVisible = false
            }

            if(username != null){
                adapter.clear()
                searching(arrayUser, adapter, username!!)
            }
        }

        btnSearch_currentChat.setOnClickListener {
            if(etSearch.isVisible==true){
               closeSearchBar()
            }
            else
            {
                openSearchBar()
            }
        }

        btnEvent.setOnClickListener {
            val intent = Intent(this, eventPage::class.java)
            intent.putExtra("username", username)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right)
            finish()
        }
    }

    private fun showToast(message: String, type: Int)
    {   //1 -> error
        //2 -> success
        //3 -> information

        if(type == 1){
            Log.d("toast", "$message")
            val toastView = layoutInflater.inflate(
                R.layout.toast_text_adapter,
                findViewById(R.id.toastLayout)
            )
            // Link Youtube -> https://www.youtube.com/watch?v=__GRhyvf6oE
            val textMessage = toastView.findViewById<TextView>(R.id.toastText)
            textMessage.text = message
            Log.d("toast", "${textMessage.text}")
            with(Toast(applicationContext))
            {
                duration = Toast.LENGTH_SHORT
                view = toastView
                show()
            }
        }
        else if(type == 2){
            Log.d("toast", "$message")
            val toastView = layoutInflater.inflate(
                R.layout.toast_text_successful,
                findViewById(R.id.toastLayoutSuccessful)
            )
            // Link Youtube -> https://www.youtube.com/watch?v=__GRhyvf6oE
            val textMessage = toastView.findViewById<TextView>(R.id.toastText)
            textMessage.text = message
            Log.d("toast", "${textMessage.text}")
            with(Toast(applicationContext))
            {
                duration = Toast.LENGTH_SHORT
                view = toastView
                show()
            }
        }
        else{
            Log.d("toast", "$message")
            val toastView = layoutInflater.inflate(
                R.layout.toast_text_information,
                findViewById(R.id.toastLayoutInformation)
            )
            // Link Youtube -> https://www.youtube.com/watch?v=__GRhyvf6oE
            val textMessage = toastView.findViewById<TextView>(R.id.toastText)
            textMessage.text = message
            Log.d("toast", "${textMessage.text}")
            with(Toast(applicationContext))
            {
                duration = Toast.LENGTH_SHORT
                view = toastView
                show()
            }
        }

    }

    private fun goToProfile(username: String)
    {
        val intent = Intent(this, profilePage::class.java)
        intent.putExtra("username", username)
        startActivity(intent)
        overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right)
        finish()
    }

    private fun openSearchBar()
    {
        etSearch.isVisible=true
        studentConnectCurrentChat.isVisible = false
    }

    private fun closeSearchBar()
    {
        etSearch.isVisible=false
        etSearch.setText("").toString()
        studentConnectCurrentChat.isVisible = true
    }

    private fun goToNewChats(username: String)
    {
        val intent = Intent(this, newChat::class.java)
        intent.putExtra("username", username)
        intent.putExtra("fromCurrentChat", "true")
        startActivity(intent)
        overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left)
    }


    override fun onTouchEvent(event: MotionEvent?): Boolean {
        //Toast.makeText(this, "Swipe", Toast.LENGTH_SHORT).show()
        if(detector.onTouchEvent(event))
        {
            return true
        }
        else
        {
            return super.onTouchEvent(event)
        }

    }

    inner class DiaryGestureListener(username: String?) : GestureDetector.SimpleOnGestureListener()
    {
        private val username = username
        private val SWIPE_THREASHOLD = 100
        private val SWIPE_VELOCITY_THREASHOLD = 100


        override fun onFling(
            yAxisEvent: MotionEvent?,
            xAxisEvent: MotionEvent?,
            velocityX: Float,
            velocityY: Float
        ): Boolean {
            try {
                var diffX = xAxisEvent?.x?.minus(yAxisEvent!!.x) ?: 0.0F
                var diffY = yAxisEvent?.y?.minus(xAxisEvent!!.y) ?: 0.0F
                //Toast.makeText(this@mainFeed, "Swipe Right", Toast.LENGTH_SHORT).show()
                if (Math.abs(diffX) > Math.abs(diffY)) {
                    //Left or Right Swipe
                    if (Math.abs(diffX) > SWIPE_THREASHOLD && Math.abs(velocityX) > SWIPE_VELOCITY_THREASHOLD) {
                        if (diffX > 0) {
                            //Right Swipe
                            //Toast.makeText(this@mainFeed, "Swipe Right", Toast.LENGTH_SHORT).show()
                            return this@currentChats.onSwipeRight(username!!)
                        } else {
                            //Left Swipe
                            //Toast.makeText(this@mainFeed, "Swipe Left", Toast.LENGTH_SHORT).show()
                            return this@currentChats.onSwipeLeft(username!!)
                        }
                    } else {
                        return false
                    }
                } else {
                    //Up or down Swipe
                    if (Math.abs(diffY) > SWIPE_THREASHOLD && Math.abs(velocityY) > SWIPE_VELOCITY_THREASHOLD) {
                        if (diffY > 0) {
                            //Up Swipe
                            return this@currentChats.onSwipeUp()
                        } else {
                            //Bottom Swipe
                            return this@currentChats.onSwipeBottom()

                        }
                    } else {
                        return false
                    }
                }

                return super.onFling(yAxisEvent, xAxisEvent, velocityX, velocityY)
            }
            catch (e: java.lang.Exception)
            {
                return false
            }
        }

    }

    private fun onSwipeUp():Boolean {
        //Toast.makeText(this, "Swipe Up", Toast.LENGTH_SHORT).show()
        closeSearchBar()
        return false
    }

    private fun onSwipeBottom(): Boolean {
        //Toast.makeText(this, "Swipe Down", Toast.LENGTH_SHORT).show()
        openSearchBar()
        return false
    }

    private fun onSwipeLeft(username: String): Boolean {
        //Toast.makeText(this, "Swipe Left", Toast.LENGTH_SHORT).show()
        goToNewChats(username)
        return false
    }

    private fun onSwipeRight(username: String): Boolean {
        //Toast.makeText(this, "Swipe Right", Toast.LENGTH_SHORT).show()
        goToProfile(username)
        return false
    }

    @SuppressLint("RestrictedApi")
    private fun fetchUser(
        username: String,
        adapter: GroupAdapter<GroupieViewHolder>,
        arrayUser: MutableList<usersList>
    ){
        val db = FirebaseFirestore.getInstance()
        val user = db.collection("Users").document(username).collection("Chats")
        user.addSnapshotListener { value, error ->
            if(error != null || value == null){
                showToast("ERROR", 1)
                return@addSnapshotListener
            }

            for(document in value.documents){
                if(document.id != "Info"){
                        Log.d("adapter", "Document id = ${document.id}")
                        //Toast.makeText(this, "Document id = ${document.id}", Toast.LENGTH_SHORT).show()
                        adapter.add(CurrentChat_class(document.id, document["Text"].toString(), document["Name"].toString(), arrayUser, document["From"].toString()))
                        Log.d("adapter", "Done")
                        //Toast.makeText(this, "Done", Toast.LENGTH_SHORT).show()
                }
            }
            adapter.setOnItemClickListener { item, view ->
                val currentChat_class: CurrentChat_class = item as CurrentChat_class
                val to = currentChat_class.username
                db.collection("Users").document(username).collection("Chats").document(to)
                    .get()
                    .addOnSuccessListener {
                        if(it.exists()){
                            var count = it["Count"].toString().toInt()
                            count = (count / 1000) + 1
                            val info = hashMapOf(
                                    "Count" to count
                                    )
                            db.collection("Users").document(username).collection("Chat Users").document(to)
                                .set(info)
                                .addOnSuccessListener {
                                    val intent = Intent(this, chat::class.java)
                                    intent.putExtra("from", username)
                                    intent.putExtra("to", to)
                                    startActivity(intent)
                                    finish()
                                }
                        }
                    }
            }
            rvCurrentChats.adapter = adapter
        }
    }

    private fun searching(arrayUser: MutableList<usersList>, adapter: GroupAdapter<GroupieViewHolder>, username: String){
        val search = etSearch.text.toString()
        val pattern = search.toRegex(RegexOption.IGNORE_CASE)
        if(search == "" || search == null){
            for(document in arrayUser){
                adapter.add(CurrentChatSearch_class(document.username, document.text, document.name, document.url, document.type))
            }
        }
        else{
            for(document in arrayUser){
                if(pattern.containsMatchIn(document.name) || pattern.containsMatchIn(document.username)){
                    adapter.add(CurrentChatSearch_class(document.username, document.text, document.name, document.url, document.type))
                }
            }
        }
        adapter.setOnItemClickListener { item, view ->
            val currentChatSearch_class: CurrentChatSearch_class = item as CurrentChatSearch_class
            val to = currentChatSearch_class.username
            val intent = Intent(this, chat::class.java)
            intent.putExtra("from", username)
            intent.putExtra("to", to)
            startActivity(intent)
            finish()
        }
        rvCurrentChats.adapter = adapter
    }
}

data class usersList(var username: String, var text: String, var name: String, var url: String, var type: String){
}

class CurrentChat_class(val username: String, val text: String, val Name: String, val arrayUser: MutableList<usersList>, var from: String): Item<GroupieViewHolder>(){
    @SuppressLint("RestrictedApi")
    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.itemView.pbCurrentChat.isVisible = true
        val db = FirebaseFirestore.getInstance()
        var url = ""
        db.collection("Users").document(username)
            .get()
            .addOnSuccessListener {
                url = it.getString("Picture").toString()
                val temp = usersList(username, text, Name, url, from)
                arrayUser.add(temp)
                viewHolder.itemView.tv_usernames_latestMessage.text = username
                viewHolder.itemView.tv_text_latestMessage.text = text
                if((text == "This message was deleted") || (text == "Say Hi" && from == "System"))
                {
                    Log.d("currentchats", "in")
                    viewHolder.itemView.tv_text_latestMessage.setTypeface(null, Typeface.BOLD_ITALIC)
                    viewHolder.itemView.tv_text_latestMessage.setTextSize(14.0F)
                }

                val words = text.split("\\s+".toRegex()).map { word ->
                    word.replace("""^[,\.]|[,\.]$""".toRegex(), "")
                }
                var index = words.size - 1
                if(index >= 6 && from == "System"){
                    if((words[index] == "Friend" && words[index-1] == "a" && words[index-2] == "as" && words[0] == "Why" && words[1] == "don't" && words[2] == "you" && words[3] == "add") || (
                                words[1] == "is" && words[2] == "not" && words[3] == "in" && words[4] == "your" && words[5] == "Friend" && words[6] == "List"
                                )){
                        Log.d("currentchats", "in")
                        viewHolder.itemView.tv_text_latestMessage.setTypeface(null, Typeface.BOLD_ITALIC)
                        viewHolder.itemView.tv_text_latestMessage.setTextSize(14.0F)
                    }
                }
                Picasso.get().load(url).into(viewHolder.itemView.cv_dp_currentMessage, object :
                    Callback {
                    override fun onSuccess() {
                        viewHolder.itemView.pbCurrentChat.isVisible = false
                    }
                    override fun onError(e: java.lang.Exception?) {
                        Log.d("loading", "ERROR - $e")
                    }
                })
                Log.d("adapter", "adapter added")

                //TODO: Tap on specific item in recyclerview
//                viewHolder.itemView.tv_usernames_latestMessage.setOnClickListener {
//                    Log.d("clicked", "username clicked")
//                }
//                viewHolder.itemView.cv_dp_currentMessage.setOnClickListener {
//                    Log.d("clicked", "dp clicked")
//                }
            }
    }

    override fun getLayout(): Int {
        return R.layout.current_chat_adapter
    }
}

class CurrentChatSearch_class(val username: String, val text: String, val Name: String, val url: String, val type: String): Item<GroupieViewHolder>(){
    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.itemView.pbCurrentChat.isVisible = true
        viewHolder.itemView.tv_usernames_latestMessage.text = username
        viewHolder.itemView.tv_text_latestMessage.text = text

        if((text == "This message was deleted") || (text == "Say Hi" && type == "System"))
        {
            Log.d("currentchats", "in")
            viewHolder.itemView.tv_text_latestMessage.setTypeface(null, Typeface.BOLD_ITALIC)
            viewHolder.itemView.tv_text_latestMessage.setTextSize(14.0F)
        }

        val words = text.split("\\s+".toRegex()).map { word ->
            word.replace("""^[,\.]|[,\.]$""".toRegex(), "")
        }
        var index = words.size - 1
        if(index >= 6 && type == "System"){
            if((words[index] == "Friend" && words[index-1] == "a" && words[index-2] == "as" && words[0] == "Why" && words[1] == "don't" && words[2] == "you" && words[3] == "add") || (
                        words[1] == "is" && words[2] == "not" && words[3] == "in" && words[4] == "your" && words[5] == "Friend" && words[6] == "List"
                        )){
                Log.d("currentchats", "in")
                viewHolder.itemView.tv_text_latestMessage.setTypeface(null, Typeface.BOLD_ITALIC)
                viewHolder.itemView.tv_text_latestMessage.setTextSize(14.0F)
            }
        }


        Picasso.get().load(url).into(viewHolder.itemView.cv_dp_currentMessage, object : Callback {
            override fun onSuccess() {
                viewHolder.itemView.pbCurrentChat.isVisible = false
            }
            override fun onError(e: java.lang.Exception?) {
                Log.d("loading", "ERROR - $e")
            }
        })
        Log.d("adapter", "adapter added")
    }

    override fun getLayout(): Int {
        return R.layout.current_chat_adapter
    }

}
