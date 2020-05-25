package com.paw.controller;

import com.paw.entity.ArrayEntity;
import com.paw.entity.CardEntity;
import com.paw.entity.ListEntity;
import com.paw.service.ProjectService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    @GetMapping("/tables")
    @ApiOperation(value = "", authorizations = { @Authorization(value="jwtToken") })
    public ResponseEntity<List<ArrayEntity>> getTables(){
        return new ResponseEntity<>(projectService.getArrays(), HttpStatus.OK);
    }

    @GetMapping("/table/{id}")
    @ApiOperation(value = "", authorizations = { @Authorization(value="jwtToken") })
    public ResponseEntity<ArrayEntity> getTable(@PathVariable Long id) {
        ArrayEntity table = projectService.getArray(id);
        if (table != null) {
            return new ResponseEntity<>(table, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @PostMapping("/table")
    @ApiOperation(value = "", authorizations = { @Authorization(value="jwtToken") })
    public ResponseEntity createTable(@RequestParam String name) {
        try {
            projectService.createArray(name);
            return new ResponseEntity(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
    }

    @PutMapping("/table/{id}")
    @ApiOperation(value = "", authorizations = { @Authorization(value="jwtToken") })
    public ResponseEntity<ArrayEntity> updateTable(@PathVariable Long id, @RequestParam String name) {
        ArrayEntity table = projectService.updateArray(id, name);
        if (table != null) {
            return new ResponseEntity<>(table, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/list/{id}")
    @ApiOperation(value = "", authorizations = { @Authorization(value="jwtToken") })
    public ResponseEntity getListItem(@PathVariable Long id) {
        ListEntity listItem = projectService.getListItem(id);
        if (listItem != null) {
            return new ResponseEntity<>(listItem, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/list/")
    @ApiOperation(value = "", authorizations = { @Authorization(value="jwtToken") })
    public ResponseEntity createListItem(@RequestParam Long arrayId, @RequestParam String listItemName) {
        try {
            projectService.createListItem(arrayId, listItemName);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
    }

    @PutMapping("/list/{id}")
    @ApiOperation(value = "", authorizations = { @Authorization(value="jwtToken") })
    public ResponseEntity updateListItemName(@PathVariable Long id, @RequestParam String name) {
        ListEntity listItem = projectService.updateListItemName(id, name);
        if (listItem != null) {
            return new ResponseEntity<>(listItem, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/card/{id}")
    @ApiOperation(value = "", authorizations = { @Authorization(value="jwtToken") })
    public ResponseEntity getCard(@PathVariable Long id) {
        CardEntity card = projectService.getCard(id);
        if (card != null) {
            return new ResponseEntity<>(card, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/card/")
    @ApiOperation(value = "", authorizations = { @Authorization(value="jwtToken") })
    public ResponseEntity createCard(@RequestParam Long listId, @RequestParam String cardName) {
        try {
            projectService.createCard(listId, cardName);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
    }

    @PutMapping("/card/{id}")
    @ApiOperation(value = "", authorizations = { @Authorization(value="jwtToken") })
    public ResponseEntity updateCardName(@PathVariable Long id, @RequestParam String name) {
        CardEntity card = projectService.updateCardName(id, name);
        if (card != null) {
            return new ResponseEntity<>(card, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }



}
