package id.ginanjar.authentication.repository;

import id.ginanjar.authentication.model.Pengguna;

import java.util.List;

public interface PenggunaRepository {
    List<Pengguna> findAll();

    int save(Pengguna pengguna);
}