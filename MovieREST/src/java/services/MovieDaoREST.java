/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.MovieDAO;
import entity.Movie;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Ida Maria Solli
 */
@Stateless
@Path("entity.movie")
public class MovieDaoREST {
    
    @Inject
    MovieDAO mDao;
    
    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Movie m) {
        mDao.createMovie(m);
    }
    
    @PUT
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit( Movie m) {
        mDao.updateMovie(m);
    }
    
    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") Long id) {
        mDao.removeMovie(id);
    }
    
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Movie getById(@PathParam("id") Long id) {
        return mDao.findById(id);
    }
    
    @GET
    @Path("t/{title}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Movie> getByTitle(@PathParam("title") String title) {
        return mDao.findByTitle(title);
    }
    
    @GET
    @Path("d/{director}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Movie> getByDirector(@PathParam("director") String director) {
        return mDao.findByDirector(director);
    }
    
    @GET
    @Path("y/{year}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Movie> getByYear(@PathParam("year") int year) {
        return mDao.findByYear(year);
    }

    
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Movie> getAll() {
        return mDao.findAll();
    }

}
