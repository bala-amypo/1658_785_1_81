@RestController
@RequestMapping("/api/assets")
@Tag(name = "Assets")
public class AssetController {

    private final AssetService service;

    public AssetController(AssetService service) {
        this.service = service;
    }

    @PostMapping
    public Asset create(@RequestBody Asset asset) {
        return service.createAsset(asset);
    }

    @GetMapping
    public List<Asset> all() {
        return service.getAllAssets();
    }

    @GetMapping("/{id}")
    public Asset get(@PathVariable Long id) {
        return service.getAsset(id);
    }

    @PutMapping("/status/{id}")
    public Asset update(@PathVariable Long id,
                        @RequestParam String status) {
        return service.updateStatus(id, status);
    }
}
