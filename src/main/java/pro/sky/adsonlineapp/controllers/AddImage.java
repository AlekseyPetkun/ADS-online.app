package pro.sky.adsonlineapp.controllers;

//@Slf4j
//@RestController
//@RequiredArgsConstructor
//@CrossOrigin(value = "http://localhost:3000")
//@RequestMapping("/ads")
//@Tag(name = "добавление картинки")
public class AddImage {

//    private final ImageServiceIMPL imageServiceIMPL;
//    private final AdsRepository adsRepository;
//
//    @PostMapping("/upl")
//    public ResponseEntity<Integer> saveAds(@RequestParam MultipartFile image) {
//
//        Integer image2 = imageServiceIMPL.addImage(image);
//        return ResponseEntity.ok(image2);
//    }
//
//    @GetMapping(value = "/images/{id}/", produces = {MediaType.IMAGE_PNG_VALUE})
//    public ResponseEntity<byte[]> getImage(@RequestParam Integer id) {
//        Ad ad = adsRepository.findById(id).orElseThrow(()
//        -> new NotFoundEntityException(NOT_FOUND_ENTITY));
//        byte[] imageBytes = ad.getImage();
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.IMAGE_PNG);
//        headers.setContentLength(imageBytes.length);
//        return ResponseEntity.ok(imageBytes);
//    }

}
