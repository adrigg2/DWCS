package com.example.empleado.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.empleado.domain.Empleado;
import com.example.empleado.repositories.EmpleadoRepository;

@Service
@Primary
public class EmpleadoServiceImplBD implements EmpleadoService {

    @Autowired
    EmpleadoRepository repositorio;

    @Autowired
    DepartamentoService departamentoService;

    public Empleado add(Empleado e) {
        e.getDepartamento().setNumEmpleados(e.getDepartamento().getNumEmpleados() + 1);
        departamentoService.edit(e.getDepartamento());
        return repositorio.save(e);
    }

    public List<Empleado> findAll() {
        return repositorio.findAll();
    }

    public Empleado findById(long id) {
        return repositorio.findById(id).orElse(null);
    }

    public Empleado edit(Empleado e) {
        return repositorio.save(e);
    }

    public int delete(Long id) {
        Empleado e = repositorio.findById(id).orElse(null);
        if (e == null)
            return 0;
        int idDeleted = e.getId().intValue();
        repositorio.delete(e);
        return idDeleted;
    }

    @Override
    public int empleadosInDepartamento(Long id) {
        return repositorio.countEmpleadosByIdDepartamento(id);
    }

}
