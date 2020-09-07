package com.springboot.joc_daus.controller;

import com.springboot.joc_daus.model.User;
import com.springboot.joc_daus.repository.app.Game.ControlGame;
import com.springboot.joc_daus.repository.app.Game.VerificarDatos;
import com.springboot.joc_daus.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class UserController {

    @Autowired
    private IUserService iUserService;

    private ControlGame controlGame = new ControlGame();
    private VerificarDatos verificarDatos = new VerificarDatos();


    @GetMapping("/list")
    public ResponseEntity<List<User>> llistar (){
        List<User> userList = iUserService.findAll();
        if (userList == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(userList);
        }
    }
    @PostMapping("/insert")
    public ResponseEntity<User> insert(@Validated User user, BindingResult result) throws Exception {

        if (result.hasErrors()) {
            throw new Exception("No puede haber campos vacios !" );
        }
        List<User> userList = iUserService.findAll();
        user = verificarDatos.verificarUserName(user, userList);
        user = verificarDatos.asignarValoresUser(user, "");
        // No me parece la manera más correcta de rechazar el UserName, pero de momento No Acepta Nombre Repetido
        if(user.getUserName().equalsIgnoreCase("ERROR.. USUARIO YA EXISTENTE !")) return new ResponseEntity<>(user, HttpStatus.NOT_ACCEPTABLE);
        iUserService.save(user);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }
    //
    @PostMapping("/actualizar/{idUser}")
    public ResponseEntity<User> actualizar(@Validated User user, @PathVariable int idUser){
        Optional<User> userOriginal = iUserService.findById(idUser);// obtener User original
        user = verificarDatos.editarUser(userOriginal.get(), user); // Solo modifica el userName
        iUserService.save(user);
        return  new ResponseEntity<User>(user, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{idUser}")
    public HttpStatus deleteUser(@PathVariable int idUser){
        iUserService.deleteById(idUser);
        return HttpStatus.OK;
    }

    @GetMapping("/rankingMigTotal")
    public ResponseEntity<Integer> listRanking (){
        List<User> userList = iUserService.findAll();
        int percentatge = controlGame.calcularRankingTotal(userList);
        return  ResponseEntity.ok(percentatge);
    }
    @GetMapping("/rankingLoser")
    public ResponseEntity<User> rankingLoser (){
        List<User> userList = iUserService.findAll();
        User user = controlGame.rankingLoserWinner(userList, "min");
        return  ResponseEntity.ok(user);
    }
    @GetMapping("/rankingWinner")
    public ResponseEntity<User> rankingWinner (){
        List<User> userList = iUserService.findAll();
        User user = controlGame.rankingLoserWinner(userList, "max");
        return  ResponseEntity.ok(user);
    }


}
