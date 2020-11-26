package id.ginanjar.authentication.controller;

import id.ginanjar.authentication.model.Pengguna;
import id.ginanjar.authentication.repository.jdbc.JdbcPenggunaRepository;
import id.ginanjar.authentication.utils.HashUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.NoSuchAlgorithmException;

@Controller
@RequestMapping("registrasi")
public class RegistrasiController {
    private static final Logger log = LoggerFactory.getLogger(RegistrasiController.class);

    private final JdbcPenggunaRepository jdbcPenggunaRepository;

    public RegistrasiController(JdbcPenggunaRepository jdbcPenggunaRepository) {
        this.jdbcPenggunaRepository = jdbcPenggunaRepository;
    }

    @GetMapping("")
    public String index(Pengguna pengguna) {

        return "registrasi/index";
    }

    @PostMapping("")
    public String postAdd(Pengguna pengguna, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "registrasi/index";
        }
        try {
            pengguna.setPassword(HashUtility.hash(pengguna.getPassword()));
        } catch (NoSuchAlgorithmException e) {
            log.error("Error ", e);
        }
        jdbcPenggunaRepository.save(pengguna);
        return "redirect:/pengguna";
    }
}