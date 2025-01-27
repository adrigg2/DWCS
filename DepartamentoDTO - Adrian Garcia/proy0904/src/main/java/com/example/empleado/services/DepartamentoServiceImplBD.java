package com.example.empleado.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.empleado.domain.Departamento;
import com.example.empleado.repositories.DepartamentoRepository;
import com.example.empleado.repositories.EmpleadoRepository;

@Service
@Primary
public class DepartamentoServiceImplBD implements DepartamentoService {

    @Autowired
    private DepartamentoRepository departamentoRepository;

    @Autowired
    private EmpleadoRepository empleadoRepository;

    public Departamento add(Departamento e) {
        e.setNumEmpleados(empleadoRepository.countEmpleadosByIdDepartamento(e.getId()));
        return departamentoRepository.save(e);
    }

    public List<Departamento> findAll() {
        return departamentoRepository.findAll();
    }

    public Departamento findById(long id) {
        return departamentoRepository.findById(id).orElse(null);
    }

    public Departamento edit(Departamento d) {
        return departamentoRepository.save(d);
    }

    public void delete(Long id) {
        departamentoRepository.deleteById(id);
    }

    public Departamento findByNombre(String nombre) {
        return departamentoRepository.findByNombre(nombre);
    }
}
