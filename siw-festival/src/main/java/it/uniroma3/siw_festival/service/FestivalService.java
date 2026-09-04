package it.uniroma3.siw_festival.service;

import java.util.List;

import org.springframework.stereotype.Service;

import it.uniroma3.siw_festival.model.Festival;

import it.uniroma3.siw_festival.repository.FestivalRepository;

@Service 
public class FestivalService {

     private FestivalRepository festivalRepository;

    
    public FestivalService(FestivalRepository festivalRepository) {
        this.festivalRepository = festivalRepository;

    }

    public Festival findById(Long id){
        return festivalRepository.findById(id).get();
    }

    public List<Festival> findAll () {
        return (List<Festival>) festivalRepository.findAll();
    }


}
