package com.example.papb_10

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.papb_10.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val adapterHero = HeroAdapter(generateDummy()){ hero ->
            Toast.makeText(this@MainActivity, "You clicked on ${hero.nameHero}", Toast.LENGTH_SHORT).show()
        }
        with(binding){
            rvDisaster.apply{
                adapter = adapterHero
                layoutManager = LinearLayoutManager(this@MainActivity)
            }
        }
    }

    fun generateDummy(): List<Hero> {
        return listOf(
            Hero(nameHero = "Soekarno", typeHero = "Soekarno was the first President of Indonesia, serving from 1945 to 1967. He played a pivotal role in the country's struggle for independence from Dutch colonial rule.", "@drawable/soekarno"),
            Hero(nameHero = "Haji Agus Salim", typeHero = "A prominent diplomat and politician, Haji Agus Salim was a key figure in the early 20th-century Indonesian nationalist movement. He contributed to diplomatic efforts for Indonesia's independence.", "@drawable/agus_salim"),
            Hero(nameHero = "Cut Nyak Dien", typeHero = "Prince Diponegoro was a Javanese prince and national hero who led a rebellion against Dutch colonial rule in Java during the Java War (1825-1830).", "@drawable/cut_nyak_dien"),
            Hero(nameHero = "Kartini", typeHero = "Raden Adjeng Kartini was a Javanese noblewoman and pioneer in the area of women's rights. She is celebrated for her efforts to promote education for Indonesian women.", "@drawable/kartini"),
            Hero(nameHero = "Ahmad Yani", typeHero = "General Ahmad Yani was the commander of the Indonesian National Armed Forces and a national hero. He played a significant role in the early years of Indonesia's independence.", "@drawable/ahmad_yani"),
            Hero(nameHero = "Sultan Agung Hanyakrakusuma", typeHero = "Sultan Agung was a powerful ruler of the Mataram Sultanate in Java. He is remembered for his efforts to unite Javanese kingdoms and resist Dutch and Makassar influence.", "@drawable/sultan_agung_hanyakrakusuma"),
            Hero(nameHero = "Ki Hajar Dewantara", typeHero = "Ki Hajar Dewantara was an educator and a leading figure in the Indonesian independence movement. He is the founder of the Taman Siswa school system, emphasizing nationalistic education.", "@drawable/ki_hajar_dewantara")
        )
    }
}