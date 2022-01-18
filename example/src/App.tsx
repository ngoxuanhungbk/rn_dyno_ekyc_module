import React from 'react';

import { StyleSheet, View } from 'react-native';
import { RnDynoEkycModuleView } from 'rn_dyno_ekyc_module';

export default function App() {

  const _onSuccess = (event) => {
    const { isSuccess, filePath } = event.nativeEvent;
    console.warn(isSuccess);
    console.warn(filePath);
  };

  return (
    <View style={styles.container}>
      <RnDynoEkycModuleView
        style={styles.box}
        onSuccess={_onSuccess}
        faceUp="Ngửa mặt"
        faceDown="Cúi mặt"
        faceLeft="Quay trái"
        faceRight="Quay phải"
        blink="Nháy mắt"
        normal="Nhìn thẳng"
      />
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
  },
  box: {
    width: '100%',
    aspectRatio: 480 / 640,
  },
});
