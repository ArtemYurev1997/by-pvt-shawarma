package by.pvt.shawarma.core.controller;

import by.pvt.shawarma.api.contract.AdminApi;
import by.pvt.shawarma.api.controller.AdminApiController;
import by.pvt.shawarma.api.dto.AdminRequest;
import by.pvt.shawarma.api.dto.AdminResponse;
import jakarta.servlet.ServletException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdminController implements AdminApiController {
    private final AdminApi adminApi;

    public AdminController(@Qualifier("adminServiceApi") AdminApi adminApi) {
        this.adminApi = adminApi;
    }

    @GetMapping("/getAll")
    public List<AdminResponse> findAll() {
        return adminApi.getAllAdmins();
    }

    @PostMapping("/add")
    public AdminResponse add(@RequestBody @Validated AdminRequest adminRequest) {
        return adminApi.register(adminRequest);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        adminApi.delete(id);
    }


    @PostMapping("/update")
    public List<AdminResponse> update(@RequestBody AdminRequest adminRequest) {
        return adminApi.update(adminRequest);
    }

    @GetMapping("/{id}")
    public AdminResponse findById(@PathVariable("id") Long id) {
        return adminApi.findAdminById(id);
    }

    @PostMapping("/authorise")
    public AdminResponse authorise(@RequestBody AdminRequest adminRequest) throws ServletException {
        return adminApi.authorise(adminRequest);
    }
}
