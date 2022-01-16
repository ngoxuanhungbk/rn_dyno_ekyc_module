import * as React from 'react';

import { StyleSheet, View } from 'react-native';
import { RnDynoEkycModuleView } from 'rn_dyno_ekyc_module';

export default function App() {
  return (
    <View style={styles.container}>
      <RnDynoEkycModuleView color="#32a852" style={styles.box} />
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
    height: '50%',
    marginVertical: 20,
  },
});
