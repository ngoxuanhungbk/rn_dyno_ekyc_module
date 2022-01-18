# rn_dyno_ekyc_module

verify people

## Installation

```sh
npm install rn_dyno_ekyc_module
```

## Usage

```js
import { RnDynoEkycModuleView } from "rn_dyno_ekyc_module";

// if platform is Android, please check Permisstion before use module

const _onSuccess = (event) => {
    // isSuccess == True if user pass, filePath is url image user
    const { isSuccess, filePath } = event.nativeEvent;
    console.warn(isSuccess);
    console.warn(filePath);
  };

<RnDynoEkycModuleView
        style={{width: '100%',aspectRatio: 480 / 640,}}
        onSuccess={_onSuccess}
        faceUp="Ngửa mặt"
        faceDown="Cúi mặt"
        faceLeft="Quay trái"
        faceRight="Quay phải"
        blink="Nháy mắt"
        normal="Nhìn thẳng"
      />
```

## Contributing

See the [contributing guide](CONTRIBUTING.md) to learn how to contribute to the repository and the development workflow.

## License

MIT
