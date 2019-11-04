package com.depromeet.dayblock.block.ui.controller;

import com.depromeet.dayblock.block.domain.service.BlockService;
import com.depromeet.dayblock.block.ui.dto.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Api(value = "Block")
@CrossOrigin(origins = {"*"})
@RestController
@RequiredArgsConstructor
@RequestMapping("/block")
public class BlockController {

    private final BlockService blockService;

    @ApiOperation("새로운 블럭을 생성합니다. 인증이 필요한 요청입니다.")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/")
    public Long createBlock(@RequestBody BlockCreateRequest blockCreateRequest) {
        return blockService.createBlock(blockCreateRequest);
    }

    @ApiOperation("날짜에 따라 블럭을 조회합니다. 인증이 필요한 요청입니다.")
    @GetMapping("/{category}")
    public BlockResponse getBlocks(@PathVariable String category, @RequestParam() String date) {
        return blockService.getBlocksByDate(category, date);
    }

    @ApiOperation("기존 블럭을 수정합니다. 인증이 필요한 요청입니다.")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/")
    public void updateBlock(@RequestBody BlockUpdateRequest blockUpdateRequest) {
        blockService.updateBlock(blockUpdateRequest);
    }

    @ApiOperation("기존 블럭의 순서를 갱신합니다. 인증이 필요한 요청입니다.")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/")
    public void updateBlockOrder(@RequestBody BlockUpdateOrderRequest blockUpdateOrderRequest) {
        blockService.updateBlockOrder(blockUpdateOrderRequest);
    }

    @ApiOperation("기존 블럭의 수행 시간을 갱신합니다. 인증이 필요한 요청입니다.")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/")
    public void updateBlockTime(@RequestBody BlockUpdateTimeRequest blockUpdateTimeRequest) {
        blockService.updateBlockTime(blockUpdateTimeRequest); // 10:15
    }

    @ApiOperation("블럭을 삭제합니다. 인증이 필요한 요청입니다.")
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public void deleteBlock(@PathVariable Long id) {
        blockService.removeBlock(id);
    }
}
