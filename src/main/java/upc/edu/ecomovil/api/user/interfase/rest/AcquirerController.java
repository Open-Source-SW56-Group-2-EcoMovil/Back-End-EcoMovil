package upc.edu.ecomovil.api.user.interfase.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upc.edu.ecomovil.api.user.domain.model.queries.Acquirer.GetAllAcquirerQuery;
import upc.edu.ecomovil.api.user.domain.services.AcquirerCommandService;
import upc.edu.ecomovil.api.user.domain.services.AcquirerQueryService;
import upc.edu.ecomovil.api.user.interfase.rest.resources.acquirer.CreateAcquirerResource;
import upc.edu.ecomovil.api.user.interfase.rest.resources.acquirer.AcquirerResource;
import upc.edu.ecomovil.api.user.interfase.rest.transform.acquirer.CreateAcquirerCommandFromResourceAssembler;
import upc.edu.ecomovil.api.user.interfase.rest.transform.acquirer.AcquirerResourceFromEntityAssembler;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "api/v1/acquirers", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Acquirers", description = "Acquirer Management Endpoints")
public class AcquirerController {
    private final AcquirerQueryService acquirerQueryService;
    private final AcquirerCommandService acquirerCommandService;

    public AcquirerController(AcquirerQueryService acquirerQueryService, AcquirerCommandService acquirerCommandService) {
        this.acquirerQueryService = acquirerQueryService;
        this.acquirerCommandService = acquirerCommandService;
    }


    @Operation(
            summary = "Create a Acquirer",
            description = "Creates a Acquirer with the provided data")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Acquirer created"),
            @ApiResponse(responseCode = "400", description = "Bad request")
    })
    @PostMapping
    public ResponseEntity<StudentResource> createProfile(@RequestBody CreateAcquirerResource resource) {
        var createAcquirerCommand = CreateAcquirerCommandFromResourceAssembler.toCommandFromResource(resource);
        var acquirer = acquirerCommandService.handle(createAcquirerCommand);
        if (acquirer.isEmpty()) return ResponseEntity.badRequest().build();
        var acquirerResource = AcquirerResourceFromEntityAssembler.toResourceFromEntity(acquirer.get());
        return new ResponseEntity<>(acquirerResource, HttpStatus.CREATED);
    }


    @GetMapping
    public ResponseEntity<List<AcquirerResource>> getAllProfiles() {
        var getAllProfilesQuery = new GetAllAcquirerQuery();
        var acquirer = studentQueryService.handle(getAllProfilesQuery);
        var acquirerResources = acquirer.stream().map(AcquirerResourceFromEntityAssembler::toResourceFromEntity).collect(Collectors.toList());
        return ResponseEntity.ok(acquirerResources);
    }
}
