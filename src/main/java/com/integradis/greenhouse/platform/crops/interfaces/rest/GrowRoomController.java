package com.integradis.greenhouse.platform.crops.interfaces.rest;

import com.integradis.greenhouse.platform.crops.domain.model.queries.GetGrowRoomByCropIdAndCropPhase;
import com.integradis.greenhouse.platform.crops.domain.model.valueobjects.CropPhase;
import com.integradis.greenhouse.platform.crops.domain.services.GrowRoomQueryService;
import com.integradis.greenhouse.platform.crops.interfaces.rest.resources.GrowRoomResource;
import com.integradis.greenhouse.platform.crops.interfaces.rest.transform.GrowRoomResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/grow-room")
@Tag(name = "Grow Room", description = "Grow Room Management Endpoints")
public class GrowRoomController {
    private final GrowRoomQueryService growRoomQueryService;

    public GrowRoomController(GrowRoomQueryService growRoomQueryService) {
        this.growRoomQueryService = growRoomQueryService;
    }


    @GetMapping("/{cropId}/{cropPhase}")
    public ResponseEntity<List<GrowRoomResource>> getGrowRoomEntriesByCropIdAndCropPhase(@PathVariable Long cropId, @PathVariable CropPhase cropPhase) {
        var getGrowRoomEntriesByCropIdAndCropPhase = new GetGrowRoomByCropIdAndCropPhase(cropId, cropPhase);
        var entries = growRoomQueryService.handle(getGrowRoomEntriesByCropIdAndCropPhase);
        if (entries.isEmpty()) return ResponseEntity.badRequest().build();
        var growRoomResource = entries.stream().map((GrowRoomResourceFromEntityAssembler::toResourceFromEntity)).toList();
        return ResponseEntity.ok(growRoomResource);
    }
}