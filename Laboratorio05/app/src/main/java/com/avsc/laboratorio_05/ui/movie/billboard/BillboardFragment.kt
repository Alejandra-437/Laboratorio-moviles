package com.avsc.laboratorio_05.ui.movie.billboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.avsc.laboratorio_05.R
import com.avsc.laboratorio_05.data.model.MovieModel
import com.avsc.laboratorio_05.databinding.FragmentBillboardBinding
import com.avsc.laboratorio_05.ui.movie.MovieViewModel
import com.avsc.laboratorio_05.ui.movie.billboard.recycleview.MovieRecyclerViewAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
/**
 * A simple [Fragment] subclass.
 * Use the [billboardFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class billboardFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private val movieViewModel: MovieViewModel by activityViewModels {
        MovieViewModel.Factory
    }
    private lateinit var adapter: MovieRecyclerViewAdapter

    private lateinit var binding: FragmentBillboardBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBillboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setRecyclerView(view)

        binding.btnLinkNewMovie.setOnClickListener{
            movieViewModel.clearData()
            it.findNavController().navigate(R.id.action_billboardFragment_to_newMovieFragment)
        }
    }
    private fun showSelectedItem(movie: MovieModel){
        movieViewModel.setSelectedMovie(movie)
        findNavController().navigate(R.id.action_billboardFragment_to_movieFragment)
    }

    private fun setRecyclerView(view: View){
        binding.recycleView.layoutManager = LinearLayoutManager(view.context)

        adapter = MovieRecyclerViewAdapter{ selectedMovie ->
            showSelectedItem(selectedMovie)
        }

        binding.recycleView.adapter = adapter
        displayMovies()
    }

    private fun displayMovies(){
        adapter.setData(movieViewModel.getMovies())
        adapter.notifyDataSetChanged()
    }




}