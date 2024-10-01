package com.example.demo.Service1;


import com.example.demo.Service1.IdentityService;
import com.example.demo.Service1.Identity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/identidades")
public class IdentityController {

    @Autowired
    private IdentityService identityService;


    @GetMapping("/verificar")
    public ResponseEntity<Boolean> verificarCi(@RequestParam String ci) {
        boolean existe = identityService.verificarCiExistente(ci);
        return ResponseEntity.ok(existe);
    }

    @PostMapping("/agregar")
    public ResponseEntity<Void> agregarIdentidad(@RequestBody Identity identidad) {
        identityService.addIdentidad(identidad);
        return ResponseEntity.ok().build();
    }
}
