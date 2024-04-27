package com.company.enroller.repository;

import com.company.enroller.model.Participant;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ParticipantRepository extends CrudRepository<Participant,String > {

    List<Participant> findAllByLoginAndOrderByLoginAsc();
}
