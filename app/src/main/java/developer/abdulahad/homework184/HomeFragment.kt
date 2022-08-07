package developer.abdulahad.homework184

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import developer.abdulahad.homework184.Models.Sher
import developer.abdulahad.homework184.Models.SherListObject
import developer.abdulahad.homework184.databinding.FragmentHomeBinding
import developer.abdulahad.homework184.databinding.FragmentListBinding
import developer.abdulahad.homework184.objektlar.PutInt
import kotlinx.android.synthetic.main.fragment_home.view.*


class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
    lateinit var list: SherListObject
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater)


       loadData()

        binding.tvYangiliklar.text = "${SherListObject.yangilarList.size}"
        binding.tvSaqlangan.text = "${SherListObject.saqlanganList.size}"

        binding.cardSevgiCard.setOnClickListener {
            val bundle = Bundle()
            bundle.putInt("key0", 3)
            findNavController().navigate(R.id.listFragment, bundle)
        }
        binding.cardSoginchCard.setOnClickListener {
            val bundle = Bundle()
            bundle.putInt("key0", 4)
            findNavController().navigate(R.id.listFragment, bundle)
        }
        binding.cardTabrikCard.setOnClickListener {
            val bundle = Bundle()
            bundle.putInt("key0", 5)
            findNavController().navigate(R.id.listFragment, bundle)
        }
        binding.cardOtaOnaCard.setOnClickListener {
            val bundle = Bundle()
            bundle.putInt("key0", 6)
            findNavController().navigate(R.id.listFragment, bundle)
        }
        binding.cardDostlikCard.setOnClickListener {
            val bundle = Bundle()
            bundle.putInt("key0", 7)
            findNavController().navigate(R.id.listFragment, bundle)
        }
        binding.cardHazilCard.setOnClickListener {
            val bundle = Bundle()
            bundle.putInt("key0", 8)
            findNavController().navigate(R.id.listFragment, bundle)
        }
        binding.card1Yangilik.setOnClickListener {
            val bundle = Bundle()
            bundle.putInt("key0", 1)
            findNavController().navigate(R.id.listFragment, bundle)
        }
        binding.card1Saqlangalar.setOnClickListener {
            val bundle = Bundle()
            bundle.putInt("key0", 2)
            findNavController().navigate(R.id.listFragment, bundle)
        }
        return binding.root
    }

    fun loadData(){

        if(SherListObject.sevgiList.isEmpty()){
            SherListObject.sevgiList.add(
                Sher(
                    "Oshiq derlar meni", "Ko’zlarim ko’r bo’lsa, ko’rmasdim seni,\n" +
                            "Yuragim tosh bo’lsa, sevmasdim seni,\n" +
                            "Mayli xijron azobi qiynasin meni,\n" +
                            "O’lsam ham baribir sevaman seni!"
                    ,false)
            )
            SherListObject.sevgiList.add(
                Sher(
                    "Oshiq derlar meni", "Ko’zlarim ko’r bo’lsa, ko’rmasdim seni,\n" +
                            "Yuragim tosh bo’lsa, sevmasdim seni,\n" +
                            "Mayli xijron azobi qiynasin meni,\n" +
                            "O’lsam ham baribir sevaman seni!"
                    ,false)
            )
        }

        if(SherListObject.soginchList.isEmpty()){
            SherListObject.soginchList.add(
                Sher("Oshiq derlar meni", "Ko’zlarim ko’r bo’lsa, ko’rmasdim seni,\n" +
                        "Yuragim tosh bo’lsa, sevmasdim seni,\n" +
                        "Mayli xijron azobi qiynasin meni,\n" +
                        "O’lsam ham baribir sevaman seni!",false)
            )
            SherListObject.soginchList.add(
                Sher("Oshiq derlar meni", "Ko’zlarim ko’r bo’lsa, ko’rmasdim seni,\n" +
                        "Yuragim tosh bo’lsa, sevmasdim seni,\n" +
                        "Mayli xijron azobi qiynasin meni,\n" +
                        "O’lsam ham baribir sevaman seni!",false)
            )
        }

        if(SherListObject.tabrikList.isEmpty()){

            SherListObject.tabrikList.add(
                Sher("Oshiq derlar meni", "Ko’zlarim ko’r bo’lsa, ko’rmasdim seni,\n" +
                        "Yuragim tosh bo’lsa, sevmasdim seni,\n" +
                        "Mayli xijron azobi qiynasin meni,\n" +
                        "O’lsam ham baribir sevaman seni!",false)
            )
            SherListObject.tabrikList.add(
                Sher("Oshiq derlar meni", "Ko’zlarim ko’r bo’lsa, ko’rmasdim seni,\n" +
                        "Yuragim tosh bo’lsa, sevmasdim seni,\n" +
                        "Mayli xijron azobi qiynasin meni,\n" +
                        "O’lsam ham baribir sevaman seni!",false)
            )
        }

        if(SherListObject.otaOnaList.isEmpty()){

            SherListObject.otaOnaList.add(
                Sher("Oshiq derlar meni", "Ko’zlarim ko’r bo’lsa, ko’rmasdim seni,\n" +
                        "Yuragim tosh bo’lsa, sevmasdim seni,\n" +
                        "Mayli xijron azobi qiynasin meni,\n" +
                        "O’lsam ham baribir sevaman seni!",false)
            )
            SherListObject.otaOnaList.add(
                Sher("Oshiq derlar meni", "Ko’zlarim ko’r bo’lsa, ko’rmasdim seni,\n" +
                        "Yuragim tosh bo’lsa, sevmasdim seni,\n" +
                        "Mayli xijron azobi qiynasin meni,\n" +
                        "O’lsam ham baribir sevaman seni!",false)
            )
        }

        if(SherListObject.dostlikList.isEmpty()){
            SherListObject.dostlikList.add(
                Sher("Oshiq derlar meni", "Ko’zlarim ko’r bo’lsa, ko’rmasdim seni,\n" +
                        "Yuragim tosh bo’lsa, sevmasdim seni,\n" +
                        "Mayli xijron azobi qiynasin meni,\n" +
                        "O’lsam ham baribir sevaman seni!",false)
            )
            SherListObject.dostlikList.add(
                Sher("Oshiq derlar meni", "Ko’zlarim ko’r bo’lsa, ko’rmasdim seni,\n" +
                        "Yuragim tosh bo’lsa, sevmasdim seni,\n" +
                        "Mayli xijron azobi qiynasin meni,\n" +
                        "O’lsam ham baribir sevaman seni!",false)
            )
        }


        if(SherListObject.hazilList.isEmpty()){
            SherListObject.hazilList.add(
                Sher("Oshiq derlar meni", "Ko’zlarim ko’r bo’lsa, ko’rmasdim seni,\n" +
                        "Yuragim tosh bo’lsa, sevmasdim seni,\n" +
                        "Mayli xijron azobi qiynasin meni,\n" +
                        "O’lsam ham baribir sevaman seni!",false)
            )
            SherListObject.hazilList.add(
                Sher("Oshiq derlar meni", "Ko’zlarim ko’r bo’lsa, ko’rmasdim seni,\n" +
                        "Yuragim tosh bo’lsa, sevmasdim seni,\n" +
                        "Mayli xijron azobi qiynasin meni,\n" +
                        "O’lsam ham baribir sevaman seni!",false)
            )
        }


        if(SherListObject.yangilarList.isEmpty()){
            SherListObject.yangilarList.add(
                Sher("Oshiq derlar meni", "Ko’zlarim ko’r bo’lsa, ko’rmasdim seni,\n" +
                        "Yuragim tosh bo’lsa, sevmasdim seni,\n" +
                        "Mayli xijron azobi qiynasin meni,\n" +
                        "O’lsam ham baribir sevaman seni!",false)
            )


            SherListObject.yangilarList.add(
                Sher("Oshiq derlar meni", "Ko’zlarim ko’r bo’lsa, ko’rmasdim seni,\n" +
                        "Yuragim tosh bo’lsa, sevmasdim seni,\n" +
                        "Mayli xijron azobi qiynasin meni,\n" +
                        "O’lsam ham baribir sevaman seni!",false)
            )

        }

}
}