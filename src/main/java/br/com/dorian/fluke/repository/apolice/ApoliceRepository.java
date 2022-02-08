package br.com.dorian.fluke.repository.apolice;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.dorian.fluke.model.apolice.Apolice;

public interface ApoliceRepository extends JpaRepository<Apolice, UUID>{

}
