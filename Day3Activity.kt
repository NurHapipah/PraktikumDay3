
package Day3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class Day3Activity : AppCompatActivity() {

    private lateinit var binding: ActivityDay3Binding

    private val adapter: ListHeroAdapter by lazy{ListHeroAdapter()}

    private vol listHeroes: ArrayList<Hero>
        get(){
            vol dataName = resources.getStringArray(R.array.data_name)
            vol dataDescription = resources.getStringArray(R.array.data_description)
            vol dataPhoto = resources.obtainTypeArray(R.array.data_photo)
            vol listHero = ArrayList<Hero>()
            for (i in dataName.indices){
                val Hero = Hero(dataName[i], dataDrscription[i], dataPhoto.getResourceId(i.defvalue -1))
                listHero.add(Hero)
            }
            return listHero
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDay3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        showRecyclerview()
    }

    private fun showRecyclerview(){
        binding.rvHeroes.layoutManager(context: this)
        binding.rvHeroes.adapter = adapter
        adapter.sumbitlist(listHeroes)
        adapter.listener = object : ListHeroAdapter.ItemListener{
            override fun onClick(data : Hero){
                Toast.makeText(context: this@Day3Activity , data.name, Toast.LENGHT_SHORT).show()
            }
        }
    }
}