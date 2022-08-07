package developer.abdulahad.homework184

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import developer.abdulahad.homework184.Adapter.SherAdapter
import developer.abdulahad.homework184.Models.Sher
import developer.abdulahad.homework184.Models.SherListObject
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialog
import developer.abdulahad.homework184.databinding.FragmentListBinding
import kotlinx.android.synthetic.main.dialog_view.view.*
import kotlinx.android.synthetic.main.fragment_list.*
import kotlinx.android.synthetic.main.fragment_list.view.*


class ListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding
    private lateinit var rvList: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListBinding.inflate(layoutInflater)
        rvList = binding.rvList

        binding.apply {
            btnBack.setOnClickListener {
                findNavController().popBackStack()
            }
            when (arguments?.getInt("key0")) {
                1 -> {
                    binding.txtsherTuri.text = "YANGI\nSHERLAR"
                    rvList.adapter = SherAdapter(SherListObject.yangilarList, object : SherAdapter.OnMyItemClickListener {
                        override fun onMyItemClck(position: Int) {
                            myItemClick(SherListObject.yangilarList, position, true)
                        }
                    })
                }
                2 -> {
                    binding.txtsherTuri.text = "SAQLANGAN\nSHERLAR"
                    rvList.adapter = SherAdapter(SherListObject.saqlanganList, object : SherAdapter.OnMyItemClickListener {
                        override fun onMyItemClck(position: Int) {
                            myItemClick(SherListObject.saqlanganList, position, false)
                        }
                    })
                }
                3 -> {
                    binding.txtsherTuri.text = "SEVGI\nSHERLARI"
                    rvList.adapter = SherAdapter(SherListObject.sevgiList, object : SherAdapter.OnMyItemClickListener {
                        override fun onMyItemClck(position: Int) {
                            myItemClick(SherListObject.sevgiList, position, true)
                        }
                    })
                }
                4 -> {
                    binding.txtsherTuri.text = "SOG'INCH\nARMON"
                    rvList.adapter = SherAdapter(SherListObject.soginchList, object : SherAdapter.OnMyItemClickListener {
                        override fun onMyItemClck(position: Int) {
                            myItemClick(SherListObject.soginchList, position, true)
                        }
                    })
                }
                5 -> {
                    binding.txtsherTuri.text = "TABRIK\nSHERLARI"
                    rvList.adapter = SherAdapter(SherListObject.tabrikList, object : SherAdapter.OnMyItemClickListener {
                        override fun onMyItemClck(position: Int) {
                            myItemClick(SherListObject.tabrikList, position, true)
                        }
                    })
                }
                6 -> {
                    binding.txtsherTuri.text = "OTA-ONA XAQIDA\nSHERLARI"
                    rvList.adapter = SherAdapter(SherListObject.otaOnaList, object : SherAdapter.OnMyItemClickListener {
                        override fun onMyItemClck(position: Int) {
                            myItemClick(SherListObject.otaOnaList, position, true)
                        }
                    })
                }
                7 -> {
                    binding.txtsherTuri.text = "DO'STLIK\nSHERLARI"
                    rvList.adapter = SherAdapter(SherListObject.dostlikList, object : SherAdapter.OnMyItemClickListener {
                        override fun onMyItemClck(position: Int) {
                            myItemClick(SherListObject.dostlikList, position, true)
                        }
                    })
                }
                8 -> {
                    binding.txtsherTuri.text = "HAZIL\nSHERLAR"
                    rvList.adapter = SherAdapter(SherListObject.hazilList, object : SherAdapter.OnMyItemClickListener {
                        override fun onMyItemClck(position: Int) {
                            myItemClick(SherListObject.hazilList, position, true)
                        }
                    })
                }
            }
        }

        return binding.root
    }

    fun myItemClick(list: ArrayList<Sher>, position: Int, isList: Boolean) {
        var list1 = ArrayList<Sher>()
        list1 = list
        val bottom = BottomSheetDialog(binding.root.context)
        val item =
            bottom.layoutInflater.inflate(R.layout.dialog_view, null, false)
        item.txt_dialog_name.text = list[position].name
        item.txt_dialog_text.text = list[position].matni
        if (list[position].like) {
            item.rasm_yurak_dialog.setImageResource(R.drawable.ic_sher_saqlanganda)
        } else {
            item.rasm_yurak_dialog.setImageResource(R.drawable.ic_love)
        }
        item.card_sms_dialog.setOnClickListener {
            val uri: Uri = Uri.parse("smsto:")
            val intent = Intent(Intent.ACTION_SENDTO, uri)
            intent.putExtra("sms_body", list[position].matni)
            startActivity(intent)
        }
        item.rasm_yurak_dialog.setOnClickListener {
            if (isList) {
                if (!list[position].like) {
                    SherListObject.saqlanganList.add(
                        list[position]
                    )
                    bottom.cancel()
                    SherListObject.info = list
                    rvList.adapter?.notifyItemChanged(position)
                } else {
                    SherListObject.saqlanganList.remove(list[position])
                    bottom.cancel()
                    rvList.adapter?.notifyItemChanged(position)
                }
                list[position].like = !list[position].like
            } else {
                list.removeAt(position)
                SherListObject.info[position].like = !SherListObject.info[position].like
                bottom.cancel()
                rvList.adapter?.notifyItemRemoved(position)
            }
        }
        item.card_share_dialog.setOnClickListener {
            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(
                    Intent.EXTRA_TEXT,
                    "Name: ${list[position].name}\n\n${list[position].matni}\n\nAuthor: Abdulaziz_Developer"
                )
                type = "text/plain"
            }
            startActivity(
                Intent.createChooser(sendIntent, list[position].name)
            )
        }
        item.card_copy_dialog.setOnClickListener {

        }
        bottom.setContentView(item)
        bottom.show()
    }
}