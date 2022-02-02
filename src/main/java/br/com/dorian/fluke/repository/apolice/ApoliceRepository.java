package br.com.dorian.fluke.repository.apolice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.dorian.fluke.model.apolice.Apolice;

@Repository
public interface ApoliceRepository extends JpaRepository<Apolice, Long>{

}
