package com.example.user.lab10sqllitedatabases;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface DAO {
    @Insert
    public void insertStudent(Student student);

   @Query("select * from Student")
    public List<Student> getStudent();

   @Delete
   public  void deleteStudent(Student student);

   @Update
    public void updateStudent(Student student);


}
