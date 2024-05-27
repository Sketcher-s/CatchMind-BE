package shop.catchmind.picture.presentation;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import shop.catchmind.auth.dto.AuthenticationDto;
import shop.catchmind.picture.application.PictureService;
import shop.catchmind.picture.dto.response.InterpretResponse;
import shop.catchmind.picture.dto.response.PictureResponse;

@Tag(name = "Picture API", description = "그림 검사 관련 API")
@RestController
@RequestMapping("/api/picture")
@RequiredArgsConstructor
public class PictureController {

    private final PictureService pictureService;

    @Operation(
            summary = "그림 검사",
            description = "요청받은 이미지에 대한 심리 분석 결과를 제공합니다."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "분석이 완료되었습니다.")
    })
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<InterpretResponse> inspectPicture(
            @AuthenticationPrincipal final AuthenticationDto auth,
            @RequestPart(value = "file") final MultipartFile image
    ) {
        return ResponseEntity.ok(pictureService.inspect(auth.id(), image));
    }

    @Operation(
            summary = "그림 검사 상세 조회",
            description = "요청한 ID의 그림 검사 결과의 상세 정보를 조회합니다."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "분석이 완료되었습니다.")
    })
    @GetMapping("/{pictureId}")
    public ResponseEntity<PictureResponse> getPicture(
            @AuthenticationPrincipal final AuthenticationDto auth,
            @PathVariable final Long pictureId
    ) {
        return ResponseEntity.ok(pictureService.getPicture(auth.id(), pictureId));
    }
}
