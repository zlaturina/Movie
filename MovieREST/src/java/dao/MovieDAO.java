/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Movie;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Ida Maria Solli
 */
@Stateless
public class MovieDAO {

    @PersistenceContext(name = "MovieRESTPU")
    EntityManager em;

    public void createMovie(Movie m) {
        em.persist(m);
    }

    public void updateMovie(Movie m) {
        em.merge(m);
    }

    public void removeMovie(Long id) {
        em.remove(em.merge(em.find(Movie.class, id)));
    }

    public Movie findById(Long id) {
        return em.find(Movie.class, id);
    }

    public List<Movie> findByTitle(String title) {
        TypedQuery<Movie> query = em.createQuery("SELECT t FROM Movie t WHERE t.title = :title", Movie.class);
        return query.setParameter("title", title).getResultList();
        
//        return em.find(Movie.class, title);
    }

    public List<Movie> findByDirector(String director) {
        TypedQuery<Movie> query = em.createQuery(
                "SELECT d FROM Movie d WHERE d.director = :director", Movie.class);
        return query.setParameter("director", director).getResultList();

    }
    
    public List<Movie> findByYear(int year) {
        TypedQuery<Movie> query = em.createQuery("SELECT y FROM Movie y WHERE y.year = :year", Movie.class);
        return query.setParameter("year", year).getResultList();
    }
    

    

    public List<Movie> findAll() {
        return em.createQuery("SELECT m FROM Movie m").getResultList();
    }

}
