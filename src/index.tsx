import {
  requireNativeComponent,
  UIManager,
  Platform,
  ViewStyle,
} from 'react-native';

const LINKING_ERROR =
  `The package 'rn_dyno_ekyc_module' doesn't seem to be linked. Make sure: \n\n` +
  Platform.select({ ios: "- You have run 'pod install'\n", default: '' }) +
  '- You rebuilt the app after installing the package\n' +
  '- You are not using Expo managed workflow\n';

type RnDynoEkycModuleProps = {
  color: string;
  style: ViewStyle;
};

const ComponentName = 'RnDynoEkycModuleView';

export const RnDynoEkycModuleView =
  UIManager.getViewManagerConfig(ComponentName) != null
    ? requireNativeComponent<RnDynoEkycModuleProps>(ComponentName)
    : () => {
        throw new Error(LINKING_ERROR);
      };
