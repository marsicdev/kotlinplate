package info.marsic.kotlinplate.data

import info.marsic.kotlinplate.data.source.local.PreferencesHelper
import info.marsic.kotlinplate.data.source.network.ApiHelper

interface DataManager : PreferencesHelper, ApiHelper
