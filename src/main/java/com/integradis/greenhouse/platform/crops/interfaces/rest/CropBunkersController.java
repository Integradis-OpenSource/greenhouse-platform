package com.integradis.greenhouse.platform.crops.interfaces.rest;

import com.integradis.greenhouse.platform.crops.domain.model.queries.GetBunkerByIdQuery;
import com.integradis.greenhouse.platform.crops.domain.model.queries.GetBunkerEntriesByCropIdQuery;
import com.integradis.greenhouse.platform.crops.domain.services.BunkerCommandService;
import com.integradis.greenhouse.platform.crops.domain.services.BunkerQueryService;
import com.integradis.greenhouse.platform.crops.interfaces.rest.resources.BunkerResource;
import com.integradis.greenhouse.platform.crops.interfaces.rest.resources.CreateBunkerResource;
import com.integradis.greenhouse.platform.crops.interfaces.rest.transform.BunkerResourceFromEntityAssembler;
import com.integradis.greenhouse.platform.crops.interfaces.rest.transform.CreateBunkerCommandFromResourceAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api/v1/crops/{cropId}/bunker")
@Tag(name = "Crops")
public class CropBunkersController {
    private final BunkerQueryService bunkerQueryService;
    private final BunkerCommandService bunkerCommandService;

    public CropBunkersController(BunkerQueryService bunkerQueryService, BunkerCommandService bunkerCommandService) {
        this.bunkerQueryService = bunkerQueryService;
        this.bunkerCommandService = bunkerCommandService;
    }

    @GetMapping
    public ResponseEntity<List<BunkerResource>> getBunkerEntriesByCropId(@PathVariable Long cropId){
        var getBunkerEntriesByCropId = new GetBunkerEntriesByCropIdQuery(cropId);
        var entries = bunkerQueryService.handle(getBunkerEntriesByCropId);
        if (entries.isEmpty()) return ResponseEntity.badRequest().build();
        var bunkerResource = entries.stream().map((BunkerResourceFromEntityAssembler::toResourceFromEntity)).toList();
        return ResponseEntity.ok(bunkerResource);
    }

    @PostMapping
    public ResponseEntity<BunkerResource> createBunker(@PathVariable Long cropId, @RequestBody CreateBunkerResource resource){
        var createBunkerCommand = CreateBunkerCommandFromResourceAssembler.toCommandFromResource(resource, cropId);
        var bunkerId = bunkerCommandService.handle(createBunkerCommand);
        if (bunkerId == 0L){
            return ResponseEntity.badRequest().build();
        }
        var getBunkerById = new GetBunkerByIdQuery(bunkerId);
        var bunker = bunkerQueryService.handle(getBunkerById);
        if (bunker.isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        var bunkerResource = BunkerResourceFromEntityAssembler.toResourceFromEntity(bunker.get());
        return ResponseEntity.ok(bunkerResource);
    }

}
