package com.golfmaven.dao;

import com.golfmaven.models.Golfer;

import java.util.List;

public interface GolferDao {

    // CREATE
    Golfer create(Golfer golfer);

    // READ
    List<Golfer> getAllGolfers();

    Golfer getGolferById(int id);

    // UPDATE
    Golfer update(Golfer golfer, int id);

    // DELETE
    boolean delete(int id);
}
