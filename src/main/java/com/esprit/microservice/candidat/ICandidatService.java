package com.esprit.microservice.candidat;

import java.util.List;

public interface ICandidatService {
    public List<Candidat> getAll();
    public Candidat addCandidat(Candidat c);
    public String deleteCandidat(int id) ;
    public Candidat updateCandidat(int id, Candidat newCandidat) ;
}
