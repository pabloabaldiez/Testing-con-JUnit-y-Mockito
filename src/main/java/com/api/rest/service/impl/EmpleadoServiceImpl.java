package com.api.rest.service.impl;

import com.api.rest.exception.ResourceNotFoundException;
import com.api.rest.model.Empleado;
import com.api.rest.repository.EmpleadoRepository;
import com.api.rest.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Override
    public Empleado saveEmpleado(Empleado empleado) {

        Optional<Empleado> empleadoGuardado= empleadoRepository.findByEmail(empleado.getEmail());

        if(empleadoGuardado.isPresent())
            throw new ResourceNotFoundException("El empleado con ese email ya existe: " + empleado.getEmail());

        return empleadoRepository.save(empleado);
    }

    @Override
    public List<Empleado> getAllEmpleados() {

       List<Empleado>empleados= empleadoRepository.findAll();

       if (empleados.isEmpty())
        throw new ResourceNotFoundException("En este momento no hay empleados");

       return empleados;
    }

    @Override
    public Optional<Empleado> getEmpleadoById(long id) {
        return Optional.empty();
    }

    @Override
    public Empleado updateEmpleado(Empleado empleadoActualizado) {
        return null;
    }

    @Override
    public void deleteEmpleado(long id) {

    }
}
