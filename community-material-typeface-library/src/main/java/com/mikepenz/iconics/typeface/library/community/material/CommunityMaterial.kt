/*
 * Copyright 2020 Mike Penz
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.mikepenz.iconics.typeface.library.community.material

import com.mikepenz.iconics.typeface.IIcon
import com.mikepenz.iconics.typeface.ITypeface
import com.mikepenz.iconics.typeface.library.community.R
import java.util.LinkedList

@Suppress("EnumEntryName")
object CommunityMaterial : ITypeface {

    override val fontRes: Int = R.font.community_material_font_v3_7_95_1

    override val characters: Map<String, Char> by lazy { Icon.characters }

    override val mappingPrefix: String = "cmd"

    override val fontName: String = "Community Material Design"

    override val version: String = "3.7.95.3"

    override val iconCount: Int = characters.size

    override val icons: List<String> by lazy { characters.keys.toCollection(LinkedList()) }

    override val author: String = "Templarian / Community / Google"

    override val url: String = "http://materialdesignicons.com/"

    override val description: String =
            "Material Design Icons are the official open-source icons featured in the Google " +
                    "Material Design specification."

    override val license: String =
            "Templates - Free, Community Icons - SIL Open Font License 1.1, Google Material " +
                    "Design Icons: Attribution 4.0 International"

    override val licenseUrl: String =
            "https://raw.githubusercontent.com/Templarian/MaterialDesign/master/license.txt"

    override fun getIcon(key: String): IIcon {
        return Icon.valueOf(key) ?: throw RuntimeException("The given Icon does not exist")
    }

    object Icon {
        val values by lazy {
            val items = mutableListOf<CommunityMaterialIcon>()

            items
        }


        val map by lazy { values.associateBy { it.name } }

        val characters by lazy {
            mutableMapOf<String, Char>().apply {
                Icon.values.associateTo(this) { it.name to it.character }
            }
        }

        fun valueOf(value: String): IIcon? {
            return map[value]
        }

        @JvmField
        val cmd_read = CommunityMaterialIcon("cmd_read", '\ue900')

        @JvmField
        val cmd_receipt = CommunityMaterialIcon("cmd_receipt", '\ue900')
        
        @JvmField
        val cmd_record_circle_outline = CommunityMaterialIcon("cmd_record_circle_outline", '\ue900')
        @JvmField
        val cmd_record_circle = CommunityMaterialIcon("cmd_record_circle", '\ue900')
        @JvmField
        val cmd_record_player = CommunityMaterialIcon("cmd_record_player", '\ue900')
        @JvmField
        val cmd_record_rec = CommunityMaterialIcon("cmd_record_rec", '\ue900')
        @JvmField
        val cmd_record = CommunityMaterialIcon("cmd_record", '\ue900')
        @JvmField
        val cmd_rectangle_outline = CommunityMaterialIcon("cmd_rectangle_outline", '\ue900')
        @JvmField
        val cmd_rectangle = CommunityMaterialIcon("cmd_rectangle", '\ue900')
        @JvmField
        val cmd_recycle = CommunityMaterialIcon("cmd_recycle", '\ue900')
        @JvmField
        val cmd_reddit = CommunityMaterialIcon("cmd_reddit", '\ue900')
        @JvmField
        val cmd_redhat = CommunityMaterialIcon("cmd_redhat", '\ue900')
        @JvmField
        val cmd_redo_variant = CommunityMaterialIcon("cmd_redo_variant", '\ue900')
        @JvmField
        val cmd_redo = CommunityMaterialIcon("cmd_redo", '\ue900')
        @JvmField
        val cmd_reflect_horizontal = CommunityMaterialIcon("cmd_reflect_horizontal", '\ue900')
        @JvmField
        val cmd_reflect_vertical = CommunityMaterialIcon("cmd_reflect_vertical", '\ue900')
        @JvmField
        val cmd_refresh = CommunityMaterialIcon("cmd_refresh", '\ue900')
        @JvmField
        val cmd_regex = CommunityMaterialIcon("cmd_regex", '\ue900')
        @JvmField
        val cmd_registered_trademark = CommunityMaterialIcon("cmd_registered_trademark", '\ue900')
        @JvmField
        val cmd_relative_scale = CommunityMaterialIcon("cmd_relative_scale", '\ue900')
        @JvmField
        val cmd_reload_alert = CommunityMaterialIcon("cmd_reload_alert", '\ue900')
        @JvmField
        val cmd_reload = CommunityMaterialIcon("cmd_reload", '\ue900')
        @JvmField
        val cmd_reminder = CommunityMaterialIcon("cmd_reminder", '\ue900')
        @JvmField
        val cmd_remote_desktop = CommunityMaterialIcon("cmd_remote_desktop", '\ue900')
        @JvmField
        val cmd_remote_off = CommunityMaterialIcon("cmd_remote_off", '\ue900')
        @JvmField
        val cmd_remote_tv_off = CommunityMaterialIcon("cmd_remote_tv_off", '\ue900')
        @JvmField
        val cmd_remote_tv = CommunityMaterialIcon("cmd_remote_tv", '\ue900')
        @JvmField
        val cmd_remote = CommunityMaterialIcon("cmd_remote", '\ue900')
        @JvmField
        val cmd_rename_box = CommunityMaterialIcon("cmd_rename_box", '\ue900')
        @JvmField
        val cmd_reorder_horizontal = CommunityMaterialIcon("cmd_reorder_horizontal", '\ue900')
        @JvmField
        val cmd_reorder_vertical = CommunityMaterialIcon("cmd_reorder_vertical", '\ue900')
        @JvmField
        val cmd_repeat_off = CommunityMaterialIcon("cmd_repeat_off", '\ue900')
        @JvmField
        val cmd_repeat_once = CommunityMaterialIcon("cmd_repeat_once", '\ue900')
        @JvmField
        val cmd_repeat = CommunityMaterialIcon("cmd_repeat", '\ue900')
        @JvmField
        val cmd_replay = CommunityMaterialIcon("cmd_replay", '\ue900')
        @JvmField
        val cmd_reply_all_outline = CommunityMaterialIcon("cmd_reply_all_outline", '\ue900')
        @JvmField
        val cmd_reply_all = CommunityMaterialIcon("cmd_reply_all", '\ue900')
        @JvmField
        val cmd_reply_circle = CommunityMaterialIcon("cmd_reply_circle", '\ue900')
        @JvmField
        val cmd_reply_outline = CommunityMaterialIcon("cmd_reply_outline", '\ue900')
        @JvmField
        val cmd_reply = CommunityMaterialIcon("cmd_reply", '\ue900')
        @JvmField
        val cmd_reproduction = CommunityMaterialIcon("cmd_reproduction", '\ue900')
        @JvmField
        val cmd_resistor_nodes = CommunityMaterialIcon("cmd_resistor_nodes", '\ue900')
        @JvmField
        val cmd_resistor = CommunityMaterialIcon("cmd_resistor", '\ue900')
        @JvmField
        val cmd_resize_bottom_right = CommunityMaterialIcon("cmd_resize_bottom_right", '\ue900')
        @JvmField
        val cmd_resize = CommunityMaterialIcon("cmd_resize", '\ue900')
        @JvmField
        val cmd_responsive = CommunityMaterialIcon("cmd_responsive", '\ue900')
        @JvmField
        val cmd_restart_alert = CommunityMaterialIcon("cmd_restart_alert", '\ue900')
        @JvmField
        val cmd_restart_off = CommunityMaterialIcon("cmd_restart_off", '\ue900')
        @JvmField
        val cmd_restart = CommunityMaterialIcon("cmd_restart", '\ue900')
        @JvmField
        val cmd_restore_alert = CommunityMaterialIcon("cmd_restore_alert", '\ue900')
        @JvmField
        val cmd_restore = CommunityMaterialIcon("cmd_restore", '\ue900')
        @JvmField
        val cmd_rewind_5 = CommunityMaterialIcon("cmd_rewind_5", '\ue900')
        @JvmField
        val cmd_rewind_10 = CommunityMaterialIcon("cmd_rewind_10", '\ue900')
        @JvmField
        val cmd_rewind_30 = CommunityMaterialIcon("cmd_rewind_30", '\ue900')
        @JvmField
        val cmd_rewind_outline = CommunityMaterialIcon("cmd_rewind_outline", '\ue900')
        @JvmField
        val cmd_rewind = CommunityMaterialIcon("cmd_rewind", '\ue900')
        @JvmField
        val cmd_rhombus_medium = CommunityMaterialIcon("cmd_rhombus_medium", '\ue900')
        @JvmField
        val cmd_rhombus_outline = CommunityMaterialIcon("cmd_rhombus_outline", '\ue900')
        @JvmField
        val cmd_rhombus_split = CommunityMaterialIcon("cmd_rhombus_split", '\ue900')
        @JvmField
        val cmd_rhombus = CommunityMaterialIcon("cmd_rhombus", '\ue900')
        @JvmField
        val cmd_ribbon = CommunityMaterialIcon("cmd_ribbon", '\ue900')
        @JvmField
        val cmd_rice = CommunityMaterialIcon("cmd_rice", '\ue900')
        @JvmField
        val cmd_ring = CommunityMaterialIcon("cmd_ring", '\ue900')
        @JvmField
        val cmd_rivet = CommunityMaterialIcon("cmd_rivet", '\ue900')
        @JvmField
        val cmd_road_variant = CommunityMaterialIcon("cmd_road_variant", '\ue900')
        @JvmField
        val cmd_road = CommunityMaterialIcon("cmd_road", '\ue900')
        @JvmField
        val cmd_robber = CommunityMaterialIcon("cmd_robber", '\ue900')
        @JvmField
        val cmd_robot_industrial = CommunityMaterialIcon("cmd_robot_industrial", '\ue900')
        @JvmField
        val cmd_robot_mower_outline = CommunityMaterialIcon("cmd_robot_mower_outline", '\ue900')
        @JvmField
        val cmd_robot_mower = CommunityMaterialIcon("cmd_robot_mower", '\ue900')
        @JvmField
        val cmd_robot_vacuum_variant = CommunityMaterialIcon("cmd_robot_vacuum_variant", '\ue900')
        @JvmField
        val cmd_robot_vacuum = CommunityMaterialIcon("cmd_robot_vacuum", '\ue900')
        @JvmField
        val cmd_robot = CommunityMaterialIcon("cmd_robot", '\ue900')
        @JvmField
        val cmd_rocket = CommunityMaterialIcon("cmd_rocket", '\ue900')
        @JvmField
        val cmd_roller_skate = CommunityMaterialIcon("cmd_roller_skate", '\ue900')
        @JvmField
        val cmd_rollerblade = CommunityMaterialIcon("cmd_rollerblade", '\ue900')
        @JvmField
        val cmd_rollupjs = CommunityMaterialIcon("cmd_rollupjs", '\ue900')
        @JvmField
        val cmd_roman_numeral_1 = CommunityMaterialIcon("cmd_roman_numeral_1", '\ue900')
        @JvmField
        val cmd_roman_numeral_2 = CommunityMaterialIcon("cmd_roman_numeral_2", '\ue900')
        @JvmField
        val cmd_roman_numeral_3 = CommunityMaterialIcon("cmd_roman_numeral_3", '\ue900')
        @JvmField
        val cmd_roman_numeral_4 = CommunityMaterialIcon("cmd_roman_numeral_4", '\ue900')
        @JvmField
        val cmd_roman_numeral_5 = CommunityMaterialIcon("cmd_roman_numeral_5", '\ue900')
        @JvmField
        val cmd_roman_numeral_6 = CommunityMaterialIcon("cmd_roman_numeral_6", '\ue900')
        @JvmField
        val cmd_roman_numeral_7 = CommunityMaterialIcon("cmd_roman_numeral_7", '\ue900')
        @JvmField
        val cmd_roman_numeral_8 = CommunityMaterialIcon("cmd_roman_numeral_8", '\ue900')
        @JvmField
        val cmd_roman_numeral_9 = CommunityMaterialIcon("cmd_roman_numeral_9", '\ue900')
        @JvmField
        val cmd_roman_numeral_10 = CommunityMaterialIcon("cmd_roman_numeral_10", '\ue900')
        @JvmField
        val cmd_room_service_outline = CommunityMaterialIcon("cmd_room_service_outline", '\ue900')
        @JvmField
        val cmd_room_service = CommunityMaterialIcon("cmd_room_service", '\ue900')
        @JvmField
        val cmd_rotate_3d_variant = CommunityMaterialIcon("cmd_rotate_3d_variant", '\ue900')
        @JvmField
        val cmd_rotate_3d = CommunityMaterialIcon("cmd_rotate_3d", '\ue900')
        @JvmField
        val cmd_rotate_left_variant = CommunityMaterialIcon("cmd_rotate_left_variant", '\ue900')
        @JvmField
        val cmd_rotate_left = CommunityMaterialIcon("cmd_rotate_left", '\ue900')
        @JvmField
        val cmd_rotate_orbit = CommunityMaterialIcon("cmd_rotate_orbit", '\ue900')
        @JvmField
        val cmd_rotate_right_variant = CommunityMaterialIcon("cmd_rotate_right_variant", '\ue900')
        @JvmField
        val cmd_rotate_right = CommunityMaterialIcon("cmd_rotate_right", '\ue900')
        @JvmField
        val cmd_rounded_corner = CommunityMaterialIcon("cmd_rounded_corner", '\ue900')
        @JvmField
        val cmd_router_wireless_settings = CommunityMaterialIcon("cmd_router_wireless_settings", '\ue900')
        @JvmField
        val cmd_router_wireless = CommunityMaterialIcon("cmd_router_wireless", '\ue900')
        @JvmField
        val cmd_router = CommunityMaterialIcon("cmd_router", '\ue900')
        @JvmField
        val cmd_routes_clock = CommunityMaterialIcon("cmd_routes_clock", '\ue900')
        @JvmField
        val cmd_routes = CommunityMaterialIcon("cmd_routes", '\ue900')
        @JvmField
        val cmd_rowing = CommunityMaterialIcon("cmd_rowing", '\ue900')
        @JvmField
        val cmd_rss_box = CommunityMaterialIcon("cmd_rss_box", '\ue900')
        @JvmField
        val cmd_rss_off = CommunityMaterialIcon("cmd_rss_off", '\ue900')
        @JvmField
        val cmd_rss = CommunityMaterialIcon("cmd_rss", '\ue900')
        @JvmField
        val cmd_ruby = CommunityMaterialIcon("cmd_ruby", '\ue900')
        @JvmField
        val cmd_rugby = CommunityMaterialIcon("cmd_rugby", '\ue900')
        @JvmField
        val cmd_ruler_square_compass = CommunityMaterialIcon("cmd_ruler_square_compass", '\ue900')
        @JvmField
        val cmd_ruler_square = CommunityMaterialIcon("cmd_ruler_square", '\ue900')
        @JvmField
        val cmd_ruler = CommunityMaterialIcon("cmd_ruler", '\ue900')
        @JvmField
        val cmd_run_fast = CommunityMaterialIcon("cmd_run_fast", '\ue900')
        @JvmField
        val cmd_run = CommunityMaterialIcon("cmd_run", '\ue900')
        @JvmField
        val cmd_rv_truck = CommunityMaterialIcon("cmd_rv_truck", '\ue900')
        @JvmField
        val cmd_sack_percent = CommunityMaterialIcon("cmd_sack_percent", '\ue900')
        @JvmField
        val cmd_sack = CommunityMaterialIcon("cmd_sack", '\ue900')
        @JvmField
        val cmd_safe_square_outline = CommunityMaterialIcon("cmd_safe_square_outline", '\ue900')
        @JvmField
        val cmd_safe_square = CommunityMaterialIcon("cmd_safe_square", '\ue900')
        @JvmField
        val cmd_safe = CommunityMaterialIcon("cmd_safe", '\ue900')
        @JvmField
        val cmd_safety_goggles = CommunityMaterialIcon("cmd_safety_goggles", '\ue900')
        @JvmField
        val cmd_sailing = CommunityMaterialIcon("cmd_sailing", '\ue900')
        @JvmField
        val cmd_sale = CommunityMaterialIcon("cmd_sale", '\ue900')
        @JvmField
        val cmd_salesforce = CommunityMaterialIcon("cmd_salesforce", '\ue900')
        @JvmField
        val cmd_sass = CommunityMaterialIcon("cmd_sass", '\ue900')
        @JvmField
        val cmd_satellite_uplink = CommunityMaterialIcon("cmd_satellite_uplink", '\ue900')
        @JvmField
        val cmd_satellite_variant = CommunityMaterialIcon("cmd_satellite_variant", '\ue900')
        @JvmField
        val cmd_satellite = CommunityMaterialIcon("cmd_satellite", '\ue900')
        @JvmField
        val cmd_sausage = CommunityMaterialIcon("cmd_sausage", '\ue900')
        @JvmField
        val cmd_saw_blade = CommunityMaterialIcon("cmd_saw_blade", '\ue900')
        @JvmField
        val cmd_saxophone = CommunityMaterialIcon("cmd_saxophone", '\ue900')
        @JvmField
        val cmd_scale_balance = CommunityMaterialIcon("cmd_scale_balance", '\ue900')
        @JvmField
        val cmd_scale_bathroom = CommunityMaterialIcon("cmd_scale_bathroom", '\ue900')
        @JvmField
        val cmd_scale_off = CommunityMaterialIcon("cmd_scale_off", '\ue900')
        @JvmField
        val cmd_scale = CommunityMaterialIcon("cmd_scale", '\ue900')
        @JvmField
        val cmd_scanner_off = CommunityMaterialIcon("cmd_scanner_off", '\ue900')
        @JvmField
        val cmd_scanner = CommunityMaterialIcon("cmd_scanner", '\ue900')
        @JvmField
        val cmd_scatter_plot_outline = CommunityMaterialIcon("cmd_scatter_plot_outline", '\ue900')
        @JvmField
        val cmd_scatter_plot = CommunityMaterialIcon("cmd_scatter_plot", '\ue900')
        @JvmField
        val cmd_school_outline = CommunityMaterialIcon("cmd_school_outline", '\ue900')
        @JvmField
        val cmd_school = CommunityMaterialIcon("cmd_school", '\ue900')
        @JvmField
        val cmd_scissors_cutting = CommunityMaterialIcon("cmd_scissors_cutting", '\ue900')
        @JvmField
        val cmd_scooter = CommunityMaterialIcon("cmd_scooter", '\ue900')
        @JvmField
        val cmd_scoreboard_outline = CommunityMaterialIcon("cmd_scoreboard_outline", '\ue900')
        @JvmField
        val cmd_scoreboard = CommunityMaterialIcon("cmd_scoreboard", '\ue900')
        @JvmField
        val cmd_screen_rotation_lock = CommunityMaterialIcon("cmd_screen_rotation_lock", '\ue900')
        @JvmField
        val cmd_screen_rotation = CommunityMaterialIcon("cmd_screen_rotation", '\ue900')
        @JvmField
        val cmd_screw_flat_top = CommunityMaterialIcon("cmd_screw_flat_top", '\ue900')
        @JvmField
        val cmd_screw_lag = CommunityMaterialIcon("cmd_screw_lag", '\ue900')
        @JvmField
        val cmd_screw_machine_flat_top = CommunityMaterialIcon("cmd_screw_machine_flat_top", '\ue900')
        @JvmField
        val cmd_screw_machine_round_top = CommunityMaterialIcon("cmd_screw_machine_round_top", '\ue900')
        @JvmField
        val cmd_screw_round_top = CommunityMaterialIcon("cmd_screw_round_top", '\ue900')
        @JvmField
        val cmd_screwdriver = CommunityMaterialIcon("cmd_screwdriver", '\ue900')
        @JvmField
        val cmd_script_outline = CommunityMaterialIcon("cmd_script_outline", '\ue900')
        @JvmField
        val cmd_script_text_outline = CommunityMaterialIcon("cmd_script_text_outline", '\ue900')
        @JvmField
        val cmd_script_text = CommunityMaterialIcon("cmd_script_text", '\ue900')
        @JvmField
        val cmd_script = CommunityMaterialIcon("cmd_script", '\ue900')
        @JvmField
        val cmd_sd = CommunityMaterialIcon("cmd_sd", '\ue900')
        @JvmField
        val cmd_seal_variant = CommunityMaterialIcon("cmd_seal_variant", '\ue900')
        @JvmField
        val cmd_seal = CommunityMaterialIcon("cmd_seal", '\ue900')
        @JvmField
        val cmd_search_web = CommunityMaterialIcon("cmd_search_web", '\ue900')
        @JvmField
        val cmd_seat_flat_angled = CommunityMaterialIcon("cmd_seat_flat_angled", '\ue900')
        @JvmField
        val cmd_seat_flat = CommunityMaterialIcon("cmd_seat_flat", '\ue900')
        @JvmField
        val cmd_seat_individual_suite = CommunityMaterialIcon("cmd_seat_individual_suite", '\ue900')
        @JvmField
        val cmd_seat_legroom_extra = CommunityMaterialIcon("cmd_seat_legroom_extra", '\ue900')
        @JvmField
        val cmd_seat_legroom_normal = CommunityMaterialIcon("cmd_seat_legroom_normal", '\ue900')
        @JvmField
        val cmd_seat_legroom_reduced = CommunityMaterialIcon("cmd_seat_legroom_reduced", '\ue900')
        @JvmField
        val cmd_seat_outline = CommunityMaterialIcon("cmd_seat_outline", '\ue900')
        @JvmField
        val cmd_seat_passenger = CommunityMaterialIcon("cmd_seat_passenger", '\ue900')
        @JvmField
        val cmd_seat_recline_extra = CommunityMaterialIcon("cmd_seat_recline_extra", '\ue900')
        @JvmField
        val cmd_seat_recline_normal = CommunityMaterialIcon("cmd_seat_recline_normal", '\ue900')
        @JvmField
        val cmd_seat = CommunityMaterialIcon("cmd_seat", '\ue900')
        @JvmField
        val cmd_seatbelt = CommunityMaterialIcon("cmd_seatbelt", '\ue900')
        @JvmField
        val cmd_security_network = CommunityMaterialIcon("cmd_security_network", '\ue900')
        @JvmField
        val cmd_security = CommunityMaterialIcon("cmd_security", '\ue900')
        @JvmField
        val cmd_seed_outline = CommunityMaterialIcon("cmd_seed_outline", '\ue900')
        @JvmField
        val cmd_seed = CommunityMaterialIcon("cmd_seed", '\ue900')
        @JvmField
        val cmd_segment = CommunityMaterialIcon("cmd_segment", '\ue900')
        @JvmField
        val cmd_select_all = CommunityMaterialIcon("cmd_select_all", '\ue900')
        @JvmField
        val cmd_select_color = CommunityMaterialIcon("cmd_select_color", '\ue900')
        @JvmField
        val cmd_select_compare = CommunityMaterialIcon("cmd_select_compare", '\ue900')
        @JvmField
        val cmd_select_drag = CommunityMaterialIcon("cmd_select_drag", '\ue900')
        @JvmField
        val cmd_select_group = CommunityMaterialIcon("cmd_select_group", '\ue900')
        @JvmField
        val cmd_select_inverse = CommunityMaterialIcon("cmd_select_inverse", '\ue900')
        @JvmField
        val cmd_select_marker = CommunityMaterialIcon("cmd_select_marker", '\ue900')
        @JvmField
        val cmd_select_multiple_marker = CommunityMaterialIcon("cmd_select_multiple_marker", '\ue900')
        @JvmField
        val cmd_select_multiple = CommunityMaterialIcon("cmd_select_multiple", '\ue900')
        @JvmField
        val cmd_select_off = CommunityMaterialIcon("cmd_select_off", '\ue900')
        @JvmField
        val cmd_select_place = CommunityMaterialIcon("cmd_select_place", '\ue900')
        @JvmField
        val cmd_select_search = CommunityMaterialIcon("cmd_select_search", '\ue900')
        @JvmField
        val cmd_select = CommunityMaterialIcon("cmd_select", '\ue900')
        @JvmField
        val cmd_selection_drag = CommunityMaterialIcon("cmd_selection_drag", '\ue900')
        @JvmField
        val cmd_selection_ellipse_arrow_inside = CommunityMaterialIcon("cmd_selection_ellipse_arrow_inside", '\ue900')
        @JvmField
        val cmd_selection_ellipse = CommunityMaterialIcon("cmd_selection_ellipse", '\ue900')
        @JvmField
        val cmd_selection_marker = CommunityMaterialIcon("cmd_selection_marker", '\ue900')
        @JvmField
        val cmd_selection_multiple_marker = CommunityMaterialIcon("cmd_selection_multiple_marker", '\ue900')
        @JvmField
        val cmd_selection_mutliple = CommunityMaterialIcon("cmd_selection_mutliple", '\ue900')
        @JvmField
        val cmd_selection_off = CommunityMaterialIcon("cmd_selection_off", '\ue900')
        @JvmField
        val cmd_selection_search = CommunityMaterialIcon("cmd_selection_search", '\ue900')
        @JvmField
        val cmd_selection = CommunityMaterialIcon("cmd_selection", '\ue900')
        @JvmField
        val cmd_send_check_outline = CommunityMaterialIcon("cmd_send_check_outline", '\ue900')
        @JvmField
        val cmd_send_check = CommunityMaterialIcon("cmd_send_check", '\ue900')
        @JvmField
        val cmd_send_circle_outline = CommunityMaterialIcon("cmd_send_circle_outline", '\ue900')
        @JvmField
        val cmd_send_circle = CommunityMaterialIcon("cmd_send_circle", '\ue900')
        @JvmField
        val cmd_send_clock_outline = CommunityMaterialIcon("cmd_send_clock_outline", '\ue900')
        @JvmField
        val cmd_send_clock = CommunityMaterialIcon("cmd_send_clock", '\ue900')
        @JvmField
        val cmd_send_lock_outline = CommunityMaterialIcon("cmd_send_lock_outline", '\ue900')
        @JvmField
        val cmd_send_lock = CommunityMaterialIcon("cmd_send_lock", '\ue900')
        @JvmField
        val cmd_send_outline = CommunityMaterialIcon("cmd_send_outline", '\ue900')
        @JvmField
        val cmd_send = CommunityMaterialIcon("cmd_send", '\ue900')
        @JvmField
        val cmd_serial_port = CommunityMaterialIcon("cmd_serial_port", '\ue900')
        @JvmField
        val cmd_server_minus = CommunityMaterialIcon("cmd_server_minus", '\ue900')
        @JvmField
        val cmd_server_network_off = CommunityMaterialIcon("cmd_server_network_off", '\ue900')
        @JvmField
        val cmd_server_network = CommunityMaterialIcon("cmd_server_network", '\ue900')
        @JvmField
        val cmd_server_off = CommunityMaterialIcon("cmd_server_off", '\ue900')
        @JvmField
        val cmd_server_plus = CommunityMaterialIcon("cmd_server_plus", '\ue900')
        @JvmField
        val cmd_server_remove = CommunityMaterialIcon("cmd_server_remove", '\ue900')
        @JvmField
        val cmd_server_security = CommunityMaterialIcon("cmd_server_security", '\ue900')
        @JvmField
        val cmd_server = CommunityMaterialIcon("cmd_server", '\ue900')
        @JvmField
        val cmd_set_all = CommunityMaterialIcon("cmd_set_all", '\ue900')
        @JvmField
        val cmd_set_center_right = CommunityMaterialIcon("cmd_set_center_right", '\ue900')
        @JvmField
        val cmd_set_center = CommunityMaterialIcon("cmd_set_center", '\ue900')
        @JvmField
        val cmd_set_left_center = CommunityMaterialIcon("cmd_set_left_center", '\ue900')
        @JvmField
        val cmd_set_left_right = CommunityMaterialIcon("cmd_set_left_right", '\ue900')
        @JvmField
        val cmd_set_left = CommunityMaterialIcon("cmd_set_left", '\ue900')
        @JvmField
        val cmd_set_none = CommunityMaterialIcon("cmd_set_none", '\ue900')
        @JvmField
        val cmd_set_right = CommunityMaterialIcon("cmd_set_right", '\ue900')
        @JvmField
        val cmd_set_top_box = CommunityMaterialIcon("cmd_set_top_box", '\ue900')
        @JvmField
        val cmd_settings_box = CommunityMaterialIcon("cmd_settings_box", '\ue900')
        @JvmField
        val cmd_settings_helper = CommunityMaterialIcon("cmd_settings_helper", '\ue900')
        @JvmField
        val cmd_settings_outline = CommunityMaterialIcon("cmd_settings_outline", '\ue900')
        @JvmField
        val cmd_settings_transfer_outline = CommunityMaterialIcon("cmd_settings_transfer_outline", '\ue900')
        @JvmField
        val cmd_settings_transfer = CommunityMaterialIcon("cmd_settings_transfer", '\ue900')
        @JvmField
        val cmd_settings = CommunityMaterialIcon("cmd_settings", '\ue900')
        @JvmField
        val cmd_shaker_outline = CommunityMaterialIcon("cmd_shaker_outline", '\ue900')
        @JvmField
        val cmd_shaker = CommunityMaterialIcon("cmd_shaker", '\ue900')
        @JvmField
        val cmd_shape_circle_plus = CommunityMaterialIcon("cmd_shape_circle_plus", '\ue900')
        @JvmField
        val cmd_shape_outline = CommunityMaterialIcon("cmd_shape_outline", '\ue900')
        @JvmField
        val cmd_shape_oval_plus = CommunityMaterialIcon("cmd_shape_oval_plus", '\ue900')
        @JvmField
        val cmd_shape_plus = CommunityMaterialIcon("cmd_shape_plus", '\ue900')
        @JvmField
        val cmd_shape_polygon_plus = CommunityMaterialIcon("cmd_shape_polygon_plus", '\ue900')
        @JvmField
        val cmd_shape_rectangle_plus = CommunityMaterialIcon("cmd_shape_rectangle_plus", '\ue900')
        @JvmField
        val cmd_shape_square_plus = CommunityMaterialIcon("cmd_shape_square_plus", '\ue900')
        @JvmField
        val cmd_shape = CommunityMaterialIcon("cmd_shape", '\ue900')
        @JvmField
        val cmd_share_all_outline = CommunityMaterialIcon("cmd_share_all_outline", '\ue900')
        @JvmField
        val cmd_share_all = CommunityMaterialIcon("cmd_share_all", '\ue900')
        @JvmField
        val cmd_share_circle = CommunityMaterialIcon("cmd_share_circle", '\ue900')
        @JvmField
        val cmd_share_off_outline = CommunityMaterialIcon("cmd_share_off_outline", '\ue900')
        @JvmField
        val cmd_share_off = CommunityMaterialIcon("cmd_share_off", '\ue900')
        @JvmField
        val cmd_share_outline = CommunityMaterialIcon("cmd_share_outline", '\ue900')
        @JvmField
        val cmd_share_variant = CommunityMaterialIcon("cmd_share_variant", '\ue900')
        @JvmField
        val cmd_share = CommunityMaterialIcon("cmd_share", '\ue900')
        @JvmField
        val cmd_sheep = CommunityMaterialIcon("cmd_sheep", '\ue900')
        @JvmField
        val cmd_shield_account_outline = CommunityMaterialIcon("cmd_shield_account_outline", '\ue900')
        @JvmField
        val cmd_shield_account = CommunityMaterialIcon("cmd_shield_account", '\ue900')
        @JvmField
        val cmd_shield_airplane_outline = CommunityMaterialIcon("cmd_shield_airplane_outline", '\ue900')
        @JvmField
        val cmd_shield_airplane = CommunityMaterialIcon("cmd_shield_airplane", '\ue900')
        @JvmField
        val cmd_shield_alert_outline = CommunityMaterialIcon("cmd_shield_alert_outline", '\ue900')
        @JvmField
        val cmd_shield_alert = CommunityMaterialIcon("cmd_shield_alert", '\ue900')
        @JvmField
        val cmd_shield_car = CommunityMaterialIcon("cmd_shield_car", '\ue900')
        @JvmField
        val cmd_shield_check_outline = CommunityMaterialIcon("cmd_shield_check_outline", '\ue900')
        @JvmField
        val cmd_shield_check = CommunityMaterialIcon("cmd_shield_check", '\ue900')
        @JvmField
        val cmd_shield_cross_outline = CommunityMaterialIcon("cmd_shield_cross_outline", '\ue900')
        @JvmField
        val cmd_shield_cross = CommunityMaterialIcon("cmd_shield_cross", '\ue900')
        @JvmField
        val cmd_shield_edit_outline = CommunityMaterialIcon("cmd_shield_edit_outline", '\ue900')
        @JvmField
        val cmd_shield_edit = CommunityMaterialIcon("cmd_shield_edit", '\ue900')
        @JvmField
        val cmd_shield_half_full = CommunityMaterialIcon("cmd_shield_half_full", '\ue900')
        @JvmField
        val cmd_shield_home_outline = CommunityMaterialIcon("cmd_shield_home_outline", '\ue900')
        @JvmField
        val cmd_shield_home = CommunityMaterialIcon("cmd_shield_home", '\ue900')
        @JvmField
        val cmd_shield_key_outline = CommunityMaterialIcon("cmd_shield_key_outline", '\ue900')
        @JvmField
        val cmd_shield_key = CommunityMaterialIcon("cmd_shield_key", '\ue900')
        @JvmField
        val cmd_shield_link_variant_outline = CommunityMaterialIcon("cmd_shield_link_variant_outline", '\ue900')
        @JvmField
        val cmd_shield_link_variant = CommunityMaterialIcon("cmd_shield_link_variant", '\ue900')
        @JvmField
        val cmd_shield_lock_outline = CommunityMaterialIcon("cmd_shield_lock_outline", '\ue900')
        @JvmField
        val cmd_shield_lock = CommunityMaterialIcon("cmd_shield_lock", '\ue900')
        @JvmField
        val cmd_shield_off_outline = CommunityMaterialIcon("cmd_shield_off_outline", '\ue900')
        @JvmField
        val cmd_shield_off = CommunityMaterialIcon("cmd_shield_off", '\ue900')
        @JvmField
        val cmd_shield_outline = CommunityMaterialIcon("cmd_shield_outline", '\ue900')
        @JvmField
        val cmd_shield_plus_outline = CommunityMaterialIcon("cmd_shield_plus_outline", '\ue900')
        @JvmField
        val cmd_shield_plus = CommunityMaterialIcon("cmd_shield_plus", '\ue900')
        @JvmField
        val cmd_shield_refresh_outline = CommunityMaterialIcon("cmd_shield_refresh_outline", '\ue900')
        @JvmField
        val cmd_shield_refresh = CommunityMaterialIcon("cmd_shield_refresh", '\ue900')
        @JvmField
        val cmd_shield_remove_outline = CommunityMaterialIcon("cmd_shield_remove_outline", '\ue900')
        @JvmField
        val cmd_shield_remove = CommunityMaterialIcon("cmd_shield_remove", '\ue900')
        @JvmField
        val cmd_shield_search = CommunityMaterialIcon("cmd_shield_search", '\ue900')
        @JvmField
        val cmd_shield_star_outline = CommunityMaterialIcon("cmd_shield_star_outline", '\ue900')
        @JvmField
        val cmd_shield_star = CommunityMaterialIcon("cmd_shield_star", '\ue900')
        @JvmField
        val cmd_shield_sun_outline = CommunityMaterialIcon("cmd_shield_sun_outline", '\ue900')
        @JvmField
        val cmd_shield_sun = CommunityMaterialIcon("cmd_shield_sun", '\ue900')
        @JvmField
        val cmd_shield = CommunityMaterialIcon("cmd_shield", '\ue900')
        @JvmField
        val cmd_ship_wheel = CommunityMaterialIcon("cmd_ship_wheel", '\ue900')
        @JvmField
        val cmd_shoe_formal = CommunityMaterialIcon("cmd_shoe_formal", '\ue900')
        @JvmField
        val cmd_shoe_heel = CommunityMaterialIcon("cmd_shoe_heel", '\ue900')
        @JvmField
        val cmd_shoe_print = CommunityMaterialIcon("cmd_shoe_print", '\ue900')
        @JvmField
        val cmd_shopify = CommunityMaterialIcon("cmd_shopify", '\ue900')
        @JvmField
        val cmd_shopping_music = CommunityMaterialIcon("cmd_shopping_music", '\ue900')
        @JvmField
        val cmd_shopping_outline = CommunityMaterialIcon("cmd_shopping_outline", '\ue900')
        @JvmField
        val cmd_shopping_search = CommunityMaterialIcon("cmd_shopping_search", '\ue900')
        @JvmField
        val cmd_shopping = CommunityMaterialIcon("cmd_shopping", '\ue900')
        @JvmField
        val cmd_shovel_off = CommunityMaterialIcon("cmd_shovel_off", '\ue900')
        @JvmField
        val cmd_shovel = CommunityMaterialIcon("cmd_shovel", '\ue900')
        @JvmField
        val cmd_shower_head = CommunityMaterialIcon("cmd_shower_head", '\ue900')
        @JvmField
        val cmd_shower = CommunityMaterialIcon("cmd_shower", '\ue900')
        @JvmField
        val cmd_shredder = CommunityMaterialIcon("cmd_shredder", '\ue900')
        @JvmField
        val cmd_shuffle_disabled = CommunityMaterialIcon("cmd_shuffle_disabled", '\ue900')
        @JvmField
        val cmd_shuffle_variant = CommunityMaterialIcon("cmd_shuffle_variant", '\ue900')
        @JvmField
        val cmd_shuffle = CommunityMaterialIcon("cmd_shuffle", '\ue900')
        @JvmField
        val cmd_sigma_lower = CommunityMaterialIcon("cmd_sigma_lower", '\ue900')
        @JvmField
        val cmd_sigma = CommunityMaterialIcon("cmd_sigma", '\ue900')
        @JvmField
        val cmd_sign_caution = CommunityMaterialIcon("cmd_sign_caution", '\ue900')
        @JvmField
        val cmd_sign_direction_minus = CommunityMaterialIcon("cmd_sign_direction_minus", '\ue900')
        @JvmField
        val cmd_sign_direction_plus = CommunityMaterialIcon("cmd_sign_direction_plus", '\ue900')
        @JvmField
        val cmd_sign_direction_remove = CommunityMaterialIcon("cmd_sign_direction_remove", '\ue900')
        @JvmField
        val cmd_sign_direction = CommunityMaterialIcon("cmd_sign_direction", '\ue900')
        @JvmField
        val cmd_sign_real_estate = CommunityMaterialIcon("cmd_sign_real_estate", '\ue900')
        @JvmField
        val cmd_sign_text = CommunityMaterialIcon("cmd_sign_text", '\ue900')
        @JvmField
        val cmd_signal_2g = CommunityMaterialIcon("cmd_signal_2g", '\ue900')
        @JvmField
        val cmd_signal_3g = CommunityMaterialIcon("cmd_signal_3g", '\ue900')
        @JvmField
        val cmd_signal_4g = CommunityMaterialIcon("cmd_signal_4g", '\ue900')
        @JvmField
        val cmd_signal_5g = CommunityMaterialIcon("cmd_signal_5g", '\ue900')
        @JvmField
        val cmd_signal_cellular_1 = CommunityMaterialIcon("cmd_signal_cellular_1", '\ue900')
        @JvmField
        val cmd_signal_cellular_2 = CommunityMaterialIcon("cmd_signal_cellular_2", '\ue900')
        @JvmField
        val cmd_signal_cellular_3 = CommunityMaterialIcon("cmd_signal_cellular_3", '\ue900')
        @JvmField
        val cmd_signal_cellular_outline = CommunityMaterialIcon("cmd_signal_cellular_outline", '\ue900')
        @JvmField
        val cmd_signal_distance_variant = CommunityMaterialIcon("cmd_signal_distance_variant", '\ue900')
        @JvmField
        val cmd_signal_hspa_plus = CommunityMaterialIcon("cmd_signal_hspa_plus", '\ue900')
        @JvmField
        val cmd_signal_hspa = CommunityMaterialIcon("cmd_signal_hspa", '\ue900')
        @JvmField
        val cmd_signal_off = CommunityMaterialIcon("cmd_signal_off", '\ue900')
        @JvmField
        val cmd_signal_variant = CommunityMaterialIcon("cmd_signal_variant", '\ue900')
        @JvmField
        val cmd_signal = CommunityMaterialIcon("cmd_signal", '\ue900')
        @JvmField
        val cmd_signature_freehand = CommunityMaterialIcon("cmd_signature_freehand", '\ue900')
        @JvmField
        val cmd_signature_image = CommunityMaterialIcon("cmd_signature_image", '\ue900')
        @JvmField
        val cmd_signature_text = CommunityMaterialIcon("cmd_signature_text", '\ue900')
        @JvmField
        val cmd_signature = CommunityMaterialIcon("cmd_signature", '\ue900')
        @JvmField
        val cmd_silo = CommunityMaterialIcon("cmd_silo", '\ue900')
        @JvmField
        val cmd_silverware_clean = CommunityMaterialIcon("cmd_silverware_clean", '\ue900')
        @JvmField
        val cmd_silverware_fork_knife = CommunityMaterialIcon("cmd_silverware_fork_knife", '\ue900')
        @JvmField
        val cmd_silverware_fork = CommunityMaterialIcon("cmd_silverware_fork", '\ue900')
        @JvmField
        val cmd_silverware_spoon = CommunityMaterialIcon("cmd_silverware_spoon", '\ue900')
        @JvmField
        val cmd_silverware_variant = CommunityMaterialIcon("cmd_silverware_variant", '\ue900')
        @JvmField
        val cmd_silverware = CommunityMaterialIcon("cmd_silverware", '\ue900')
        @JvmField
        val cmd_sim_alert = CommunityMaterialIcon("cmd_sim_alert", '\ue900')
        @JvmField
        val cmd_sim_off = CommunityMaterialIcon("cmd_sim_off", '\ue900')
        @JvmField
        val cmd_sim = CommunityMaterialIcon("cmd_sim", '\ue900')
        @JvmField
        val cmd_sina_weibo = CommunityMaterialIcon("cmd_sina_weibo", '\ue900')
        @JvmField
        val cmd_sitemap = CommunityMaterialIcon("cmd_sitemap", '\ue900')
        @JvmField
        val cmd_skate = CommunityMaterialIcon("cmd_skate", '\ue900')
        @JvmField
        val cmd_skew_less = CommunityMaterialIcon("cmd_skew_less", '\ue900')
        @JvmField
        val cmd_skew_more = CommunityMaterialIcon("cmd_skew_more", '\ue900')
        @JvmField
        val cmd_skip_backward_outline = CommunityMaterialIcon("cmd_skip_backward_outline", '\ue900')
        @JvmField
        val cmd_skip_backward = CommunityMaterialIcon("cmd_skip_backward", '\ue900')
        @JvmField
        val cmd_skip_forward_outline = CommunityMaterialIcon("cmd_skip_forward_outline", '\ue900')
        @JvmField
        val cmd_skip_forward = CommunityMaterialIcon("cmd_skip_forward", '\ue900')
        @JvmField
        val cmd_skip_next_circle_outline = CommunityMaterialIcon("cmd_skip_next_circle_outline", '\ue900')
        @JvmField
        val cmd_skip_next_circle = CommunityMaterialIcon("cmd_skip_next_circle", '\ue900')
        @JvmField
        val cmd_skip_next_outline = CommunityMaterialIcon("cmd_skip_next_outline", '\ue900')
        @JvmField
        val cmd_skip_next = CommunityMaterialIcon("cmd_skip_next", '\ue900')
        @JvmField
        val cmd_skip_previous_circle_outline = CommunityMaterialIcon("cmd_skip_previous_circle_outline", '\ue900')
        @JvmField
        val cmd_skip_previous_circle = CommunityMaterialIcon("cmd_skip_previous_circle", '\ue900')
        @JvmField
        val cmd_skip_previous_outline = CommunityMaterialIcon("cmd_skip_previous_outline", '\ue900')
        @JvmField
        val cmd_skip_previous = CommunityMaterialIcon("cmd_skip_previous", '\ue900')
        @JvmField
        val cmd_skull_crossbones_outline = CommunityMaterialIcon("cmd_skull_crossbones_outline", '\ue900')
        @JvmField
        val cmd_skull_crossbones = CommunityMaterialIcon("cmd_skull_crossbones", '\ue900')
        @JvmField
        val cmd_skull_outline = CommunityMaterialIcon("cmd_skull_outline", '\ue900')
        @JvmField
        val cmd_skull = CommunityMaterialIcon("cmd_skull", '\ue900')
        @JvmField
        val cmd_skype_business = CommunityMaterialIcon("cmd_skype_business", '\ue900')
        @JvmField
        val cmd_skype = CommunityMaterialIcon("cmd_skype", '\ue900')
        @JvmField
        val cmd_slack = CommunityMaterialIcon("cmd_slack", '\ue900')
        @JvmField
        val cmd_slackware = CommunityMaterialIcon("cmd_slackware", '\ue900')
        @JvmField
        val cmd_slash_forward_box = CommunityMaterialIcon("cmd_slash_forward_box", '\ue900')
        @JvmField
        val cmd_slash_forward = CommunityMaterialIcon("cmd_slash_forward", '\ue900')
        @JvmField
        val cmd_sleep_off = CommunityMaterialIcon("cmd_sleep_off", '\ue900')
        @JvmField
        val cmd_sleep = CommunityMaterialIcon("cmd_sleep", '\ue900')
        @JvmField
        val cmd_slope_downhill = CommunityMaterialIcon("cmd_slope_downhill", '\ue900')
        @JvmField
        val cmd_slope_uphill = CommunityMaterialIcon("cmd_slope_uphill", '\ue900')
        @JvmField
        val cmd_slot_machine_outline = CommunityMaterialIcon("cmd_slot_machine_outline", '\ue900')
        @JvmField
        val cmd_slot_machine = CommunityMaterialIcon("cmd_slot_machine", '\ue900')
        @JvmField
        val cmd_smart_card_outline = CommunityMaterialIcon("cmd_smart_card_outline", '\ue900')
        @JvmField
        val cmd_smart_card_reader_outline = CommunityMaterialIcon("cmd_smart_card_reader_outline", '\ue900')
        @JvmField
        val cmd_smart_card_reader = CommunityMaterialIcon("cmd_smart_card_reader", '\ue900')
        @JvmField
        val cmd_smart_card = CommunityMaterialIcon("cmd_smart_card", '\ue900')
        @JvmField
        val cmd_smog = CommunityMaterialIcon("cmd_smog", '\ue900')
        @JvmField
        val cmd_smoke_detector = CommunityMaterialIcon("cmd_smoke_detector", '\ue900')
        @JvmField
        val cmd_smoking_off = CommunityMaterialIcon("cmd_smoking_off", '\ue900')
        @JvmField
        val cmd_smoking = CommunityMaterialIcon("cmd_smoking", '\ue900')
        @JvmField
        val cmd_snapchat = CommunityMaterialIcon("cmd_snapchat", '\ue900')
        @JvmField
        val cmd_snowflake_alert = CommunityMaterialIcon("cmd_snowflake_alert", '\ue900')
        @JvmField
        val cmd_snowflake_melt = CommunityMaterialIcon("cmd_snowflake_melt", '\ue900')
        @JvmField
        val cmd_snowflake_variant = CommunityMaterialIcon("cmd_snowflake_variant", '\ue900')
        @JvmField
        val cmd_snowflake = CommunityMaterialIcon("cmd_snowflake", '\ue900')
        @JvmField
        val cmd_snowman = CommunityMaterialIcon("cmd_snowman", '\ue900')
        @JvmField
        val cmd_soccer_field = CommunityMaterialIcon("cmd_soccer_field", '\ue900')
        @JvmField
        val cmd_soccer = CommunityMaterialIcon("cmd_soccer", '\ue900')
        @JvmField
        val cmd_sofa = CommunityMaterialIcon("cmd_sofa", '\ue900')
        @JvmField
        val cmd_solar_panel_large = CommunityMaterialIcon("cmd_solar_panel_large", '\ue900')
        @JvmField
        val cmd_solar_panel = CommunityMaterialIcon("cmd_solar_panel", '\ue900')
        @JvmField
        val cmd_solar_power = CommunityMaterialIcon("cmd_solar_power", '\ue900')
        @JvmField
        val cmd_soldering_iron = CommunityMaterialIcon("cmd_soldering_iron", '\ue900')
        @JvmField
        val cmd_solid = CommunityMaterialIcon("cmd_solid", '\ue900')
        @JvmField
        val cmd_sort_alphabetical_ascending = CommunityMaterialIcon("cmd_sort_alphabetical_ascending", '\ue900')
        @JvmField
        val cmd_sort_alphabetical_descending = CommunityMaterialIcon("cmd_sort_alphabetical_descending", '\ue900')
        @JvmField
        val cmd_sort_alphabetical = CommunityMaterialIcon("cmd_sort_alphabetical", '\ue900')
        @JvmField
        val cmd_sort_ascending = CommunityMaterialIcon("cmd_sort_ascending", '\ue900')
        @JvmField
        val cmd_sort_descending = CommunityMaterialIcon("cmd_sort_descending", '\ue900')
        @JvmField
        val cmd_sort_numeric = CommunityMaterialIcon("cmd_sort_numeric", '\ue900')
        @JvmField
        val cmd_sort_variant_lock_open = CommunityMaterialIcon("cmd_sort_variant_lock_open", '\ue900')
        @JvmField
        val cmd_sort_variant_lock = CommunityMaterialIcon("cmd_sort_variant_lock", '\ue900')
        @JvmField
        val cmd_sort_variant_remove = CommunityMaterialIcon("cmd_sort_variant_remove", '\ue900')
        @JvmField
        val cmd_sort_variant = CommunityMaterialIcon("cmd_sort_variant", '\ue900')
        @JvmField
        val cmd_sort = CommunityMaterialIcon("cmd_sort", '\ue900')
        @JvmField
        val cmd_soundcloud = CommunityMaterialIcon("cmd_soundcloud", '\ue900')
        @JvmField
        val cmd_source_branch = CommunityMaterialIcon("cmd_source_branch", '\ue900')
        @JvmField
        val cmd_source_commit_end_local = CommunityMaterialIcon("cmd_source_commit_end_local", '\ue900')
        @JvmField
        val cmd_source_commit_end = CommunityMaterialIcon("cmd_source_commit_end", '\ue900')
        @JvmField
        val cmd_source_commit_local = CommunityMaterialIcon("cmd_source_commit_local", '\ue900')
        @JvmField
        val cmd_source_commit_next_local = CommunityMaterialIcon("cmd_source_commit_next_local", '\ue900')
        @JvmField
        val cmd_source_commit_start_next_local = CommunityMaterialIcon("cmd_source_commit_start_next_local", '\ue900')
        @JvmField
        val cmd_source_commit_start = CommunityMaterialIcon("cmd_source_commit_start", '\ue900')
        @JvmField
        val cmd_source_commit = CommunityMaterialIcon("cmd_source_commit", '\ue900')
        @JvmField
        val cmd_source_fork = CommunityMaterialIcon("cmd_source_fork", '\ue900')
        @JvmField
        val cmd_source_merge = CommunityMaterialIcon("cmd_source_merge", '\ue900')
        @JvmField
        val cmd_source_pull = CommunityMaterialIcon("cmd_source_pull", '\ue900')
        @JvmField
        val cmd_source_repository_multiple = CommunityMaterialIcon("cmd_source_repository_multiple", '\ue900')
        @JvmField
        val cmd_source_repository = CommunityMaterialIcon("cmd_source_repository", '\ue900')
        @JvmField
        val cmd_soy_sauce = CommunityMaterialIcon("cmd_soy_sauce", '\ue900')
        @JvmField
        val cmd_spa_outline = CommunityMaterialIcon("cmd_spa_outline", '\ue900')
        @JvmField
        val cmd_spa = CommunityMaterialIcon("cmd_spa", '\ue900')
        @JvmField
        val cmd_space_invaders = CommunityMaterialIcon("cmd_space_invaders", '\ue900')
        @JvmField
        val cmd_spade = CommunityMaterialIcon("cmd_spade", '\ue900')
        @JvmField
        val cmd_speaker_bluetooth = CommunityMaterialIcon("cmd_speaker_bluetooth", '\ue900')
        @JvmField
        val cmd_speaker_multiple = CommunityMaterialIcon("cmd_speaker_multiple", '\ue900')
        @JvmField
        val cmd_speaker_off = CommunityMaterialIcon("cmd_speaker_off", '\ue900')
        @JvmField
        val cmd_speaker_wireless = CommunityMaterialIcon("cmd_speaker_wireless", '\ue900')
        @JvmField
        val cmd_speaker = CommunityMaterialIcon("cmd_speaker", '\ue900')
        @JvmField
        val cmd_speedometer_medium = CommunityMaterialIcon("cmd_speedometer_medium", '\ue900')
        @JvmField
        val cmd_speedometer_slow = CommunityMaterialIcon("cmd_speedometer_slow", '\ue900')
        @JvmField
        val cmd_speedometer = CommunityMaterialIcon("cmd_speedometer", '\ue900')
        @JvmField
        val cmd_spellcheck = CommunityMaterialIcon("cmd_spellcheck", '\ue900')
        @JvmField
        val cmd_spider_thread = CommunityMaterialIcon("cmd_spider_thread", '\ue900')
        @JvmField
        val cmd_spider_web = CommunityMaterialIcon("cmd_spider_web", '\ue900')
        @JvmField
        val cmd_spider = CommunityMaterialIcon("cmd_spider", '\ue900')
        @JvmField
        val cmd_spotify = CommunityMaterialIcon("cmd_spotify", '\ue900')
        @JvmField
        val cmd_spotlight_beam = CommunityMaterialIcon("cmd_spotlight_beam", '\ue900')
        @JvmField
        val cmd_spotlight = CommunityMaterialIcon("cmd_spotlight", '\ue900')
        @JvmField
        val cmd_spray_bottle = CommunityMaterialIcon("cmd_spray_bottle", '\ue900')
        @JvmField
        val cmd_spray = CommunityMaterialIcon("cmd_spray", '\ue900')
        @JvmField
        val cmd_sprinkler_variant = CommunityMaterialIcon("cmd_sprinkler_variant", '\ue900')
        @JvmField
        val cmd_sprinkler = CommunityMaterialIcon("cmd_sprinkler", '\ue900')
        @JvmField
        val cmd_sprout_outline = CommunityMaterialIcon("cmd_sprout_outline", '\ue900')
        @JvmField
        val cmd_sprout = CommunityMaterialIcon("cmd_sprout", '\ue900')
        @JvmField
        val cmd_square_edit_outline = CommunityMaterialIcon("cmd_square_edit_outline", '\ue900')
        @JvmField
        val cmd_square_inc_cash = CommunityMaterialIcon("cmd_square_inc_cash", '\ue900')
        @JvmField
        val cmd_square_inc = CommunityMaterialIcon("cmd_square_inc", '\ue900')
        @JvmField
        val cmd_square_medium_outline = CommunityMaterialIcon("cmd_square_medium_outline", '\ue900')
        @JvmField
        val cmd_square_medium = CommunityMaterialIcon("cmd_square_medium", '\ue900')
        @JvmField
        val cmd_square_outline = CommunityMaterialIcon("cmd_square_outline", '\ue900')
        @JvmField
        val cmd_square_root_box = CommunityMaterialIcon("cmd_square_root_box", '\ue900')
        @JvmField
        val cmd_square_root = CommunityMaterialIcon("cmd_square_root", '\ue900')
        @JvmField
        val cmd_square_small = CommunityMaterialIcon("cmd_square_small", '\ue900')
        @JvmField
        val cmd_square = CommunityMaterialIcon("cmd_square", '\ue900')
        @JvmField
        val cmd_squeegee = CommunityMaterialIcon("cmd_squeegee", '\ue900')
        @JvmField
        val cmd_ssh = CommunityMaterialIcon("cmd_ssh", '\ue900')
        @JvmField
        val cmd_stack_exchange = CommunityMaterialIcon("cmd_stack_exchange", '\ue900')
        @JvmField
        val cmd_stack_overflow = CommunityMaterialIcon("cmd_stack_overflow", '\ue900')
        @JvmField
        val cmd_stackpath = CommunityMaterialIcon("cmd_stackpath", '\ue900')
        @JvmField
        val cmd_stadium_variant = CommunityMaterialIcon("cmd_stadium_variant", '\ue900')
        @JvmField
        val cmd_stadium = CommunityMaterialIcon("cmd_stadium", '\ue900')
        @JvmField
        val cmd_stairs_down = CommunityMaterialIcon("cmd_stairs_down", '\ue900')
        @JvmField
        val cmd_stairs_up = CommunityMaterialIcon("cmd_stairs_up", '\ue900')
        @JvmField
        val cmd_stairs = CommunityMaterialIcon("cmd_stairs", '\ue900')
        @JvmField
        val cmd_stamper = CommunityMaterialIcon("cmd_stamper", '\ue900')
        @JvmField
        val cmd_standard_definition = CommunityMaterialIcon("cmd_standard_definition", '\ue900')
        @JvmField
        val cmd_star_box_multiple_outline = CommunityMaterialIcon("cmd_star_box_multiple_outline", '\ue900')
        @JvmField
        val cmd_star_box_multiple = CommunityMaterialIcon("cmd_star_box_multiple", '\ue900')
        @JvmField
        val cmd_star_box_outline = CommunityMaterialIcon("cmd_star_box_outline", '\ue900')
        @JvmField
        val cmd_star_box = CommunityMaterialIcon("cmd_star_box", '\ue900')
        @JvmField
        val cmd_star_circle_outline = CommunityMaterialIcon("cmd_star_circle_outline", '\ue900')
        @JvmField
        val cmd_star_circle = CommunityMaterialIcon("cmd_star_circle", '\ue900')
        @JvmField
        val cmd_star_face = CommunityMaterialIcon("cmd_star_face", '\ue900')
        @JvmField
        val cmd_star_four_points_outline = CommunityMaterialIcon("cmd_star_four_points_outline", '\ue900')
        @JvmField
        val cmd_star_four_points = CommunityMaterialIcon("cmd_star_four_points", '\ue900')
        @JvmField
        val cmd_star_half = CommunityMaterialIcon("cmd_star_half", '\ue900')
        @JvmField
        val cmd_star_off = CommunityMaterialIcon("cmd_star_off", '\ue900')
        @JvmField
        val cmd_star_outline = CommunityMaterialIcon("cmd_star_outline", '\ue900')
        @JvmField
        val cmd_star_three_points_outline = CommunityMaterialIcon("cmd_star_three_points_outline", '\ue900')
        @JvmField
        val cmd_star_three_points = CommunityMaterialIcon("cmd_star_three_points", '\ue900')
        @JvmField
        val cmd_star = CommunityMaterialIcon("cmd_star", '\ue900')
        @JvmField
        val cmd_state_machine = CommunityMaterialIcon("cmd_state_machine", '\ue900')
        @JvmField
        val cmd_steam_box = CommunityMaterialIcon("cmd_steam_box", '\ue900')
        @JvmField
        val cmd_steam = CommunityMaterialIcon("cmd_steam", '\ue900')
        @JvmField
        val cmd_steering_off = CommunityMaterialIcon("cmd_steering_off", '\ue900')
        @JvmField
        val cmd_steering = CommunityMaterialIcon("cmd_steering", '\ue900')
        @JvmField
        val cmd_step_backward_2 = CommunityMaterialIcon("cmd_step_backward_2", '\ue900')
        @JvmField
        val cmd_step_backward = CommunityMaterialIcon("cmd_step_backward", '\ue900')
        @JvmField
        val cmd_step_forward_2 = CommunityMaterialIcon("cmd_step_forward_2", '\ue900')
        @JvmField
        val cmd_step_forward = CommunityMaterialIcon("cmd_step_forward", '\ue900')
        @JvmField
        val cmd_stethoscope = CommunityMaterialIcon("cmd_stethoscope", '\ue900')
        @JvmField
        val cmd_sticker_emoji = CommunityMaterialIcon("cmd_sticker_emoji", '\ue900')
        @JvmField
        val cmd_sticker = CommunityMaterialIcon("cmd_sticker", '\ue900')
        @JvmField
        val cmd_stocking = CommunityMaterialIcon("cmd_stocking", '\ue900')
        @JvmField
        val cmd_stomach = CommunityMaterialIcon("cmd_stomach", '\ue900')
        @JvmField
        val cmd_stop_circle_outline = CommunityMaterialIcon("cmd_stop_circle_outline", '\ue900')
        @JvmField
        val cmd_stop_circle = CommunityMaterialIcon("cmd_stop_circle", '\ue900')
        @JvmField
        val cmd_stop = CommunityMaterialIcon("cmd_stop", '\ue900')
        @JvmField
        val cmd_store_24_hour = CommunityMaterialIcon("cmd_store_24_hour", '\ue900')
        @JvmField
        val cmd_store = CommunityMaterialIcon("cmd_store", '\ue900')
        @JvmField
        val cmd_storefront = CommunityMaterialIcon("cmd_storefront", '\ue900')
        @JvmField
        val cmd_stove = CommunityMaterialIcon("cmd_stove", '\ue900')
        @JvmField
        val cmd_strategy = CommunityMaterialIcon("cmd_strategy", '\ue900')
        @JvmField
        val cmd_strava = CommunityMaterialIcon("cmd_strava", '\ue900')
        @JvmField
        val cmd_stretch_to_page_outline = CommunityMaterialIcon("cmd_stretch_to_page_outline", '\ue900')
        @JvmField
        val cmd_stretch_to_page = CommunityMaterialIcon("cmd_stretch_to_page", '\ue900')
        @JvmField
        val cmd_string_lights_off = CommunityMaterialIcon("cmd_string_lights_off", '\ue900')
        @JvmField
        val cmd_string_lights = CommunityMaterialIcon("cmd_string_lights", '\ue900')
        @JvmField
        val cmd_subdirectory_arrow_left = CommunityMaterialIcon("cmd_subdirectory_arrow_left", '\ue900')
        @JvmField
        val cmd_subdirectory_arrow_right = CommunityMaterialIcon("cmd_subdirectory_arrow_right", '\ue900')
        @JvmField
        val cmd_subtitles_outline = CommunityMaterialIcon("cmd_subtitles_outline", '\ue900')
        @JvmField
        val cmd_subtitles = CommunityMaterialIcon("cmd_subtitles", '\ue900')
        @JvmField
        val cmd_subway_alert_variant = CommunityMaterialIcon("cmd_subway_alert_variant", '\ue900')
        @JvmField
        val cmd_subway_variant = CommunityMaterialIcon("cmd_subway_variant", '\ue900')
        @JvmField
        val cmd_subway = CommunityMaterialIcon("cmd_subway", '\ue900')
        @JvmField
        val cmd_summit = CommunityMaterialIcon("cmd_summit", '\ue900')
        @JvmField
        val cmd_sunglasses = CommunityMaterialIcon("cmd_sunglasses", '\ue900')
        @JvmField
        val cmd_surround_sound_2_0 = CommunityMaterialIcon("cmd_surround_sound_2_0", '\ue900')
        @JvmField
        val cmd_surround_sound_3_1 = CommunityMaterialIcon("cmd_surround_sound_3_1", '\ue900')
        @JvmField
        val cmd_surround_sound_5_1 = CommunityMaterialIcon("cmd_surround_sound_5_1", '\ue900')
        @JvmField
        val cmd_surround_sound_7_1 = CommunityMaterialIcon("cmd_surround_sound_7_1", '\ue900')
        @JvmField
        val cmd_surround_sound = CommunityMaterialIcon("cmd_surround_sound", '\ue900')
        @JvmField
        val cmd_svg = CommunityMaterialIcon("cmd_svg", '\ue900')
        @JvmField
        val cmd_swap_horizontal_bold = CommunityMaterialIcon("cmd_swap_horizontal_bold", '\ue900')
        @JvmField
        val cmd_swap_horizontal_circle_outline = CommunityMaterialIcon("cmd_swap_horizontal_circle_outline", '\ue900')
        @JvmField
        val cmd_swap_horizontal_circle = CommunityMaterialIcon("cmd_swap_horizontal_circle", '\ue900')
        @JvmField
        val cmd_swap_horizontal_variant = CommunityMaterialIcon("cmd_swap_horizontal_variant", '\ue900')
        @JvmField
        val cmd_swap_horizontal = CommunityMaterialIcon("cmd_swap_horizontal", '\ue900')
        @JvmField
        val cmd_swap_vertical_bold = CommunityMaterialIcon("cmd_swap_vertical_bold", '\ue900')
        @JvmField
        val cmd_swap_vertical_circle_outline = CommunityMaterialIcon("cmd_swap_vertical_circle_outline", '\ue900')
        @JvmField
        val cmd_swap_vertical_circle = CommunityMaterialIcon("cmd_swap_vertical_circle", '\ue900')
        @JvmField
        val cmd_swap_vertical_variant = CommunityMaterialIcon("cmd_swap_vertical_variant", '\ue900')
        @JvmField
        val cmd_swap_vertical = CommunityMaterialIcon("cmd_swap_vertical", '\ue900')
        @JvmField
        val cmd_swim = CommunityMaterialIcon("cmd_swim", '\ue900')
        @JvmField
        val cmd_switch = CommunityMaterialIcon("cmd_switch", '\ue900')
        @JvmField
        val cmd_sword_cross = CommunityMaterialIcon("cmd_sword_cross", '\ue900')
        @JvmField
        val cmd_sword = CommunityMaterialIcon("cmd_sword", '\ue900')
        @JvmField
        val cmd_symfony = CommunityMaterialIcon("cmd_symfony", '\ue900')
        @JvmField
        val cmd_sync_alert = CommunityMaterialIcon("cmd_sync_alert", '\ue900')
        @JvmField
        val cmd_sync_off = CommunityMaterialIcon("cmd_sync_off", '\ue900')
        @JvmField
        val cmd_sync = CommunityMaterialIcon("cmd_sync", '\ue900')
        @JvmField
        val cmd_tab_minus = CommunityMaterialIcon("cmd_tab_minus", '\ue900')
        @JvmField
        val cmd_tab_plus = CommunityMaterialIcon("cmd_tab_plus", '\ue900')
        @JvmField
        val cmd_tab_remove = CommunityMaterialIcon("cmd_tab_remove", '\ue900')
        @JvmField
        val cmd_tab_unselected = CommunityMaterialIcon("cmd_tab_unselected", '\ue900')
        @JvmField
        val cmd_tab = CommunityMaterialIcon("cmd_tab", '\ue900')
        @JvmField
        val cmd_table_border = CommunityMaterialIcon("cmd_table_border", '\ue900')
        @JvmField
        val cmd_table_chair = CommunityMaterialIcon("cmd_table_chair", '\ue900')
        @JvmField
        val cmd_table_column_plus_after = CommunityMaterialIcon("cmd_table_column_plus_after", '\ue900')
        @JvmField
        val cmd_table_column_plus_before = CommunityMaterialIcon("cmd_table_column_plus_before", '\ue900')
        @JvmField
        val cmd_table_column_remove = CommunityMaterialIcon("cmd_table_column_remove", '\ue900')
        @JvmField
        val cmd_table_column_width = CommunityMaterialIcon("cmd_table_column_width", '\ue900')
        @JvmField
        val cmd_table_column = CommunityMaterialIcon("cmd_table_column", '\ue900')
        @JvmField
        val cmd_table_edit = CommunityMaterialIcon("cmd_table_edit", '\ue900')
        @JvmField
        val cmd_table_eye = CommunityMaterialIcon("cmd_table_eye", '\ue900')
        @JvmField
        val cmd_table_headers_eye_off = CommunityMaterialIcon("cmd_table_headers_eye_off", '\ue900')
        @JvmField
        val cmd_table_headers_eye = CommunityMaterialIcon("cmd_table_headers_eye", '\ue900')
        @JvmField
        val cmd_table_large_plus = CommunityMaterialIcon("cmd_table_large_plus", '\ue900')
        @JvmField
        val cmd_table_large_remove = CommunityMaterialIcon("cmd_table_large_remove", '\ue900')
        @JvmField
        val cmd_table_large = CommunityMaterialIcon("cmd_table_large", '\ue900')
        @JvmField
        val cmd_table_merge_cells = CommunityMaterialIcon("cmd_table_merge_cells", '\ue900')
        @JvmField
        val cmd_table_of_contents = CommunityMaterialIcon("cmd_table_of_contents", '\ue900')
        @JvmField
        val cmd_table_plus = CommunityMaterialIcon("cmd_table_plus", '\ue900')
        @JvmField
        val cmd_table_remove = CommunityMaterialIcon("cmd_table_remove", '\ue900')
        @JvmField
        val cmd_table_row_height = CommunityMaterialIcon("cmd_table_row_height", '\ue900')
        @JvmField
        val cmd_table_row_plus_after = CommunityMaterialIcon("cmd_table_row_plus_after", '\ue900')
        @JvmField
        val cmd_table_row_plus_before = CommunityMaterialIcon("cmd_table_row_plus_before", '\ue900')
        @JvmField
        val cmd_table_row_remove = CommunityMaterialIcon("cmd_table_row_remove", '\ue900')
        @JvmField
        val cmd_table_row = CommunityMaterialIcon("cmd_table_row", '\ue900')
        @JvmField
        val cmd_table_search = CommunityMaterialIcon("cmd_table_search", '\ue900')
        @JvmField
        val cmd_table_settings = CommunityMaterialIcon("cmd_table_settings", '\ue900')
        @JvmField
        val cmd_table_tennis = CommunityMaterialIcon("cmd_table_tennis", '\ue900')
        @JvmField
        val cmd_table = CommunityMaterialIcon("cmd_table", '\ue900')
        @JvmField
        val cmd_tablet_android = CommunityMaterialIcon("cmd_tablet_android", '\ue900')
        @JvmField
        val cmd_tablet_cellphone = CommunityMaterialIcon("cmd_tablet_cellphone", '\ue900')
        @JvmField
        val cmd_tablet_dashboard = CommunityMaterialIcon("cmd_tablet_dashboard", '\ue900')
        @JvmField
        val cmd_tablet_ipad = CommunityMaterialIcon("cmd_tablet_ipad", '\ue900')
        @JvmField
        val cmd_tablet = CommunityMaterialIcon("cmd_tablet", '\ue900')
        @JvmField
        val cmd_taco = CommunityMaterialIcon("cmd_taco", '\ue900')
        @JvmField
        val cmd_tag_faces = CommunityMaterialIcon("cmd_tag_faces", '\ue900')
        @JvmField
        val cmd_tag_heart_outline = CommunityMaterialIcon("cmd_tag_heart_outline", '\ue900')
        @JvmField
        val cmd_tag_heart = CommunityMaterialIcon("cmd_tag_heart", '\ue900')
        @JvmField
        val cmd_tag_minus_outline = CommunityMaterialIcon("cmd_tag_minus_outline", '\ue900')
        @JvmField
        val cmd_tag_minus = CommunityMaterialIcon("cmd_tag_minus", '\ue900')
        @JvmField
        val cmd_tag_multiple = CommunityMaterialIcon("cmd_tag_multiple", '\ue900')
        @JvmField
        val cmd_tag_off_outline = CommunityMaterialIcon("cmd_tag_off_outline", '\ue900')
        @JvmField
        val cmd_tag_off = CommunityMaterialIcon("cmd_tag_off", '\ue900')
        @JvmField
        val cmd_tag_outline = CommunityMaterialIcon("cmd_tag_outline", '\ue900')
        @JvmField
        val cmd_tag_plus_outline = CommunityMaterialIcon("cmd_tag_plus_outline", '\ue900')
        @JvmField
        val cmd_tag_plus = CommunityMaterialIcon("cmd_tag_plus", '\ue900')
        @JvmField
        val cmd_tag_remove_outline = CommunityMaterialIcon("cmd_tag_remove_outline", '\ue900')
        @JvmField
        val cmd_tag_remove = CommunityMaterialIcon("cmd_tag_remove", '\ue900')
        @JvmField
        val cmd_tag_text_outline = CommunityMaterialIcon("cmd_tag_text_outline", '\ue900')
        @JvmField
        val cmd_tag_text = CommunityMaterialIcon("cmd_tag_text", '\ue900')
        @JvmField
        val cmd_tag = CommunityMaterialIcon("cmd_tag", '\ue900')
        @JvmField
        val cmd_tank = CommunityMaterialIcon("cmd_tank", '\ue900')
        @JvmField
        val cmd_tanker_truck = CommunityMaterialIcon("cmd_tanker_truck", '\ue900')
        @JvmField
        val cmd_tape_measure = CommunityMaterialIcon("cmd_tape_measure", '\ue900')
        @JvmField
        val cmd_target_account = CommunityMaterialIcon("cmd_target_account", '\ue900')
        @JvmField
        val cmd_target_variant = CommunityMaterialIcon("cmd_target_variant", '\ue900')
        @JvmField
        val cmd_target = CommunityMaterialIcon("cmd_target", '\ue900')
        @JvmField
        val cmd_taxi = CommunityMaterialIcon("cmd_taxi", '\ue900')
        @JvmField
        val cmd_tea_outline = CommunityMaterialIcon("cmd_tea_outline", '\ue900')
        @JvmField
        val cmd_tea = CommunityMaterialIcon("cmd_tea", '\ue900')
        @JvmField
        val cmd_teach = CommunityMaterialIcon("cmd_teach", '\ue900')
        @JvmField
        val cmd_teamviewer = CommunityMaterialIcon("cmd_teamviewer", '\ue900')
        @JvmField
        val cmd_telegram = CommunityMaterialIcon("cmd_telegram", '\ue900')
        @JvmField
        val cmd_telescope = CommunityMaterialIcon("cmd_telescope", '\ue900')
        @JvmField
        val cmd_television_box = CommunityMaterialIcon("cmd_television_box", '\ue900')
        @JvmField
        val cmd_television_classic_off = CommunityMaterialIcon("cmd_television_classic_off", '\ue900')
        @JvmField
        val cmd_television_classic = CommunityMaterialIcon("cmd_television_classic", '\ue900')
        @JvmField
        val cmd_television_clean = CommunityMaterialIcon("cmd_television_clean", '\ue900')
        @JvmField
        val cmd_television_guide = CommunityMaterialIcon("cmd_television_guide", '\ue900')
        @JvmField
        val cmd_television_off = CommunityMaterialIcon("cmd_television_off", '\ue900')
        @JvmField
        val cmd_television_pause = CommunityMaterialIcon("cmd_television_pause", '\ue900')
        @JvmField
        val cmd_television_play = CommunityMaterialIcon("cmd_television_play", '\ue900')
        @JvmField
        val cmd_television_stop = CommunityMaterialIcon("cmd_television_stop", '\ue900')
        @JvmField
        val cmd_television = CommunityMaterialIcon("cmd_television", '\ue900')
        @JvmField
        val cmd_temperature_celsius = CommunityMaterialIcon("cmd_temperature_celsius", '\ue900')
        @JvmField
        val cmd_temperature_fahrenheit = CommunityMaterialIcon("cmd_temperature_fahrenheit", '\ue900')
        @JvmField
        val cmd_temperature_kelvin = CommunityMaterialIcon("cmd_temperature_kelvin", '\ue900')
        @JvmField
        val cmd_tennis_ball = CommunityMaterialIcon("cmd_tennis_ball", '\ue900')
        @JvmField
        val cmd_tennis = CommunityMaterialIcon("cmd_tennis", '\ue900')
        @JvmField
        val cmd_tent = CommunityMaterialIcon("cmd_tent", '\ue900')
        @JvmField
        val cmd_terraform = CommunityMaterialIcon("cmd_terraform", '\ue900')
        @JvmField
        val cmd_terrain = CommunityMaterialIcon("cmd_terrain", '\ue900')
        @JvmField
        val cmd_test_tube_empty = CommunityMaterialIcon("cmd_test_tube_empty", '\ue900')
        @JvmField
        val cmd_test_tube_off = CommunityMaterialIcon("cmd_test_tube_off", '\ue900')
        @JvmField
        val cmd_test_tube = CommunityMaterialIcon("cmd_test_tube", '\ue900')
        @JvmField
        val cmd_text_recognition = CommunityMaterialIcon("cmd_text_recognition", '\ue900')
        @JvmField
        val cmd_text_shadow = CommunityMaterialIcon("cmd_text_shadow", '\ue900')
        @JvmField
        val cmd_text_short = CommunityMaterialIcon("cmd_text_short", '\ue900')
        @JvmField
        val cmd_text_subject = CommunityMaterialIcon("cmd_text_subject", '\ue900')
        @JvmField
        val cmd_text_to_speech_off = CommunityMaterialIcon("cmd_text_to_speech_off", '\ue900')
        @JvmField
        val cmd_text_to_speech = CommunityMaterialIcon("cmd_text_to_speech", '\ue900')
        @JvmField
        val cmd_text = CommunityMaterialIcon("cmd_text", '\ue900')
        @JvmField
        val cmd_textarea = CommunityMaterialIcon("cmd_textarea", '\ue900')
        @JvmField
        val cmd_textbox_password = CommunityMaterialIcon("cmd_textbox_password", '\ue900')
        @JvmField
        val cmd_textbox = CommunityMaterialIcon("cmd_textbox", '\ue900')
        @JvmField
        val cmd_texture_box = CommunityMaterialIcon("cmd_texture_box", '\ue900')
        @JvmField
        val cmd_texture = CommunityMaterialIcon("cmd_texture", '\ue900')
        @JvmField
        val cmd_theater = CommunityMaterialIcon("cmd_theater", '\ue900')
        @JvmField
        val cmd_theme_light_dark = CommunityMaterialIcon("cmd_theme_light_dark", '\ue900')
        @JvmField
        val cmd_thermometer_alert = CommunityMaterialIcon("cmd_thermometer_alert", '\ue900')
        @JvmField
        val cmd_thermometer_chevron_down = CommunityMaterialIcon("cmd_thermometer_chevron_down", '\ue900')
        @JvmField
        val cmd_thermometer_chevron_up = CommunityMaterialIcon("cmd_thermometer_chevron_up", '\ue900')
        @JvmField
        val cmd_thermometer_high = CommunityMaterialIcon("cmd_thermometer_high", '\ue900')
        @JvmField
        val cmd_thermometer_lines = CommunityMaterialIcon("cmd_thermometer_lines", '\ue900')
        @JvmField
        val cmd_thermometer_low = CommunityMaterialIcon("cmd_thermometer_low", '\ue900')
        @JvmField
        val cmd_thermometer_minus = CommunityMaterialIcon("cmd_thermometer_minus", '\ue900')
        @JvmField
        val cmd_thermometer_plus = CommunityMaterialIcon("cmd_thermometer_plus", '\ue900')
        @JvmField
        val cmd_thermometer = CommunityMaterialIcon("cmd_thermometer", '\ue900')
        @JvmField
        val cmd_thermostat_box = CommunityMaterialIcon("cmd_thermostat_box", '\ue900')
        @JvmField
        val cmd_thermostat = CommunityMaterialIcon("cmd_thermostat", '\ue900')
        @JvmField
        val cmd_thought_bubble_outline = CommunityMaterialIcon("cmd_thought_bubble_outline", '\ue900')
        @JvmField
        val cmd_thought_bubble = CommunityMaterialIcon("cmd_thought_bubble", '\ue900')
        @JvmField
        val cmd_thumb_down_outline = CommunityMaterialIcon("cmd_thumb_down_outline", '\ue900')
        @JvmField
        val cmd_thumb_down = CommunityMaterialIcon("cmd_thumb_down", '\ue900')
        @JvmField
        val cmd_thumb_up_outline = CommunityMaterialIcon("cmd_thumb_up_outline", '\ue900')
        @JvmField
        val cmd_thumb_up = CommunityMaterialIcon("cmd_thumb_up", '\ue900')
        @JvmField
        val cmd_thumbs_up_down = CommunityMaterialIcon("cmd_thumbs_up_down", '\ue900')
        @JvmField
        val cmd_ticket_account = CommunityMaterialIcon("cmd_ticket_account", '\ue900')
        @JvmField
        val cmd_ticket_confirmation = CommunityMaterialIcon("cmd_ticket_confirmation", '\ue900')
        @JvmField
        val cmd_ticket_outline = CommunityMaterialIcon("cmd_ticket_outline", '\ue900')
        @JvmField
        val cmd_ticket_percent = CommunityMaterialIcon("cmd_ticket_percent", '\ue900')
        @JvmField
        val cmd_ticket = CommunityMaterialIcon("cmd_ticket", '\ue900')
        @JvmField
        val cmd_tie = CommunityMaterialIcon("cmd_tie", '\ue900')
        @JvmField
        val cmd_tilde = CommunityMaterialIcon("cmd_tilde", '\ue900')
        @JvmField
        val cmd_timelapse = CommunityMaterialIcon("cmd_timelapse", '\ue900')
        @JvmField
        val cmd_timeline_alert_outline = CommunityMaterialIcon("cmd_timeline_alert_outline", '\ue900')
        @JvmField
        val cmd_timeline_alert = CommunityMaterialIcon("cmd_timeline_alert", '\ue900')
        @JvmField
        val cmd_timeline_clock_outline = CommunityMaterialIcon("cmd_timeline_clock_outline", '\ue900')
        @JvmField
        val cmd_timeline_clock = CommunityMaterialIcon("cmd_timeline_clock", '\ue900')
        @JvmField
        val cmd_timeline_help_outline = CommunityMaterialIcon("cmd_timeline_help_outline", '\ue900')
        @JvmField
        val cmd_timeline_help = CommunityMaterialIcon("cmd_timeline_help", '\ue900')
        @JvmField
        val cmd_timeline_outline = CommunityMaterialIcon("cmd_timeline_outline", '\ue900')
        @JvmField
        val cmd_timeline_plus_outline = CommunityMaterialIcon("cmd_timeline_plus_outline", '\ue900')
        @JvmField
        val cmd_timeline_plus = CommunityMaterialIcon("cmd_timeline_plus", '\ue900')
        @JvmField
        val cmd_timeline_text_outline = CommunityMaterialIcon("cmd_timeline_text_outline", '\ue900')
        @JvmField
        val cmd_timeline_text = CommunityMaterialIcon("cmd_timeline_text", '\ue900')
        @JvmField
        val cmd_timeline = CommunityMaterialIcon("cmd_timeline", '\ue900')
        @JvmField
        val cmd_timer_3 = CommunityMaterialIcon("cmd_timer_3", '\ue900')
        @JvmField
        val cmd_timer_10 = CommunityMaterialIcon("cmd_timer_10", '\ue900')
        @JvmField
        val cmd_timer_off = CommunityMaterialIcon("cmd_timer_off", '\ue900')
        @JvmField
        val cmd_timer_sand_empty = CommunityMaterialIcon("cmd_timer_sand_empty", '\ue900')
        @JvmField
        val cmd_timer_sand_full = CommunityMaterialIcon("cmd_timer_sand_full", '\ue900')
        @JvmField
        val cmd_timer_sand = CommunityMaterialIcon("cmd_timer_sand", '\ue900')
        @JvmField
        val cmd_timer = CommunityMaterialIcon("cmd_timer", '\ue900')
        @JvmField
        val cmd_timetable = CommunityMaterialIcon("cmd_timetable", '\ue900')
        @JvmField
        val cmd_toaster_off = CommunityMaterialIcon("cmd_toaster_off", '\ue900')
        @JvmField
        val cmd_toaster_oven = CommunityMaterialIcon("cmd_toaster_oven", '\ue900')
        @JvmField
        val cmd_toaster = CommunityMaterialIcon("cmd_toaster", '\ue900')
        @JvmField
        val cmd_toggle_switch_off_outline = CommunityMaterialIcon("cmd_toggle_switch_off_outline", '\ue900')
        @JvmField
        val cmd_toggle_switch_off = CommunityMaterialIcon("cmd_toggle_switch_off", '\ue900')
        @JvmField
        val cmd_toggle_switch_outline = CommunityMaterialIcon("cmd_toggle_switch_outline", '\ue900')
        @JvmField
        val cmd_toggle_switch = CommunityMaterialIcon("cmd_toggle_switch", '\ue900')
        @JvmField
        val cmd_toilet = CommunityMaterialIcon("cmd_toilet", '\ue900')
        @JvmField
        val cmd_toolbox_outline = CommunityMaterialIcon("cmd_toolbox_outline", '\ue900')
        @JvmField
        val cmd_toolbox = CommunityMaterialIcon("cmd_toolbox", '\ue900')
        @JvmField
        val cmd_tools = CommunityMaterialIcon("cmd_tools", '\ue900')
        @JvmField
        val cmd_tooltip_account = CommunityMaterialIcon("cmd_tooltip_account", '\ue900')
        @JvmField
        val cmd_tooltip_edit_outline = CommunityMaterialIcon("cmd_tooltip_edit_outline", '\ue900')
        @JvmField
        val cmd_tooltip_edit = CommunityMaterialIcon("cmd_tooltip_edit", '\ue900')
        @JvmField
        val cmd_tooltip_image_outline = CommunityMaterialIcon("cmd_tooltip_image_outline", '\ue900')
        @JvmField
        val cmd_tooltip_image = CommunityMaterialIcon("cmd_tooltip_image", '\ue900')
        @JvmField
        val cmd_tooltip_outline = CommunityMaterialIcon("cmd_tooltip_outline", '\ue900')
        @JvmField
        val cmd_tooltip_plus_outline = CommunityMaterialIcon("cmd_tooltip_plus_outline", '\ue900')
        @JvmField
        val cmd_tooltip_plus = CommunityMaterialIcon("cmd_tooltip_plus", '\ue900')
        @JvmField
        val cmd_tooltip_text_outline = CommunityMaterialIcon("cmd_tooltip_text_outline", '\ue900')
        @JvmField
        val cmd_tooltip_text = CommunityMaterialIcon("cmd_tooltip_text", '\ue900')
        @JvmField
        val cmd_tooltip = CommunityMaterialIcon("cmd_tooltip", '\ue900')
        @JvmField
        val cmd_tooth_outline = CommunityMaterialIcon("cmd_tooth_outline", '\ue900')
        @JvmField
        val cmd_tooth = CommunityMaterialIcon("cmd_tooth", '\ue900')
        @JvmField
        val cmd_toothbrush_electric = CommunityMaterialIcon("cmd_toothbrush_electric", '\ue900')
        @JvmField
        val cmd_toothbrush_paste = CommunityMaterialIcon("cmd_toothbrush_paste", '\ue900')
        @JvmField
        val cmd_toothbrush = CommunityMaterialIcon("cmd_toothbrush", '\ue900')
        @JvmField
        val cmd_tor = CommunityMaterialIcon("cmd_tor", '\ue900')
        @JvmField
        val cmd_tortoise = CommunityMaterialIcon("cmd_tortoise", '\ue900')
        @JvmField
        val cmd_toslink = CommunityMaterialIcon("cmd_toslink", '\ue900')
        @JvmField
        val cmd_tournament = CommunityMaterialIcon("cmd_tournament", '\ue900')
        @JvmField
        val cmd_tower_beach = CommunityMaterialIcon("cmd_tower_beach", '\ue900')
        @JvmField
        val cmd_tower_fire = CommunityMaterialIcon("cmd_tower_fire", '\ue900')
        @JvmField
        val cmd_towing = CommunityMaterialIcon("cmd_towing", '\ue900')
        @JvmField
        val cmd_toy_brick_marker_outline = CommunityMaterialIcon("cmd_toy_brick_marker_outline", '\ue900')
        @JvmField
        val cmd_toy_brick_marker = CommunityMaterialIcon("cmd_toy_brick_marker", '\ue900')
        @JvmField
        val cmd_toy_brick_minus_outline = CommunityMaterialIcon("cmd_toy_brick_minus_outline", '\ue900')
        @JvmField
        val cmd_toy_brick_minus = CommunityMaterialIcon("cmd_toy_brick_minus", '\ue900')
        @JvmField
        val cmd_toy_brick_outline = CommunityMaterialIcon("cmd_toy_brick_outline", '\ue900')
        @JvmField
        val cmd_toy_brick_plus_outline = CommunityMaterialIcon("cmd_toy_brick_plus_outline", '\ue900')
        @JvmField
        val cmd_toy_brick_plus = CommunityMaterialIcon("cmd_toy_brick_plus", '\ue900')
        @JvmField
        val cmd_toy_brick_remove_outline = CommunityMaterialIcon("cmd_toy_brick_remove_outline", '\ue900')
        @JvmField
        val cmd_toy_brick_remove = CommunityMaterialIcon("cmd_toy_brick_remove", '\ue900')
        @JvmField
        val cmd_toy_brick_search_outline = CommunityMaterialIcon("cmd_toy_brick_search_outline", '\ue900')
        @JvmField
        val cmd_toy_brick_search = CommunityMaterialIcon("cmd_toy_brick_search", '\ue900')
        @JvmField
        val cmd_toy_brick = CommunityMaterialIcon("cmd_toy_brick", '\ue900')
        @JvmField
        val cmd_track_light = CommunityMaterialIcon("cmd_track_light", '\ue900')
        @JvmField
        val cmd_trackpad_lock = CommunityMaterialIcon("cmd_trackpad_lock", '\ue900')
        @JvmField
        val cmd_trackpad = CommunityMaterialIcon("cmd_trackpad", '\ue900')
        @JvmField
        val cmd_tractor = CommunityMaterialIcon("cmd_tractor", '\ue900')
        @JvmField
        val cmd_trademark = CommunityMaterialIcon("cmd_trademark", '\ue900')
        @JvmField
        val cmd_traffic_light = CommunityMaterialIcon("cmd_traffic_light", '\ue900')
        @JvmField
        val cmd_train_car = CommunityMaterialIcon("cmd_train_car", '\ue900')
        @JvmField
        val cmd_train_variant = CommunityMaterialIcon("cmd_train_variant", '\ue900')
        @JvmField
        val cmd_train = CommunityMaterialIcon("cmd_train", '\ue900')
        @JvmField
        val cmd_tram_side = CommunityMaterialIcon("cmd_tram_side", '\ue900')
        @JvmField
        val cmd_tram = CommunityMaterialIcon("cmd_tram", '\ue900')
        @JvmField
        val cmd_transcribe_close = CommunityMaterialIcon("cmd_transcribe_close", '\ue900')
        @JvmField
        val cmd_transcribe = CommunityMaterialIcon("cmd_transcribe", '\ue900')
        @JvmField
        val cmd_transfer_down = CommunityMaterialIcon("cmd_transfer_down", '\ue900')
        @JvmField
        val cmd_transfer_left = CommunityMaterialIcon("cmd_transfer_left", '\ue900')
        @JvmField
        val cmd_transfer_right = CommunityMaterialIcon("cmd_transfer_right", '\ue900')
        @JvmField
        val cmd_transfer_up = CommunityMaterialIcon("cmd_transfer_up", '\ue900')
        @JvmField
        val cmd_transfer = CommunityMaterialIcon("cmd_transfer", '\ue900')
        @JvmField
        val cmd_transit_connection_variant = CommunityMaterialIcon("cmd_transit_connection_variant", '\ue900')
        @JvmField
        val cmd_transit_connection = CommunityMaterialIcon("cmd_transit_connection", '\ue900')
        @JvmField
        val cmd_transit_detour = CommunityMaterialIcon("cmd_transit_detour", '\ue900')
        @JvmField
        val cmd_transit_transfer = CommunityMaterialIcon("cmd_transit_transfer", '\ue900')
        @JvmField
        val cmd_transition_masked = CommunityMaterialIcon("cmd_transition_masked", '\ue900')
        @JvmField
        val cmd_transition = CommunityMaterialIcon("cmd_transition", '\ue900')
        @JvmField
        val cmd_translate_off = CommunityMaterialIcon("cmd_translate_off", '\ue900')
        @JvmField
        val cmd_translate = CommunityMaterialIcon("cmd_translate", '\ue900')
        @JvmField
        val cmd_transmission_tower = CommunityMaterialIcon("cmd_transmission_tower", '\ue900')
        @JvmField
        val cmd_trash_can_outline = CommunityMaterialIcon("cmd_trash_can_outline", '\ue900')
        @JvmField
        val cmd_trash_can = CommunityMaterialIcon("cmd_trash_can", '\ue900')
        @JvmField
        val cmd_tray_alert = CommunityMaterialIcon("cmd_tray_alert", '\ue900')
        @JvmField
        val cmd_tray_full = CommunityMaterialIcon("cmd_tray_full", '\ue900')
        @JvmField
        val cmd_tray_minus = CommunityMaterialIcon("cmd_tray_minus", '\ue900')
        @JvmField
        val cmd_tray_plus = CommunityMaterialIcon("cmd_tray_plus", '\ue900')
        @JvmField
        val cmd_tray_remove = CommunityMaterialIcon("cmd_tray_remove", '\ue900')
        @JvmField
        val cmd_tray = CommunityMaterialIcon("cmd_tray", '\ue900')
        @JvmField
        val cmd_treasure_chest = CommunityMaterialIcon("cmd_treasure_chest", '\ue900')
        @JvmField
        val cmd_tree_outline = CommunityMaterialIcon("cmd_tree_outline", '\ue900')
        @JvmField
        val cmd_tree = CommunityMaterialIcon("cmd_tree", '\ue900')
        @JvmField
        val cmd_trello = CommunityMaterialIcon("cmd_trello", '\ue900')
        @JvmField
        val cmd_trending_down = CommunityMaterialIcon("cmd_trending_down", '\ue900')
        @JvmField
        val cmd_trending_neutral = CommunityMaterialIcon("cmd_trending_neutral", '\ue900')
        @JvmField
        val cmd_trending_up = CommunityMaterialIcon("cmd_trending_up", '\ue900')
        @JvmField
        val cmd_triangle_outline = CommunityMaterialIcon("cmd_triangle_outline", '\ue900')
        @JvmField
        val cmd_triangle = CommunityMaterialIcon("cmd_triangle", '\ue900')
        @JvmField
        val cmd_triforce = CommunityMaterialIcon("cmd_triforce", '\ue900')
        @JvmField
        val cmd_trophy_award = CommunityMaterialIcon("cmd_trophy_award", '\ue900')
        @JvmField
        val cmd_trophy_broken = CommunityMaterialIcon("cmd_trophy_broken", '\ue900')
        @JvmField
        val cmd_trophy_outline = CommunityMaterialIcon("cmd_trophy_outline", '\ue900')
        @JvmField
        val cmd_trophy_variant_outline = CommunityMaterialIcon("cmd_trophy_variant_outline", '\ue900')
        @JvmField
        val cmd_trophy_variant = CommunityMaterialIcon("cmd_trophy_variant", '\ue900')
        @JvmField
        val cmd_trophy = CommunityMaterialIcon("cmd_trophy", '\ue900')
        @JvmField
        val cmd_truck_check_outline = CommunityMaterialIcon("cmd_truck_check_outline", '\ue900')
        @JvmField
        val cmd_truck_check = CommunityMaterialIcon("cmd_truck_check", '\ue900')
        @JvmField
        val cmd_truck_delivery_outline = CommunityMaterialIcon("cmd_truck_delivery_outline", '\ue900')
        @JvmField
        val cmd_truck_delivery = CommunityMaterialIcon("cmd_truck_delivery", '\ue900')
        @JvmField
        val cmd_truck_fast_outline = CommunityMaterialIcon("cmd_truck_fast_outline", '\ue900')
        @JvmField
        val cmd_truck_fast = CommunityMaterialIcon("cmd_truck_fast", '\ue900')
        @JvmField
        val cmd_truck_outline = CommunityMaterialIcon("cmd_truck_outline", '\ue900')
        @JvmField
        val cmd_truck_trailer = CommunityMaterialIcon("cmd_truck_trailer", '\ue900')
        @JvmField
        val cmd_truck = CommunityMaterialIcon("cmd_truck", '\ue900')
        @JvmField
        val cmd_trumpet = CommunityMaterialIcon("cmd_trumpet", '\ue900')
        @JvmField
        val cmd_tshirt_crew_outline = CommunityMaterialIcon("cmd_tshirt_crew_outline", '\ue900')
        @JvmField
        val cmd_tshirt_crew = CommunityMaterialIcon("cmd_tshirt_crew", '\ue900')
        @JvmField
        val cmd_tshirt_v_outline = CommunityMaterialIcon("cmd_tshirt_v_outline", '\ue900')
        @JvmField
        val cmd_tshirt_v = CommunityMaterialIcon("cmd_tshirt_v", '\ue900')
        @JvmField
        val cmd_tumble_dryer_alert = CommunityMaterialIcon("cmd_tumble_dryer_alert", '\ue900')
        @JvmField
        val cmd_tumble_dryer_off = CommunityMaterialIcon("cmd_tumble_dryer_off", '\ue900')
        @JvmField
        val cmd_tumble_dryer = CommunityMaterialIcon("cmd_tumble_dryer", '\ue900')
        @JvmField
        val cmd_tumblr_box = CommunityMaterialIcon("cmd_tumblr_box", '\ue900')
        @JvmField
        val cmd_tumblr_reblog = CommunityMaterialIcon("cmd_tumblr_reblog", '\ue900')
        @JvmField
        val cmd_tumblr = CommunityMaterialIcon("cmd_tumblr", '\ue900')
        @JvmField
        val cmd_tune_vertical = CommunityMaterialIcon("cmd_tune_vertical", '\ue900')
        @JvmField
        val cmd_tune = CommunityMaterialIcon("cmd_tune", '\ue900')
        @JvmField
        val cmd_turnstile_outline = CommunityMaterialIcon("cmd_turnstile_outline", '\ue900')
        @JvmField
        val cmd_turnstile = CommunityMaterialIcon("cmd_turnstile", '\ue900')
        @JvmField
        val cmd_turtle = CommunityMaterialIcon("cmd_turtle", '\ue900')
        @JvmField
        val cmd_twitch = CommunityMaterialIcon("cmd_twitch", '\ue900')
        @JvmField
        val cmd_twitter_box = CommunityMaterialIcon("cmd_twitter_box", '\ue900')
        @JvmField
        val cmd_twitter_circle = CommunityMaterialIcon("cmd_twitter_circle", '\ue900')
        @JvmField
        val cmd_twitter_retweet = CommunityMaterialIcon("cmd_twitter_retweet", '\ue900')
        @JvmField
        val cmd_twitter = CommunityMaterialIcon("cmd_twitter", '\ue900')
        @JvmField
        val cmd_two_factor_authentication = CommunityMaterialIcon("cmd_two_factor_authentication", '\ue900')
        @JvmField
        val cmd_typewriter = CommunityMaterialIcon("cmd_typewriter", '\ue900')
        @JvmField
        val cmd_uber = CommunityMaterialIcon("cmd_uber", '\ue900')
        @JvmField
        val cmd_ubisoft = CommunityMaterialIcon("cmd_ubisoft", '\ue900')
        @JvmField
        val cmd_ubuntu = CommunityMaterialIcon("cmd_ubuntu", '\ue900')
        @JvmField
        val cmd_ufo_outline = CommunityMaterialIcon("cmd_ufo_outline", '\ue900')
        @JvmField
        val cmd_ufo = CommunityMaterialIcon("cmd_ufo", '\ue900')
        @JvmField
        val cmd_ultra_high_definition = CommunityMaterialIcon("cmd_ultra_high_definition", '\ue900')
        @JvmField
        val cmd_umbraco = CommunityMaterialIcon("cmd_umbraco", '\ue900')
        @JvmField
        val cmd_umbrella_closed = CommunityMaterialIcon("cmd_umbrella_closed", '\ue900')
        @JvmField
        val cmd_umbrella_outline = CommunityMaterialIcon("cmd_umbrella_outline", '\ue900')
        @JvmField
        val cmd_umbrella = CommunityMaterialIcon("cmd_umbrella", '\ue900')
        @JvmField
        val cmd_undo_variant = CommunityMaterialIcon("cmd_undo_variant", '\ue900')
        @JvmField
        val cmd_undo = CommunityMaterialIcon("cmd_undo", '\ue900')
        @JvmField
        val cmd_unfold_less_horizontal = CommunityMaterialIcon("cmd_unfold_less_horizontal", '\ue900')
        @JvmField
        val cmd_unfold_less_vertical = CommunityMaterialIcon("cmd_unfold_less_vertical", '\ue900')
        @JvmField
        val cmd_unfold_more_horizontal = CommunityMaterialIcon("cmd_unfold_more_horizontal", '\ue900')
        @JvmField
        val cmd_unfold_more_vertical = CommunityMaterialIcon("cmd_unfold_more_vertical", '\ue900')
        @JvmField
        val cmd_ungroup = CommunityMaterialIcon("cmd_ungroup", '\ue900')
        @JvmField
        val cmd_unicode = CommunityMaterialIcon("cmd_unicode", '\ue900')
        @JvmField
        val cmd_unity = CommunityMaterialIcon("cmd_unity", '\ue900')
        @JvmField
        val cmd_unreal = CommunityMaterialIcon("cmd_unreal", '\ue900')
        @JvmField
        val cmd_untappd = CommunityMaterialIcon("cmd_untappd", '\ue900')
        @JvmField
        val cmd_update = CommunityMaterialIcon("cmd_update", '\ue900')
        @JvmField
        val cmd_upload_multiple = CommunityMaterialIcon("cmd_upload_multiple", '\ue900')
        @JvmField
        val cmd_upload_network_outline = CommunityMaterialIcon("cmd_upload_network_outline", '\ue900')
        @JvmField
        val cmd_upload_network = CommunityMaterialIcon("cmd_upload_network", '\ue900')
        @JvmField
        val cmd_upload_off_outline = CommunityMaterialIcon("cmd_upload_off_outline", '\ue900')
        @JvmField
        val cmd_upload_off = CommunityMaterialIcon("cmd_upload_off", '\ue900')
        @JvmField
        val cmd_upload_outline = CommunityMaterialIcon("cmd_upload_outline", '\ue900')
        @JvmField
        val cmd_upload = CommunityMaterialIcon("cmd_upload", '\ue900')
        @JvmField
        val cmd_usb_flash_drive_outline = CommunityMaterialIcon("cmd_usb_flash_drive_outline", '\ue900')
        @JvmField
        val cmd_usb_flash_drive = CommunityMaterialIcon("cmd_usb_flash_drive", '\ue900')
        @JvmField
        val cmd_usb_port = CommunityMaterialIcon("cmd_usb_port", '\ue900')
        @JvmField
        val cmd_usb = CommunityMaterialIcon("cmd_usb", '\ue900')
        @JvmField
        val cmd_valve_closed = CommunityMaterialIcon("cmd_valve_closed", '\ue900')
        @JvmField
        val cmd_valve_open = CommunityMaterialIcon("cmd_valve_open", '\ue900')
        @JvmField
        val cmd_valve = CommunityMaterialIcon("cmd_valve", '\ue900')
        @JvmField
        val cmd_van_passenger = CommunityMaterialIcon("cmd_van_passenger", '\ue900')
        @JvmField
        val cmd_van_utility = CommunityMaterialIcon("cmd_van_utility", '\ue900')
        @JvmField
        val cmd_vanish = CommunityMaterialIcon("cmd_vanish", '\ue900')
        @JvmField
        val cmd_vanity_light = CommunityMaterialIcon("cmd_vanity_light", '\ue900')
        @JvmField
        val cmd_variable_box = CommunityMaterialIcon("cmd_variable_box", '\ue900')
        @JvmField
        val cmd_variable = CommunityMaterialIcon("cmd_variable", '\ue900')
        @JvmField
        val cmd_vector_arrange_above = CommunityMaterialIcon("cmd_vector_arrange_above", '\ue900')
        @JvmField
        val cmd_vector_arrange_below = CommunityMaterialIcon("cmd_vector_arrange_below", '\ue900')
        @JvmField
        val cmd_vector_bezier = CommunityMaterialIcon("cmd_vector_bezier", '\ue900')
        @JvmField
        val cmd_vector_circle_variant = CommunityMaterialIcon("cmd_vector_circle_variant", '\ue900')
        @JvmField
        val cmd_vector_circle = CommunityMaterialIcon("cmd_vector_circle", '\ue900')
        @JvmField
        val cmd_vector_combine = CommunityMaterialIcon("cmd_vector_combine", '\ue900')
        @JvmField
        val cmd_vector_curve = CommunityMaterialIcon("cmd_vector_curve", '\ue900')
        @JvmField
        val cmd_vector_difference_ab = CommunityMaterialIcon("cmd_vector_difference_ab", '\ue900')
        @JvmField
        val cmd_vector_difference_ba = CommunityMaterialIcon("cmd_vector_difference_ba", '\ue900')
        @JvmField
        val cmd_vector_difference = CommunityMaterialIcon("cmd_vector_difference", '\ue900')
        @JvmField
        val cmd_vector_ellipse = CommunityMaterialIcon("cmd_vector_ellipse", '\ue900')
        @JvmField
        val cmd_vector_intersection = CommunityMaterialIcon("cmd_vector_intersection", '\ue900')
        @JvmField
        val cmd_vector_line = CommunityMaterialIcon("cmd_vector_line", '\ue900')
        @JvmField
        val cmd_vector_link = CommunityMaterialIcon("cmd_vector_link", '\ue900')
        @JvmField
        val cmd_vector_point = CommunityMaterialIcon("cmd_vector_point", '\ue900')
        @JvmField
        val cmd_vector_polygon = CommunityMaterialIcon("cmd_vector_polygon", '\ue900')
        @JvmField
        val cmd_vector_polyline_edit = CommunityMaterialIcon("cmd_vector_polyline_edit", '\ue900')
        @JvmField
        val cmd_vector_polyline_minus = CommunityMaterialIcon("cmd_vector_polyline_minus", '\ue900')
        @JvmField
        val cmd_vector_polyline_plus = CommunityMaterialIcon("cmd_vector_polyline_plus", '\ue900')
        @JvmField
        val cmd_vector_polyline_remove = CommunityMaterialIcon("cmd_vector_polyline_remove", '\ue900')
        @JvmField
        val cmd_vector_polyline = CommunityMaterialIcon("cmd_vector_polyline", '\ue900')
        @JvmField
        val cmd_vector_radius = CommunityMaterialIcon("cmd_vector_radius", '\ue900')
        @JvmField
        val cmd_vector_rectangle = CommunityMaterialIcon("cmd_vector_rectangle", '\ue900')
        @JvmField
        val cmd_vector_selection = CommunityMaterialIcon("cmd_vector_selection", '\ue900')
        @JvmField
        val cmd_vector_square = CommunityMaterialIcon("cmd_vector_square", '\ue900')
        @JvmField
        val cmd_vector_triangle = CommunityMaterialIcon("cmd_vector_triangle", '\ue900')
        @JvmField
        val cmd_vector_union = CommunityMaterialIcon("cmd_vector_union", '\ue900')
        @JvmField
        val cmd_venmo = CommunityMaterialIcon("cmd_venmo", '\ue900')
        @JvmField
        val cmd_vhs = CommunityMaterialIcon("cmd_vhs", '\ue900')
        @JvmField
        val cmd_vibrate_off = CommunityMaterialIcon("cmd_vibrate_off", '\ue900')
        @JvmField
        val cmd_vibrate = CommunityMaterialIcon("cmd_vibrate", '\ue900')
        @JvmField
        val cmd_video_3d_variant = CommunityMaterialIcon("cmd_video_3d_variant", '\ue900')
        @JvmField
        val cmd_video_3d = CommunityMaterialIcon("cmd_video_3d", '\ue900')
        @JvmField
        val cmd_video_4k_box = CommunityMaterialIcon("cmd_video_4k_box", '\ue900')
        @JvmField
        val cmd_video_account = CommunityMaterialIcon("cmd_video_account", '\ue900')
        @JvmField
        val cmd_video_check_outline = CommunityMaterialIcon("cmd_video_check_outline", '\ue900')
        @JvmField
        val cmd_video_check = CommunityMaterialIcon("cmd_video_check", '\ue900')
        @JvmField
        val cmd_video_image = CommunityMaterialIcon("cmd_video_image", '\ue900')
        @JvmField
        val cmd_video_input_antenna = CommunityMaterialIcon("cmd_video_input_antenna", '\ue900')
        @JvmField
        val cmd_video_input_component = CommunityMaterialIcon("cmd_video_input_component", '\ue900')
        @JvmField
        val cmd_video_input_hdmi = CommunityMaterialIcon("cmd_video_input_hdmi", '\ue900')
        @JvmField
        val cmd_video_input_scart = CommunityMaterialIcon("cmd_video_input_scart", '\ue900')
        @JvmField
        val cmd_video_input_svideo = CommunityMaterialIcon("cmd_video_input_svideo", '\ue900')
        @JvmField
        val cmd_video_minus = CommunityMaterialIcon("cmd_video_minus", '\ue900')
        @JvmField
        val cmd_video_off_outline = CommunityMaterialIcon("cmd_video_off_outline", '\ue900')
        @JvmField
        val cmd_video_off = CommunityMaterialIcon("cmd_video_off", '\ue900')
        @JvmField
        val cmd_video_outline = CommunityMaterialIcon("cmd_video_outline", '\ue900')
        @JvmField
        val cmd_video_plus = CommunityMaterialIcon("cmd_video_plus", '\ue900')
        @JvmField
        val cmd_video_stabilization = CommunityMaterialIcon("cmd_video_stabilization", '\ue900')
        @JvmField
        val cmd_video_switch = CommunityMaterialIcon("cmd_video_switch", '\ue900')
        @JvmField
        val cmd_video_vintage = CommunityMaterialIcon("cmd_video_vintage", '\ue900')
        @JvmField
        val cmd_video_wireless_outline = CommunityMaterialIcon("cmd_video_wireless_outline", '\ue900')
        @JvmField
        val cmd_video_wireless = CommunityMaterialIcon("cmd_video_wireless", '\ue900')
        @JvmField
        val cmd_video = CommunityMaterialIcon("cmd_video", '\ue900')
        @JvmField
        val cmd_view_agenda_outline = CommunityMaterialIcon("cmd_view_agenda_outline", '\ue900')
        @JvmField
        val cmd_view_agenda = CommunityMaterialIcon("cmd_view_agenda", '\ue900')
        @JvmField
        val cmd_view_array = CommunityMaterialIcon("cmd_view_array", '\ue900')
        @JvmField
        val cmd_view_carousel = CommunityMaterialIcon("cmd_view_carousel", '\ue900')
        @JvmField
        val cmd_view_column = CommunityMaterialIcon("cmd_view_column", '\ue900')
        @JvmField
        val cmd_view_comfy = CommunityMaterialIcon("cmd_view_comfy", '\ue900')
        @JvmField
        val cmd_view_compact_outline = CommunityMaterialIcon("cmd_view_compact_outline", '\ue900')
        @JvmField
        val cmd_view_compact = CommunityMaterialIcon("cmd_view_compact", '\ue900')
        @JvmField
        val cmd_view_dashboard_outline = CommunityMaterialIcon("cmd_view_dashboard_outline", '\ue900')
        @JvmField
        val cmd_view_dashboard_variant = CommunityMaterialIcon("cmd_view_dashboard_variant", '\ue900')
        @JvmField
        val cmd_view_dashboard = CommunityMaterialIcon("cmd_view_dashboard", '\ue900')
        @JvmField
        val cmd_view_day = CommunityMaterialIcon("cmd_view_day", '\ue900')
        @JvmField
        val cmd_view_grid_outline = CommunityMaterialIcon("cmd_view_grid_outline", '\ue900')
        @JvmField
        val cmd_view_grid_plus_outline = CommunityMaterialIcon("cmd_view_grid_plus_outline", '\ue900')
        @JvmField
        val cmd_view_grid_plus = CommunityMaterialIcon("cmd_view_grid_plus", '\ue900')
        @JvmField
        val cmd_view_grid = CommunityMaterialIcon("cmd_view_grid", '\ue900')
        @JvmField
        val cmd_view_headline = CommunityMaterialIcon("cmd_view_headline", '\ue900')
        @JvmField
        val cmd_view_list = CommunityMaterialIcon("cmd_view_list", '\ue900')
        @JvmField
        val cmd_view_module = CommunityMaterialIcon("cmd_view_module", '\ue900')
        @JvmField
        val cmd_view_parallel = CommunityMaterialIcon("cmd_view_parallel", '\ue900')
        @JvmField
        val cmd_view_quilt = CommunityMaterialIcon("cmd_view_quilt", '\ue900')
        @JvmField
        val cmd_view_sequential = CommunityMaterialIcon("cmd_view_sequential", '\ue900')
        @JvmField
        val cmd_view_split_horizontal = CommunityMaterialIcon("cmd_view_split_horizontal", '\ue900')
        @JvmField
        val cmd_view_split_vertical = CommunityMaterialIcon("cmd_view_split_vertical", '\ue900')
        @JvmField
        val cmd_view_stream = CommunityMaterialIcon("cmd_view_stream", '\ue900')
        @JvmField
        val cmd_view_week = CommunityMaterialIcon("cmd_view_week", '\ue900')
        @JvmField
        val cmd_vimeo = CommunityMaterialIcon("cmd_vimeo", '\ue900')
        @JvmField
        val cmd_violin = CommunityMaterialIcon("cmd_violin", '\ue900')
        @JvmField
        val cmd_virtual_reality = CommunityMaterialIcon("cmd_virtual_reality", '\ue900')
        @JvmField
        val cmd_visual_studio_code = CommunityMaterialIcon("cmd_visual_studio_code", '\ue900')
        @JvmField
        val cmd_visual_studio = CommunityMaterialIcon("cmd_visual_studio", '\ue900')
        @JvmField
        val cmd_vk_box = CommunityMaterialIcon("cmd_vk_box", '\ue900')
        @JvmField
        val cmd_vk_circle = CommunityMaterialIcon("cmd_vk_circle", '\ue900')
        @JvmField
        val cmd_vk = CommunityMaterialIcon("cmd_vk", '\ue900')
        @JvmField
        val cmd_vlc = CommunityMaterialIcon("cmd_vlc", '\ue900')
        @JvmField
        val cmd_voice_off = CommunityMaterialIcon("cmd_voice_off", '\ue900')
        @JvmField
        val cmd_voice = CommunityMaterialIcon("cmd_voice", '\ue900')
        @JvmField
        val cmd_voicemail = CommunityMaterialIcon("cmd_voicemail", '\ue900')
        @JvmField
        val cmd_volleyball = CommunityMaterialIcon("cmd_volleyball", '\ue900')
        @JvmField
        val cmd_volume_high = CommunityMaterialIcon("cmd_volume_high", '\ue900')
        @JvmField
        val cmd_volume_low = CommunityMaterialIcon("cmd_volume_low", '\ue900')
        @JvmField
        val cmd_volume_medium = CommunityMaterialIcon("cmd_volume_medium", '\ue900')
        @JvmField
        val cmd_volume_minus = CommunityMaterialIcon("cmd_volume_minus", '\ue900')
        @JvmField
        val cmd_volume_mute = CommunityMaterialIcon("cmd_volume_mute", '\ue900')
        @JvmField
        val cmd_volume_off = CommunityMaterialIcon("cmd_volume_off", '\ue900')
        @JvmField
        val cmd_volume_plus = CommunityMaterialIcon("cmd_volume_plus", '\ue900')
        @JvmField
        val cmd_volume_source = CommunityMaterialIcon("cmd_volume_source", '\ue900')
        @JvmField
        val cmd_volume_variant_off = CommunityMaterialIcon("cmd_volume_variant_off", '\ue900')
        @JvmField
        val cmd_volume_vibrate = CommunityMaterialIcon("cmd_volume_vibrate", '\ue900')
        @JvmField
        val cmd_vote_outline = CommunityMaterialIcon("cmd_vote_outline", '\ue900')
        @JvmField
        val cmd_vote = CommunityMaterialIcon("cmd_vote", '\ue900')
        @JvmField
        val cmd_vpn = CommunityMaterialIcon("cmd_vpn", '\ue900')
        @JvmField
        val cmd_vuejs = CommunityMaterialIcon("cmd_vuejs", '\ue900')
        @JvmField
        val cmd_vuetify = CommunityMaterialIcon("cmd_vuetify", '\ue900')
        @JvmField
        val cmd_walk = CommunityMaterialIcon("cmd_walk", '\ue900')
        @JvmField
        val cmd_wall_sconce_flat = CommunityMaterialIcon("cmd_wall_sconce_flat", '\ue900')
        @JvmField
        val cmd_wall_sconce_variant = CommunityMaterialIcon("cmd_wall_sconce_variant", '\ue900')
        @JvmField
        val cmd_wall_sconce = CommunityMaterialIcon("cmd_wall_sconce", '\ue900')
        @JvmField
        val cmd_wall = CommunityMaterialIcon("cmd_wall", '\ue900')
        @JvmField
        val cmd_wallet_giftcard = CommunityMaterialIcon("cmd_wallet_giftcard", '\ue900')
        @JvmField
        val cmd_wallet_membership = CommunityMaterialIcon("cmd_wallet_membership", '\ue900')
        @JvmField
        val cmd_wallet_outline = CommunityMaterialIcon("cmd_wallet_outline", '\ue900')
        @JvmField
        val cmd_wallet_plus_outline = CommunityMaterialIcon("cmd_wallet_plus_outline", '\ue900')
        @JvmField
        val cmd_wallet_plus = CommunityMaterialIcon("cmd_wallet_plus", '\ue900')
        @JvmField
        val cmd_wallet_travel = CommunityMaterialIcon("cmd_wallet_travel", '\ue900')
        @JvmField
        val cmd_wallet = CommunityMaterialIcon("cmd_wallet", '\ue900')
        @JvmField
        val cmd_wallpaper = CommunityMaterialIcon("cmd_wallpaper", '\ue900')
        @JvmField
        val cmd_wan = CommunityMaterialIcon("cmd_wan", '\ue900')
        @JvmField
        val cmd_wardrobe_outline = CommunityMaterialIcon("cmd_wardrobe_outline", '\ue900')
        @JvmField
        val cmd_wardrobe = CommunityMaterialIcon("cmd_wardrobe", '\ue900')
        @JvmField
        val cmd_warehouse = CommunityMaterialIcon("cmd_warehouse", '\ue900')
        @JvmField
        val cmd_washing_machine_alert = CommunityMaterialIcon("cmd_washing_machine_alert", '\ue900')
        @JvmField
        val cmd_washing_machine_off = CommunityMaterialIcon("cmd_washing_machine_off", '\ue900')
        @JvmField
        val cmd_washing_machine = CommunityMaterialIcon("cmd_washing_machine", '\ue900')
        @JvmField
        val cmd_watch_export_variant = CommunityMaterialIcon("cmd_watch_export_variant", '\ue900')
        @JvmField
        val cmd_watch_export = CommunityMaterialIcon("cmd_watch_export", '\ue900')
        @JvmField
        val cmd_watch_import_variant = CommunityMaterialIcon("cmd_watch_import_variant", '\ue900')
        @JvmField
        val cmd_watch_import = CommunityMaterialIcon("cmd_watch_import", '\ue900')
        @JvmField
        val cmd_watch_variant = CommunityMaterialIcon("cmd_watch_variant", '\ue900')
        @JvmField
        val cmd_watch_vibrate_off = CommunityMaterialIcon("cmd_watch_vibrate_off", '\ue900')
        @JvmField
        val cmd_watch_vibrate = CommunityMaterialIcon("cmd_watch_vibrate", '\ue900')
        @JvmField
        val cmd_watch = CommunityMaterialIcon("cmd_watch", '\ue900')
        @JvmField
        val cmd_water_boiler_alert = CommunityMaterialIcon("cmd_water_boiler_alert", '\ue900')
        @JvmField
        val cmd_water_boiler_off = CommunityMaterialIcon("cmd_water_boiler_off", '\ue900')
        @JvmField
        val cmd_water_boiler = CommunityMaterialIcon("cmd_water_boiler", '\ue900')
        @JvmField
        val cmd_water_off = CommunityMaterialIcon("cmd_water_off", '\ue900')
        @JvmField
        val cmd_water_outline = CommunityMaterialIcon("cmd_water_outline", '\ue900')
        @JvmField
        val cmd_water_percent = CommunityMaterialIcon("cmd_water_percent", '\ue900')
        @JvmField
        val cmd_water_polo = CommunityMaterialIcon("cmd_water_polo", '\ue900')
        @JvmField
        val cmd_water_pump_off = CommunityMaterialIcon("cmd_water_pump_off", '\ue900')
        @JvmField
        val cmd_water_pump = CommunityMaterialIcon("cmd_water_pump", '\ue900')
        @JvmField
        val cmd_water_well_outline = CommunityMaterialIcon("cmd_water_well_outline", '\ue900')
        @JvmField
        val cmd_water_well = CommunityMaterialIcon("cmd_water_well", '\ue900')
        @JvmField
        val cmd_water = CommunityMaterialIcon("cmd_water", '\ue900')
        @JvmField
        val cmd_watermark = CommunityMaterialIcon("cmd_watermark", '\ue900')
        @JvmField
        val cmd_wave = CommunityMaterialIcon("cmd_wave", '\ue900')
        @JvmField
        val cmd_waves = CommunityMaterialIcon("cmd_waves", '\ue900')
        @JvmField
        val cmd_waze = CommunityMaterialIcon("cmd_waze", '\ue900')
        @JvmField
        val cmd_weather_cloudy_alert = CommunityMaterialIcon("cmd_weather_cloudy_alert", '\ue900')
        @JvmField
        val cmd_weather_cloudy_arrow_right = CommunityMaterialIcon("cmd_weather_cloudy_arrow_right", '\ue900')
        @JvmField
        val cmd_weather_cloudy = CommunityMaterialIcon("cmd_weather_cloudy", '\ue900')
        @JvmField
        val cmd_weather_fog = CommunityMaterialIcon("cmd_weather_fog", '\ue900')
        @JvmField
        val cmd_weather_hail = CommunityMaterialIcon("cmd_weather_hail", '\ue900')
        @JvmField
        val cmd_weather_hazy = CommunityMaterialIcon("cmd_weather_hazy", '\ue900')
        @JvmField
        val cmd_weather_hurricane = CommunityMaterialIcon("cmd_weather_hurricane", '\ue900')
        @JvmField
        val cmd_weather_lightning_rainy = CommunityMaterialIcon("cmd_weather_lightning_rainy", '\ue900')
        @JvmField
        val cmd_weather_lightning = CommunityMaterialIcon("cmd_weather_lightning", '\ue900')
        @JvmField
        val cmd_weather_night_partly_cloudy = CommunityMaterialIcon("cmd_weather_night_partly_cloudy", '\ue900')
        @JvmField
        val cmd_weather_night = CommunityMaterialIcon("cmd_weather_night", '\ue900')
        @JvmField
        val cmd_weather_partly_cloudy = CommunityMaterialIcon("cmd_weather_partly_cloudy", '\ue900')
        @JvmField
        val cmd_weather_partly_lightning = CommunityMaterialIcon("cmd_weather_partly_lightning", '\ue900')
        @JvmField
        val cmd_weather_partly_rainy = CommunityMaterialIcon("cmd_weather_partly_rainy", '\ue900')
        @JvmField
        val cmd_weather_partly_snowy_rainy = CommunityMaterialIcon("cmd_weather_partly_snowy_rainy", '\ue900')
        @JvmField
        val cmd_weather_partly_snowy = CommunityMaterialIcon("cmd_weather_partly_snowy", '\ue900')
        @JvmField
        val cmd_weather_pouring = CommunityMaterialIcon("cmd_weather_pouring", '\ue900')
        @JvmField
        val cmd_weather_rainy = CommunityMaterialIcon("cmd_weather_rainy", '\ue900')
        @JvmField
        val cmd_weather_snowy_heavy = CommunityMaterialIcon("cmd_weather_snowy_heavy", '\ue900')
        @JvmField
        val cmd_weather_snowy_rainy = CommunityMaterialIcon("cmd_weather_snowy_rainy", '\ue900')
        @JvmField
        val cmd_weather_snowy = CommunityMaterialIcon("cmd_weather_snowy", '\ue900')
        @JvmField
        val cmd_weather_sunny_alert = CommunityMaterialIcon("cmd_weather_sunny_alert", '\ue900')
        @JvmField
        val cmd_weather_sunny = CommunityMaterialIcon("cmd_weather_sunny", '\ue900')
        @JvmField
        val cmd_weather_sunset_down = CommunityMaterialIcon("cmd_weather_sunset_down", '\ue900')
        @JvmField
        val cmd_weather_sunset_up = CommunityMaterialIcon("cmd_weather_sunset_up", '\ue900')
        @JvmField
        val cmd_weather_sunset = CommunityMaterialIcon("cmd_weather_sunset", '\ue900')
        @JvmField
        val cmd_weather_tornado = CommunityMaterialIcon("cmd_weather_tornado", '\ue900')
        @JvmField
        val cmd_weather_windy_variant = CommunityMaterialIcon("cmd_weather_windy_variant", '\ue900')
        @JvmField
        val cmd_weather_windy = CommunityMaterialIcon("cmd_weather_windy", '\ue900')
        @JvmField
        val cmd_web_box = CommunityMaterialIcon("cmd_web_box", '\ue900')
        @JvmField
        val cmd_web_clock = CommunityMaterialIcon("cmd_web_clock", '\ue900')
        @JvmField
        val cmd_web = CommunityMaterialIcon("cmd_web", '\ue900')
        @JvmField
        val cmd_webcam = CommunityMaterialIcon("cmd_webcam", '\ue900')
        @JvmField
        val cmd_webhook = CommunityMaterialIcon("cmd_webhook", '\ue900')
        @JvmField
        val cmd_webpack = CommunityMaterialIcon("cmd_webpack", '\ue900')
        @JvmField
        val cmd_webrtc = CommunityMaterialIcon("cmd_webrtc", '\ue900')
        @JvmField
        val cmd_wechat = CommunityMaterialIcon("cmd_wechat", '\ue900')
        @JvmField
        val cmd_weight_gram = CommunityMaterialIcon("cmd_weight_gram", '\ue900')
        @JvmField
        val cmd_weight_kilogram = CommunityMaterialIcon("cmd_weight_kilogram", '\ue900')
        @JvmField
        val cmd_weight_lifter = CommunityMaterialIcon("cmd_weight_lifter", '\ue900')
        @JvmField
        val cmd_weight_pound = CommunityMaterialIcon("cmd_weight_pound", '\ue900')
        @JvmField
        val cmd_weight = CommunityMaterialIcon("cmd_weight", '\ue900')
        @JvmField
        val cmd_whatsapp = CommunityMaterialIcon("cmd_whatsapp", '\ue900')
        @JvmField
        val cmd_wheelchair_accessibility = CommunityMaterialIcon("cmd_wheelchair_accessibility", '\ue900')
        @JvmField
        val cmd_whistle_outline = CommunityMaterialIcon("cmd_whistle_outline", '\ue900')
        @JvmField
        val cmd_whistle = CommunityMaterialIcon("cmd_whistle", '\ue900')
        @JvmField
        val cmd_white_balance_auto = CommunityMaterialIcon("cmd_white_balance_auto", '\ue900')
        @JvmField
        val cmd_white_balance_incandescent = CommunityMaterialIcon("cmd_white_balance_incandescent", '\ue900')
        @JvmField
        val cmd_white_balance_iridescent = CommunityMaterialIcon("cmd_white_balance_iridescent", '\ue900')
        @JvmField
        val cmd_white_balance_sunny = CommunityMaterialIcon("cmd_white_balance_sunny", '\ue900')
        @JvmField
        val cmd_widgets = CommunityMaterialIcon("cmd_widgets", '\ue900')
        @JvmField
        val cmd_wifi_off = CommunityMaterialIcon("cmd_wifi_off", '\ue900')
        @JvmField
        val cmd_wifi_star = CommunityMaterialIcon("cmd_wifi_star", '\ue900')
        @JvmField
        val cmd_wifi_strength_1_alert = CommunityMaterialIcon("cmd_wifi_strength_1_alert", '\ue900')
        @JvmField
        val cmd_wifi_strength_1_lock = CommunityMaterialIcon("cmd_wifi_strength_1_lock", '\ue900')
        @JvmField
        val cmd_wifi_strength_1 = CommunityMaterialIcon("cmd_wifi_strength_1", '\ue900')
        @JvmField
        val cmd_wifi_strength_2_alert = CommunityMaterialIcon("cmd_wifi_strength_2_alert", '\ue900')
        @JvmField
        val cmd_wifi_strength_2_lock = CommunityMaterialIcon("cmd_wifi_strength_2_lock", '\ue900')
        @JvmField
        val cmd_wifi_strength_2 = CommunityMaterialIcon("cmd_wifi_strength_2", '\ue900')
        @JvmField
        val cmd_wifi_strength_3_alert = CommunityMaterialIcon("cmd_wifi_strength_3_alert", '\ue900')
        @JvmField
        val cmd_wifi_strength_3_lock = CommunityMaterialIcon("cmd_wifi_strength_3_lock", '\ue900')
        @JvmField
        val cmd_wifi_strength_3 = CommunityMaterialIcon("cmd_wifi_strength_3", '\ue900')
        @JvmField
        val cmd_wifi_strength_4_alert = CommunityMaterialIcon("cmd_wifi_strength_4_alert", '\ue900')
        @JvmField
        val cmd_wifi_strength_4_lock = CommunityMaterialIcon("cmd_wifi_strength_4_lock", '\ue900')
        @JvmField
        val cmd_wifi_strength_4 = CommunityMaterialIcon("cmd_wifi_strength_4", '\ue900')
        @JvmField
        val cmd_wifi_strength_alert_outline = CommunityMaterialIcon("cmd_wifi_strength_alert_outline", '\ue900')
        @JvmField
        val cmd_wifi_strength_lock_outline = CommunityMaterialIcon("cmd_wifi_strength_lock_outline", '\ue900')
        @JvmField
        val cmd_wifi_strength_off_outline = CommunityMaterialIcon("cmd_wifi_strength_off_outline", '\ue900')
        @JvmField
        val cmd_wifi_strength_off = CommunityMaterialIcon("cmd_wifi_strength_off", '\ue900')
        @JvmField
        val cmd_wifi_strength_outline = CommunityMaterialIcon("cmd_wifi_strength_outline", '\ue900')
        @JvmField
        val cmd_wifi = CommunityMaterialIcon("cmd_wifi", '\ue900')
        @JvmField
        val cmd_wii = CommunityMaterialIcon("cmd_wii", '\ue900')
        @JvmField
        val cmd_wiiu = CommunityMaterialIcon("cmd_wiiu", '\ue900')
        @JvmField
        val cmd_wikipedia = CommunityMaterialIcon("cmd_wikipedia", '\ue900')
        @JvmField
        val cmd_wind_turbine = CommunityMaterialIcon("cmd_wind_turbine", '\ue900')
        @JvmField
        val cmd_window_close = CommunityMaterialIcon("cmd_window_close", '\ue900')
        @JvmField
        val cmd_window_closed_variant = CommunityMaterialIcon("cmd_window_closed_variant", '\ue900')
        @JvmField
        val cmd_window_closed = CommunityMaterialIcon("cmd_window_closed", '\ue900')
        @JvmField
        val cmd_window_maximize = CommunityMaterialIcon("cmd_window_maximize", '\ue900')
        @JvmField
        val cmd_window_minimize = CommunityMaterialIcon("cmd_window_minimize", '\ue900')
        @JvmField
        val cmd_window_open_variant = CommunityMaterialIcon("cmd_window_open_variant", '\ue900')
        @JvmField
        val cmd_window_open = CommunityMaterialIcon("cmd_window_open", '\ue900')
        @JvmField
        val cmd_window_restore = CommunityMaterialIcon("cmd_window_restore", '\ue900')
        @JvmField
        val cmd_window_shutter_alert = CommunityMaterialIcon("cmd_window_shutter_alert", '\ue900')
        @JvmField
        val cmd_window_shutter_open = CommunityMaterialIcon("cmd_window_shutter_open", '\ue900')
        @JvmField
        val cmd_window_shutter = CommunityMaterialIcon("cmd_window_shutter", '\ue900')
        @JvmField
        val cmd_windows_classic = CommunityMaterialIcon("cmd_windows_classic", '\ue900')
        @JvmField
        val cmd_windows = CommunityMaterialIcon("cmd_windows", '\ue900')
        @JvmField
        val cmd_wiper_wash = CommunityMaterialIcon("cmd_wiper_wash", '\ue900')
        @JvmField
        val cmd_wiper = CommunityMaterialIcon("cmd_wiper", '\ue900')
        @JvmField
        val cmd_wordpress = CommunityMaterialIcon("cmd_wordpress", '\ue900')
        @JvmField
        val cmd_worker = CommunityMaterialIcon("cmd_worker", '\ue900')
        @JvmField
        val cmd_wrap_disabled = CommunityMaterialIcon("cmd_wrap_disabled", '\ue900')
        @JvmField
        val cmd_wrap = CommunityMaterialIcon("cmd_wrap", '\ue900')
        @JvmField
        val cmd_wrench_outline = CommunityMaterialIcon("cmd_wrench_outline", '\ue900')
        @JvmField
        val cmd_wrench = CommunityMaterialIcon("cmd_wrench", '\ue900')
        @JvmField
        val cmd_wunderlist = CommunityMaterialIcon("cmd_wunderlist", '\ue900')
        @JvmField
        val cmd_xamarin_outline = CommunityMaterialIcon("cmd_xamarin_outline", '\ue900')
        @JvmField
        val cmd_xamarin = CommunityMaterialIcon("cmd_xamarin", '\ue900')
        @JvmField
        val cmd_xaml = CommunityMaterialIcon("cmd_xaml", '\ue900')
        @JvmField
        val cmd_xbox_controller_battery_alert = CommunityMaterialIcon("cmd_xbox_controller_battery_alert", '\ue900')
        @JvmField
        val cmd_xbox_controller_battery_charging = CommunityMaterialIcon("cmd_xbox_controller_battery_charging", '\ue900')
        @JvmField
        val cmd_xbox_controller_battery_empty = CommunityMaterialIcon("cmd_xbox_controller_battery_empty", '\ue900')
        @JvmField
        val cmd_xbox_controller_battery_full = CommunityMaterialIcon("cmd_xbox_controller_battery_full", '\ue900')
        @JvmField
        val cmd_xbox_controller_battery_low = CommunityMaterialIcon("cmd_xbox_controller_battery_low", '\ue900')
        @JvmField
        val cmd_xbox_controller_battery_medium = CommunityMaterialIcon("cmd_xbox_controller_battery_medium", '\ue900')
        @JvmField
        val cmd_xbox_controller_battery_unknown = CommunityMaterialIcon("cmd_xbox_controller_battery_unknown", '\ue900')
        @JvmField
        val cmd_xbox_controller_menu = CommunityMaterialIcon("cmd_xbox_controller_menu", '\ue900')
        @JvmField
        val cmd_xbox_controller_off = CommunityMaterialIcon("cmd_xbox_controller_off", '\ue900')
        @JvmField
        val cmd_xbox_controller_view = CommunityMaterialIcon("cmd_xbox_controller_view", '\ue900')
        @JvmField
        val cmd_xbox_controller = CommunityMaterialIcon("cmd_xbox_controller", '\ue900')
        @JvmField
        val cmd_xbox = CommunityMaterialIcon("cmd_xbox", '\ue900')
        @JvmField
        val cmd_xda = CommunityMaterialIcon("cmd_xda", '\ue900')
        @JvmField
        val cmd_xing_box = CommunityMaterialIcon("cmd_xing_box", '\ue900')
        @JvmField
        val cmd_xing_circle = CommunityMaterialIcon("cmd_xing_circle", '\ue900')
        @JvmField
        val cmd_xing = CommunityMaterialIcon("cmd_xing", '\ue900')
        @JvmField
        val cmd_xml = CommunityMaterialIcon("cmd_xml", '\ue900')
        @JvmField
        val cmd_xmpp = CommunityMaterialIcon("cmd_xmpp", '\ue900')
        @JvmField
        val cmd_yahoo = CommunityMaterialIcon("cmd_yahoo", '\ue900')
        @JvmField
        val cmd_yammer = CommunityMaterialIcon("cmd_yammer", '\ue900')
        @JvmField
        val cmd_yeast = CommunityMaterialIcon("cmd_yeast", '\ue900')
        @JvmField
        val cmd_yelp = CommunityMaterialIcon("cmd_yelp", '\ue900')
        @JvmField
        val cmd_yin_yang = CommunityMaterialIcon("cmd_yin_yang", '\ue900')
        @JvmField
        val cmd_yoga = CommunityMaterialIcon("cmd_yoga", '\ue900')
        @JvmField
        val cmd_youtube_creator_studio = CommunityMaterialIcon("cmd_youtube_creator_studio", '\ue900')
        @JvmField
        val cmd_youtube_gaming = CommunityMaterialIcon("cmd_youtube_gaming", '\ue900')
        @JvmField
        val cmd_youtube_subscription = CommunityMaterialIcon("cmd_youtube_subscription", '\ue900')
        @JvmField
        val cmd_youtube_tv = CommunityMaterialIcon("cmd_youtube_tv", '\ue900')
        @JvmField
        val cmd_youtube = CommunityMaterialIcon("cmd_youtube", '\ue900')
        @JvmField
        val cmd_z_wave = CommunityMaterialIcon("cmd_z_wave", '\ue900')
        @JvmField
        val cmd_zend = CommunityMaterialIcon("cmd_zend", '\ue900')
        @JvmField
        val cmd_zigbee = CommunityMaterialIcon("cmd_zigbee", '\ue900')
        @JvmField
        val cmd_zip_box_outline = CommunityMaterialIcon("cmd_zip_box_outline", '\ue900')
        @JvmField
        val cmd_zip_box = CommunityMaterialIcon("cmd_zip_box", '\ue900')
        @JvmField
        val cmd_zip_disk = CommunityMaterialIcon("cmd_zip_disk", '\ue900')
        @JvmField
        val cmd_zodiac_aquarius = CommunityMaterialIcon("cmd_zodiac_aquarius", '\ue900')
        @JvmField
        val cmd_zodiac_aries = CommunityMaterialIcon("cmd_zodiac_aries", '\ue900')
        @JvmField
        val cmd_zodiac_cancer = CommunityMaterialIcon("cmd_zodiac_cancer", '\ue900')
        @JvmField
        val cmd_zodiac_capricorn = CommunityMaterialIcon("cmd_zodiac_capricorn", '\ue900')
        @JvmField
        val cmd_zodiac_gemini = CommunityMaterialIcon("cmd_zodiac_gemini", '\ue900')
        @JvmField
        val cmd_zodiac_leo = CommunityMaterialIcon("cmd_zodiac_leo", '\ue900')
        @JvmField
        val cmd_zodiac_libra = CommunityMaterialIcon("cmd_zodiac_libra", '\ue900')
        @JvmField
        val cmd_zodiac_pisces = CommunityMaterialIcon("cmd_zodiac_pisces", '\ue900')
        @JvmField
        val cmd_zodiac_sagittarius = CommunityMaterialIcon("cmd_zodiac_sagittarius", '\ue900')
        @JvmField
        val cmd_zodiac_scorpio = CommunityMaterialIcon("cmd_zodiac_scorpio", '\ue900')
        @JvmField
        val cmd_zodiac_taurus = CommunityMaterialIcon("cmd_zodiac_taurus", '\ue900')
        @JvmField
        val cmd_zodiac_virgo = CommunityMaterialIcon("cmd_zodiac_virgo", '\ue900')
        @JvmField
        val cmd_hair_dryer_outline = CommunityMaterialIcon("cmd_hair_dryer_outline", '\ue900')
        @JvmField
        val cmd_hair_dryer = CommunityMaterialIcon("cmd_hair_dryer", '\ue900')
        @JvmField
        val cmd_halloween = CommunityMaterialIcon("cmd_halloween", '\ue900')
        @JvmField
        val cmd_hamburger = CommunityMaterialIcon("cmd_hamburger", '\ue900')
        @JvmField
        val cmd_hammer = CommunityMaterialIcon("cmd_hammer", '\ue900')
        @JvmField
        val cmd_hand_heart = CommunityMaterialIcon("cmd_hand_heart", '\ue900')
        @JvmField
        val cmd_hand_left = CommunityMaterialIcon("cmd_hand_left", '\ue900')
        @JvmField
        val cmd_hand_okay = CommunityMaterialIcon("cmd_hand_okay", '\ue900')
        @JvmField
        val cmd_hand_peace_variant = CommunityMaterialIcon("cmd_hand_peace_variant", '\ue900')
        @JvmField
        val cmd_hand_peace = CommunityMaterialIcon("cmd_hand_peace", '\ue900')
        @JvmField
        val cmd_hand_pointing_down = CommunityMaterialIcon("cmd_hand_pointing_down", '\ue900')
        @JvmField
        val cmd_hand_pointing_left = CommunityMaterialIcon("cmd_hand_pointing_left", '\ue900')
        @JvmField
        val cmd_hand_pointing_right = CommunityMaterialIcon("cmd_hand_pointing_right", '\ue900')
        @JvmField
        val cmd_hand_pointing_up = CommunityMaterialIcon("cmd_hand_pointing_up", '\ue900')
        @JvmField
        val cmd_hand_right = CommunityMaterialIcon("cmd_hand_right", '\ue900')
        @JvmField
        val cmd_hand_saw = CommunityMaterialIcon("cmd_hand_saw", '\ue900')
        @JvmField
        val cmd_hand = CommunityMaterialIcon("cmd_hand", '\ue900')
        @JvmField
        val cmd_handball = CommunityMaterialIcon("cmd_handball", '\ue900')
        @JvmField
        val cmd_handcuffs = CommunityMaterialIcon("cmd_handcuffs", '\ue900')
        @JvmField
        val cmd_handshake = CommunityMaterialIcon("cmd_handshake", '\ue900')
        @JvmField
        val cmd_hanger = CommunityMaterialIcon("cmd_hanger", '\ue900')
        @JvmField
        val cmd_hard_hat = CommunityMaterialIcon("cmd_hard_hat", '\ue900')
        @JvmField
        val cmd_harddisk_plus = CommunityMaterialIcon("cmd_harddisk_plus", '\ue900')
        @JvmField
        val cmd_harddisk_remove = CommunityMaterialIcon("cmd_harddisk_remove", '\ue900')
        @JvmField
        val cmd_harddisk = CommunityMaterialIcon("cmd_harddisk", '\ue900')
        @JvmField
        val cmd_hat_fedora = CommunityMaterialIcon("cmd_hat_fedora", '\ue900')
        @JvmField
        val cmd_hazard_lights = CommunityMaterialIcon("cmd_hazard_lights", '\ue900')
        @JvmField
        val cmd_hdr_off = CommunityMaterialIcon("cmd_hdr_off", '\ue900')
        @JvmField
        val cmd_hdr = CommunityMaterialIcon("cmd_hdr", '\ue900')
        @JvmField
        val cmd_headphones_bluetooth = CommunityMaterialIcon("cmd_headphones_bluetooth", '\ue900')
        @JvmField
        val cmd_headphones_box = CommunityMaterialIcon("cmd_headphones_box", '\ue900')
        @JvmField
        val cmd_headphones_off = CommunityMaterialIcon("cmd_headphones_off", '\ue900')
        @JvmField
        val cmd_headphones_settings = CommunityMaterialIcon("cmd_headphones_settings", '\ue900')
        @JvmField
        val cmd_headphones = CommunityMaterialIcon("cmd_headphones", '\ue900')
        @JvmField
        val cmd_headset_dock = CommunityMaterialIcon("cmd_headset_dock", '\ue900')
        @JvmField
        val cmd_headset_off = CommunityMaterialIcon("cmd_headset_off", '\ue900')
        @JvmField
        val cmd_headset = CommunityMaterialIcon("cmd_headset", '\ue900')
        @JvmField
        val cmd_heart_box_outline = CommunityMaterialIcon("cmd_heart_box_outline", '\ue900')
        @JvmField
        val cmd_heart_box = CommunityMaterialIcon("cmd_heart_box", '\ue900')
        @JvmField
        val cmd_heart_broken_outline = CommunityMaterialIcon("cmd_heart_broken_outline", '\ue900')
        @JvmField
        val cmd_heart_broken = CommunityMaterialIcon("cmd_heart_broken", '\ue900')
        @JvmField
        val cmd_heart_circle_outline = CommunityMaterialIcon("cmd_heart_circle_outline", '\ue900')
        @JvmField
        val cmd_heart_circle = CommunityMaterialIcon("cmd_heart_circle", '\ue900')
        @JvmField
        val cmd_heart_flash = CommunityMaterialIcon("cmd_heart_flash", '\ue900')
        @JvmField
        val cmd_heart_half_full = CommunityMaterialIcon("cmd_heart_half_full", '\ue900')
        @JvmField
        val cmd_heart_half_outline = CommunityMaterialIcon("cmd_heart_half_outline", '\ue900')
        @JvmField
        val cmd_heart_half = CommunityMaterialIcon("cmd_heart_half", '\ue900')
        @JvmField
        val cmd_heart_multiple_outline = CommunityMaterialIcon("cmd_heart_multiple_outline", '\ue900')
        @JvmField
        val cmd_heart_multiple = CommunityMaterialIcon("cmd_heart_multiple", '\ue900')
        @JvmField
        val cmd_heart_off = CommunityMaterialIcon("cmd_heart_off", '\ue900')
        @JvmField
        val cmd_heart_outline = CommunityMaterialIcon("cmd_heart_outline", '\ue900')
        @JvmField
        val cmd_heart_pulse = CommunityMaterialIcon("cmd_heart_pulse", '\ue900')
        @JvmField
        val cmd_heart = CommunityMaterialIcon("cmd_heart", '\ue900')
        @JvmField
        val cmd_helicopter = CommunityMaterialIcon("cmd_helicopter", '\ue900')
        @JvmField
        val cmd_help_box = CommunityMaterialIcon("cmd_help_box", '\ue900')
        @JvmField
        val cmd_help_circle_outline = CommunityMaterialIcon("cmd_help_circle_outline", '\ue900')
        @JvmField
        val cmd_help_circle = CommunityMaterialIcon("cmd_help_circle", '\ue900')
        @JvmField
        val cmd_help_network_outline = CommunityMaterialIcon("cmd_help_network_outline", '\ue900')
        @JvmField
        val cmd_help_network = CommunityMaterialIcon("cmd_help_network", '\ue900')
        @JvmField
        val cmd_help_rhombus_outline = CommunityMaterialIcon("cmd_help_rhombus_outline", '\ue900')
        @JvmField
        val cmd_help_rhombus = CommunityMaterialIcon("cmd_help_rhombus", '\ue900')
        @JvmField
        val cmd_help = CommunityMaterialIcon("cmd_help", '\ue900')
        @JvmField
        val cmd_hexadecimal = CommunityMaterialIcon("cmd_hexadecimal", '\ue900')
        @JvmField
        val cmd_hexagon_multiple_outline = CommunityMaterialIcon("cmd_hexagon_multiple_outline", '\ue900')
        @JvmField
        val cmd_hexagon_multiple = CommunityMaterialIcon("cmd_hexagon_multiple", '\ue900')
        @JvmField
        val cmd_hexagon_outline = CommunityMaterialIcon("cmd_hexagon_outline", '\ue900')
        @JvmField
        val cmd_hexagon_slice_1 = CommunityMaterialIcon("cmd_hexagon_slice_1", '\ue900')
        @JvmField
        val cmd_hexagon_slice_2 = CommunityMaterialIcon("cmd_hexagon_slice_2", '\ue900')
        @JvmField
        val cmd_hexagon_slice_3 = CommunityMaterialIcon("cmd_hexagon_slice_3", '\ue900')
        @JvmField
        val cmd_hexagon_slice_4 = CommunityMaterialIcon("cmd_hexagon_slice_4", '\ue900')
        @JvmField
        val cmd_hexagon_slice_5 = CommunityMaterialIcon("cmd_hexagon_slice_5", '\ue900')
        @JvmField
        val cmd_hexagon_slice_6 = CommunityMaterialIcon("cmd_hexagon_slice_6", '\ue900')
        @JvmField
        val cmd_hexagon = CommunityMaterialIcon("cmd_hexagon", '\ue900')
        @JvmField
        val cmd_hexagram_outline = CommunityMaterialIcon("cmd_hexagram_outline", '\ue900')
        @JvmField
        val cmd_hexagram = CommunityMaterialIcon("cmd_hexagram", '\ue900')
        @JvmField
        val cmd_high_definition_box = CommunityMaterialIcon("cmd_high_definition_box", '\ue900')
        @JvmField
        val cmd_high_definition = CommunityMaterialIcon("cmd_high_definition", '\ue900')
        @JvmField
        val cmd_highway = CommunityMaterialIcon("cmd_highway", '\ue900')
        @JvmField
        val cmd_hiking = CommunityMaterialIcon("cmd_hiking", '\ue900')
        @JvmField
        val cmd_hinduism = CommunityMaterialIcon("cmd_hinduism", '\ue900')
        @JvmField
        val cmd_history = CommunityMaterialIcon("cmd_history", '\ue900')
        @JvmField
        val cmd_hockey_puck = CommunityMaterialIcon("cmd_hockey_puck", '\ue900')
        @JvmField
        val cmd_hockey_sticks = CommunityMaterialIcon("cmd_hockey_sticks", '\ue900')
        @JvmField
        val cmd_hololens = CommunityMaterialIcon("cmd_hololens", '\ue900')
        @JvmField
        val cmd_home_account = CommunityMaterialIcon("cmd_home_account", '\ue900')
        @JvmField
        val cmd_home_alert = CommunityMaterialIcon("cmd_home_alert", '\ue900')
        @JvmField
        val cmd_home_analytics = CommunityMaterialIcon("cmd_home_analytics", '\ue900')
        @JvmField
        val cmd_home_assistant = CommunityMaterialIcon("cmd_home_assistant", '\ue900')
        @JvmField
        val cmd_home_automation = CommunityMaterialIcon("cmd_home_automation", '\ue900')
        @JvmField
        val cmd_home_circle_outline = CommunityMaterialIcon("cmd_home_circle_outline", '\ue900')
        @JvmField
        val cmd_home_circle = CommunityMaterialIcon("cmd_home_circle", '\ue900')
        @JvmField
        val cmd_home_city_outline = CommunityMaterialIcon("cmd_home_city_outline", '\ue900')
        @JvmField
        val cmd_home_city = CommunityMaterialIcon("cmd_home_city", '\ue900')
        @JvmField
        val cmd_home_currency_usd = CommunityMaterialIcon("cmd_home_currency_usd", '\ue900')
        @JvmField
        val cmd_home_edit_outline = CommunityMaterialIcon("cmd_home_edit_outline", '\ue900')
        @JvmField
        val cmd_home_edit = CommunityMaterialIcon("cmd_home_edit", '\ue900')
        @JvmField
        val cmd_home_export_outline = CommunityMaterialIcon("cmd_home_export_outline", '\ue900')
        @JvmField
        val cmd_home_flood = CommunityMaterialIcon("cmd_home_flood", '\ue900')
        @JvmField
        val cmd_home_floor_0 = CommunityMaterialIcon("cmd_home_floor_0", '\ue900')
        @JvmField
        val cmd_home_floor_1 = CommunityMaterialIcon("cmd_home_floor_1", '\ue900')
        @JvmField
        val cmd_home_floor_2 = CommunityMaterialIcon("cmd_home_floor_2", '\ue900')
        @JvmField
        val cmd_home_floor_3 = CommunityMaterialIcon("cmd_home_floor_3", '\ue900')
        @JvmField
        val cmd_home_floor_a = CommunityMaterialIcon("cmd_home_floor_a", '\ue900')
        @JvmField
        val cmd_home_floor_b = CommunityMaterialIcon("cmd_home_floor_b", '\ue900')
        @JvmField
        val cmd_home_floor_g = CommunityMaterialIcon("cmd_home_floor_g", '\ue900')
        @JvmField
        val cmd_home_floor_l = CommunityMaterialIcon("cmd_home_floor_l", '\ue900')
        @JvmField
        val cmd_home_floor_negative_1 = CommunityMaterialIcon("cmd_home_floor_negative_1", '\ue900')
        @JvmField
        val cmd_home_group = CommunityMaterialIcon("cmd_home_group", '\ue900')
        @JvmField
        val cmd_home_heart = CommunityMaterialIcon("cmd_home_heart", '\ue900')
        @JvmField
        val cmd_home_import_outline = CommunityMaterialIcon("cmd_home_import_outline", '\ue900')
        @JvmField
        val cmd_home_lightbulb_outline = CommunityMaterialIcon("cmd_home_lightbulb_outline", '\ue900')
        @JvmField
        val cmd_home_lightbulb = CommunityMaterialIcon("cmd_home_lightbulb", '\ue900')
        @JvmField
        val cmd_home_lock_open = CommunityMaterialIcon("cmd_home_lock_open", '\ue900')
        @JvmField
        val cmd_home_lock = CommunityMaterialIcon("cmd_home_lock", '\ue900')
        @JvmField
        val cmd_home_map_marker = CommunityMaterialIcon("cmd_home_map_marker", '\ue900')
        @JvmField
        val cmd_home_minus = CommunityMaterialIcon("cmd_home_minus", '\ue900')
        @JvmField
        val cmd_home_modern = CommunityMaterialIcon("cmd_home_modern", '\ue900')
        @JvmField
        val cmd_home_outline = CommunityMaterialIcon("cmd_home_outline", '\ue900')
        @JvmField
        val cmd_home_plus = CommunityMaterialIcon("cmd_home_plus", '\ue900')
        @JvmField
        val cmd_home_remove = CommunityMaterialIcon("cmd_home_remove", '\ue900')
        @JvmField
        val cmd_home_roof = CommunityMaterialIcon("cmd_home_roof", '\ue900')
        @JvmField
        val cmd_home_thermometer_outline = CommunityMaterialIcon("cmd_home_thermometer_outline", '\ue900')
        @JvmField
        val cmd_home_thermometer = CommunityMaterialIcon("cmd_home_thermometer", '\ue900')
        @JvmField
        val cmd_home_variant_outline = CommunityMaterialIcon("cmd_home_variant_outline", '\ue900')
        @JvmField
        val cmd_home_variant = CommunityMaterialIcon("cmd_home_variant", '\ue900')
        @JvmField
        val cmd_home = CommunityMaterialIcon("cmd_home", '\ue900')
        @JvmField
        val cmd_hook_off = CommunityMaterialIcon("cmd_hook_off", '\ue900')
        @JvmField
        val cmd_hook = CommunityMaterialIcon("cmd_hook", '\ue900')
        @JvmField
        val cmd_hops = CommunityMaterialIcon("cmd_hops", '\ue900')
        @JvmField
        val cmd_horizontal_rotate_clockwise = CommunityMaterialIcon("cmd_horizontal_rotate_clockwise", '\ue900')
        @JvmField
        val cmd_horizontal_rotate_counterclockwise = CommunityMaterialIcon("cmd_horizontal_rotate_counterclockwise", '\ue900')
        @JvmField
        val cmd_horseshoe = CommunityMaterialIcon("cmd_horseshoe", '\ue900')
        @JvmField
        val cmd_hospital_box_outline = CommunityMaterialIcon("cmd_hospital_box_outline", '\ue900')
        @JvmField
        val cmd_hospital_box = CommunityMaterialIcon("cmd_hospital_box", '\ue900')
        @JvmField
        val cmd_hospital_building = CommunityMaterialIcon("cmd_hospital_building", '\ue900')
        @JvmField
        val cmd_hospital_marker = CommunityMaterialIcon("cmd_hospital_marker", '\ue900')
        @JvmField
        val cmd_hospital = CommunityMaterialIcon("cmd_hospital", '\ue900')
        @JvmField
        val cmd_hot_tub = CommunityMaterialIcon("cmd_hot_tub", '\ue900')
        @JvmField
        val cmd_hotel = CommunityMaterialIcon("cmd_hotel", '\ue900')
        @JvmField
        val cmd_houzz_box = CommunityMaterialIcon("cmd_houzz_box", '\ue900')
        @JvmField
        val cmd_houzz = CommunityMaterialIcon("cmd_houzz", '\ue900')
        @JvmField
        val cmd_hubspot = CommunityMaterialIcon("cmd_hubspot", '\ue900')
        @JvmField
        val cmd_hulu = CommunityMaterialIcon("cmd_hulu", '\ue900')
        @JvmField
        val cmd_human_child = CommunityMaterialIcon("cmd_human_child", '\ue900')
        @JvmField
        val cmd_human_female_boy = CommunityMaterialIcon("cmd_human_female_boy", '\ue900')
        @JvmField
        val cmd_human_female_female = CommunityMaterialIcon("cmd_human_female_female", '\ue900')
        @JvmField
        val cmd_human_female_girl = CommunityMaterialIcon("cmd_human_female_girl", '\ue900')
        @JvmField
        val cmd_human_female = CommunityMaterialIcon("cmd_human_female", '\ue900')
        @JvmField
        val cmd_human_greeting = CommunityMaterialIcon("cmd_human_greeting", '\ue900')
        @JvmField
        val cmd_human_handsdown = CommunityMaterialIcon("cmd_human_handsdown", '\ue900')
        @JvmField
        val cmd_human_handsup = CommunityMaterialIcon("cmd_human_handsup", '\ue900')
        @JvmField
        val cmd_human_male_boy = CommunityMaterialIcon("cmd_human_male_boy", '\ue900')
        @JvmField
        val cmd_human_male_female = CommunityMaterialIcon("cmd_human_male_female", '\ue900')
        @JvmField
        val cmd_human_male_girl = CommunityMaterialIcon("cmd_human_male_girl", '\ue900')
        @JvmField
        val cmd_human_male_height_variant = CommunityMaterialIcon("cmd_human_male_height_variant", '\ue900')
        @JvmField
        val cmd_human_male_height = CommunityMaterialIcon("cmd_human_male_height", '\ue900')
        @JvmField
        val cmd_human_male_male = CommunityMaterialIcon("cmd_human_male_male", '\ue900')
        @JvmField
        val cmd_human_male = CommunityMaterialIcon("cmd_human_male", '\ue900')
        @JvmField
        val cmd_human_pregnant = CommunityMaterialIcon("cmd_human_pregnant", '\ue900')
        @JvmField
        val cmd_human = CommunityMaterialIcon("cmd_human", '\ue900')
        @JvmField
        val cmd_humble_bundle = CommunityMaterialIcon("cmd_humble_bundle", '\ue900')
        @JvmField
        val cmd_hydro_power = CommunityMaterialIcon("cmd_hydro_power", '\ue900')
        @JvmField
        val cmd_ice_cream = CommunityMaterialIcon("cmd_ice_cream", '\ue900')
        @JvmField
        val cmd_ice_pop = CommunityMaterialIcon("cmd_ice_pop", '\ue900')
        @JvmField
        val cmd_id_card = CommunityMaterialIcon("cmd_id_card", '\ue900')
        @JvmField
        val cmd_identifier = CommunityMaterialIcon("cmd_identifier", '\ue900')
        @JvmField
        val cmd_iframe_array_outline = CommunityMaterialIcon("cmd_iframe_array_outline", '\ue900')
        @JvmField
        val cmd_iframe_array = CommunityMaterialIcon("cmd_iframe_array", '\ue900')
        @JvmField
        val cmd_iframe_braces_outline = CommunityMaterialIcon("cmd_iframe_braces_outline", '\ue900')
        @JvmField
        val cmd_iframe_braces = CommunityMaterialIcon("cmd_iframe_braces", '\ue900')
        @JvmField
        val cmd_iframe_outline = CommunityMaterialIcon("cmd_iframe_outline", '\ue900')
        @JvmField
        val cmd_iframe_parentheses_outline = CommunityMaterialIcon("cmd_iframe_parentheses_outline", '\ue900')
        @JvmField
        val cmd_iframe_parentheses = CommunityMaterialIcon("cmd_iframe_parentheses", '\ue900')
        @JvmField
        val cmd_iframe_variable_outline = CommunityMaterialIcon("cmd_iframe_variable_outline", '\ue900')
        @JvmField
        val cmd_iframe_variable = CommunityMaterialIcon("cmd_iframe_variable", '\ue900')
        @JvmField
        val cmd_iframe = CommunityMaterialIcon("cmd_iframe", '\ue900')
        @JvmField
        val cmd_image_album = CommunityMaterialIcon("cmd_image_album", '\ue900')
        @JvmField
        val cmd_image_area_close = CommunityMaterialIcon("cmd_image_area_close", '\ue900')
        @JvmField
        val cmd_image_area = CommunityMaterialIcon("cmd_image_area", '\ue900')
        @JvmField
        val cmd_image_auto_adjust = CommunityMaterialIcon("cmd_image_auto_adjust", '\ue900')
        @JvmField
        val cmd_image_broken_variant = CommunityMaterialIcon("cmd_image_broken_variant", '\ue900')
        @JvmField
        val cmd_image_broken = CommunityMaterialIcon("cmd_image_broken", '\ue900')
        @JvmField
        val cmd_image_edit_outline = CommunityMaterialIcon("cmd_image_edit_outline", '\ue900')
        @JvmField
        val cmd_image_edit = CommunityMaterialIcon("cmd_image_edit", '\ue900')
        @JvmField
        val cmd_image_filter_black_white = CommunityMaterialIcon("cmd_image_filter_black_white", '\ue900')
        @JvmField
        val cmd_image_filter_center_focus_strong_outline =
                CommunityMaterialIcon("cmd_image_filter_center_focus_strong_outline", '\ue900')
        @JvmField
        val cmd_image_filter_center_focus_strong = CommunityMaterialIcon("cmd_image_filter_center_focus_strong", '\ue900')
        @JvmField
        val cmd_image_filter_center_focus_weak = CommunityMaterialIcon("cmd_image_filter_center_focus_weak", '\ue900')
        @JvmField
        val cmd_image_filter_center_focus = CommunityMaterialIcon("cmd_image_filter_center_focus", '\ue900')
        @JvmField
        val cmd_image_filter_drama = CommunityMaterialIcon("cmd_image_filter_drama", '\ue900')
        @JvmField
        val cmd_image_filter_frames = CommunityMaterialIcon("cmd_image_filter_frames", '\ue900')
        @JvmField
        val cmd_image_filter_hdr = CommunityMaterialIcon("cmd_image_filter_hdr", '\ue900')
        @JvmField
        val cmd_image_filter_none = CommunityMaterialIcon("cmd_image_filter_none", '\ue900')
        @JvmField
        val cmd_image_filter_tilt_shift = CommunityMaterialIcon("cmd_image_filter_tilt_shift", '\ue900')
        @JvmField
        val cmd_image_filter_vintage = CommunityMaterialIcon("cmd_image_filter_vintage", '\ue900')
        @JvmField
        val cmd_image_filter = CommunityMaterialIcon("cmd_image_filter", '\ue900')
        @JvmField
        val cmd_image_frame = CommunityMaterialIcon("cmd_image_frame", '\ue900')
        @JvmField
        val cmd_image_move = CommunityMaterialIcon("cmd_image_move", '\ue900')
        @JvmField
        val cmd_image_multiple = CommunityMaterialIcon("cmd_image_multiple", '\ue900')
        @JvmField
        val cmd_image_off_outline = CommunityMaterialIcon("cmd_image_off_outline", '\ue900')
        @JvmField
        val cmd_image_off = CommunityMaterialIcon("cmd_image_off", '\ue900')
        @JvmField
        val cmd_image_outline = CommunityMaterialIcon("cmd_image_outline", '\ue900')
        @JvmField
        val cmd_image_plus = CommunityMaterialIcon("cmd_image_plus", '\ue900')
        @JvmField
        val cmd_image_search_outline = CommunityMaterialIcon("cmd_image_search_outline", '\ue900')
        @JvmField
        val cmd_image_search = CommunityMaterialIcon("cmd_image_search", '\ue900')
        @JvmField
        val cmd_image_size_select_actual = CommunityMaterialIcon("cmd_image_size_select_actual", '\ue900')
        @JvmField
        val cmd_image_size_select_large = CommunityMaterialIcon("cmd_image_size_select_large", '\ue900')
        @JvmField
        val cmd_image_size_select_small = CommunityMaterialIcon("cmd_image_size_select_small", '\ue900')
        @JvmField
        val cmd_image = CommunityMaterialIcon("cmd_image", '\ue900')
        @JvmField
        val cmd_import = CommunityMaterialIcon("cmd_import", '\ue900')
        @JvmField
        val cmd_inbox_arrow_down_outline = CommunityMaterialIcon("cmd_inbox_arrow_down_outline", '\ue900')
        @JvmField
        val cmd_inbox_arrow_down = CommunityMaterialIcon("cmd_inbox_arrow_down", '\ue900')
        @JvmField
        val cmd_inbox_arrow_up_outline = CommunityMaterialIcon("cmd_inbox_arrow_up_outline", '\ue900')
        @JvmField
        val cmd_inbox_arrow_up = CommunityMaterialIcon("cmd_inbox_arrow_up", '\ue900')
        @JvmField
        val cmd_inbox_full_outline = CommunityMaterialIcon("cmd_inbox_full_outline", '\ue900')
        @JvmField
        val cmd_inbox_full = CommunityMaterialIcon("cmd_inbox_full", '\ue900')
        @JvmField
        val cmd_inbox_multiple_outline = CommunityMaterialIcon("cmd_inbox_multiple_outline", '\ue900')
        @JvmField
        val cmd_inbox_multiple = CommunityMaterialIcon("cmd_inbox_multiple", '\ue900')
        @JvmField
        val cmd_inbox_outline = CommunityMaterialIcon("cmd_inbox_outline", '\ue900')
        @JvmField
        val cmd_inbox = CommunityMaterialIcon("cmd_inbox", '\ue900')
        @JvmField
        val cmd_incognito = CommunityMaterialIcon("cmd_incognito", '\ue900')
        @JvmField
        val cmd_infinity = CommunityMaterialIcon("cmd_infinity", '\ue900')
        @JvmField
        val cmd_information_outline = CommunityMaterialIcon("cmd_information_outline", '\ue900')
        @JvmField
        val cmd_information_variant = CommunityMaterialIcon("cmd_information_variant", '\ue900')
        @JvmField
        val cmd_information = CommunityMaterialIcon("cmd_information", '\ue900')
        @JvmField
        val cmd_instagram = CommunityMaterialIcon("cmd_instagram", '\ue900')
        @JvmField
        val cmd_instapaper = CommunityMaterialIcon("cmd_instapaper", '\ue900')
        @JvmField
        val cmd_instrument_triangle = CommunityMaterialIcon("cmd_instrument_triangle", '\ue900')
        @JvmField
        val cmd_internet_explorer = CommunityMaterialIcon("cmd_internet_explorer", '\ue900')
        @JvmField
        val cmd_invert_colors_off = CommunityMaterialIcon("cmd_invert_colors_off", '\ue900')
        @JvmField
        val cmd_invert_colors = CommunityMaterialIcon("cmd_invert_colors", '\ue900')
        @JvmField
        val cmd_ip_network_outline = CommunityMaterialIcon("cmd_ip_network_outline", '\ue900')
        @JvmField
        val cmd_ip_network = CommunityMaterialIcon("cmd_ip_network", '\ue900')
        @JvmField
        val cmd_ip = CommunityMaterialIcon("cmd_ip", '\ue900')
        @JvmField
        val cmd_ipod = CommunityMaterialIcon("cmd_ipod", '\ue900')
        @JvmField
        val cmd_islam = CommunityMaterialIcon("cmd_islam", '\ue900')
        @JvmField
        val cmd_island = CommunityMaterialIcon("cmd_island", '\ue900')
        @JvmField
        val cmd_itunes = CommunityMaterialIcon("cmd_itunes", '\ue900')
        @JvmField
        val cmd_iv_bag = CommunityMaterialIcon("cmd_iv_bag", '\ue900')
        @JvmField
        val cmd_jabber = CommunityMaterialIcon("cmd_jabber", '\ue900')
        @JvmField
        val cmd_jeepney = CommunityMaterialIcon("cmd_jeepney", '\ue900')
        @JvmField
        val cmd_jellyfish_outline = CommunityMaterialIcon("cmd_jellyfish_outline", '\ue900')
        @JvmField
        val cmd_jellyfish = CommunityMaterialIcon("cmd_jellyfish", '\ue900')
        @JvmField
        val cmd_jira = CommunityMaterialIcon("cmd_jira", '\ue900')
        @JvmField
        val cmd_jquery = CommunityMaterialIcon("cmd_jquery", '\ue900')
        @JvmField
        val cmd_jsfiddle = CommunityMaterialIcon("cmd_jsfiddle", '\ue900')
        @JvmField
        val cmd_json = CommunityMaterialIcon("cmd_json", '\ue900')
        @JvmField
        val cmd_judaism = CommunityMaterialIcon("cmd_judaism", '\ue900')
        @JvmField
        val cmd_kabaddi = CommunityMaterialIcon("cmd_kabaddi", '\ue900')
        @JvmField
        val cmd_karate = CommunityMaterialIcon("cmd_karate", '\ue900')
        @JvmField
        val cmd_keg = CommunityMaterialIcon("cmd_keg", '\ue900')
        @JvmField
        val cmd_kettle_outline = CommunityMaterialIcon("cmd_kettle_outline", '\ue900')
        @JvmField
        val cmd_kettle = CommunityMaterialIcon("cmd_kettle", '\ue900')
        @JvmField
        val cmd_key_change = CommunityMaterialIcon("cmd_key_change", '\ue900')
        @JvmField
        val cmd_key_link = CommunityMaterialIcon("cmd_key_link", '\ue900')
        @JvmField
        val cmd_key_minus = CommunityMaterialIcon("cmd_key_minus", '\ue900')
        @JvmField
        val cmd_key_outline = CommunityMaterialIcon("cmd_key_outline", '\ue900')
        @JvmField
        val cmd_key_plus = CommunityMaterialIcon("cmd_key_plus", '\ue900')
        @JvmField
        val cmd_key_remove = CommunityMaterialIcon("cmd_key_remove", '\ue900')
        @JvmField
        val cmd_key_star = CommunityMaterialIcon("cmd_key_star", '\ue900')
        @JvmField
        val cmd_key_variant = CommunityMaterialIcon("cmd_key_variant", '\ue900')
        @JvmField
        val cmd_key_wireless = CommunityMaterialIcon("cmd_key_wireless", '\ue900')
        @JvmField
        val cmd_key = CommunityMaterialIcon("cmd_key", '\ue900')
        @JvmField
        val cmd_keyboard_backspace = CommunityMaterialIcon("cmd_keyboard_backspace", '\ue900')
        @JvmField
        val cmd_keyboard_caps = CommunityMaterialIcon("cmd_keyboard_caps", '\ue900')
        @JvmField
        val cmd_keyboard_close = CommunityMaterialIcon("cmd_keyboard_close", '\ue900')
        @JvmField
        val cmd_keyboard_esc = CommunityMaterialIcon("cmd_keyboard_esc", '\ue900')
        @JvmField
        val cmd_keyboard_f1 = CommunityMaterialIcon("cmd_keyboard_f1", '\ue900')
        @JvmField
        val cmd_keyboard_f2 = CommunityMaterialIcon("cmd_keyboard_f2", '\ue900')
        @JvmField
        val cmd_keyboard_f3 = CommunityMaterialIcon("cmd_keyboard_f3", '\ue900')
        @JvmField
        val cmd_keyboard_f4 = CommunityMaterialIcon("cmd_keyboard_f4", '\ue900')
        @JvmField
        val cmd_keyboard_f5 = CommunityMaterialIcon("cmd_keyboard_f5", '\ue900')
        @JvmField
        val cmd_keyboard_f6 = CommunityMaterialIcon("cmd_keyboard_f6", '\ue900')
        @JvmField
        val cmd_keyboard_f7 = CommunityMaterialIcon("cmd_keyboard_f7", '\ue900')
        @JvmField
        val cmd_keyboard_f8 = CommunityMaterialIcon("cmd_keyboard_f8", '\ue900')
        @JvmField
        val cmd_keyboard_f9 = CommunityMaterialIcon("cmd_keyboard_f9", '\ue900')
        @JvmField
        val cmd_keyboard_f10 = CommunityMaterialIcon("cmd_keyboard_f10", '\ue900')
        @JvmField
        val cmd_keyboard_f11 = CommunityMaterialIcon("cmd_keyboard_f11", '\ue900')
        @JvmField
        val cmd_keyboard_f12 = CommunityMaterialIcon("cmd_keyboard_f12", '\ue900')
        @JvmField
        val cmd_keyboard_off_outline = CommunityMaterialIcon("cmd_keyboard_off_outline", '\ue900')
        @JvmField
        val cmd_keyboard_off = CommunityMaterialIcon("cmd_keyboard_off", '\ue900')
        @JvmField
        val cmd_keyboard_outline = CommunityMaterialIcon("cmd_keyboard_outline", '\ue900')
        @JvmField
        val cmd_keyboard_return = CommunityMaterialIcon("cmd_keyboard_return", '\ue900')
        @JvmField
        val cmd_keyboard_settings_outline = CommunityMaterialIcon("cmd_keyboard_settings_outline", '\ue900')
        @JvmField
        val cmd_keyboard_settings = CommunityMaterialIcon("cmd_keyboard_settings", '\ue900')
        @JvmField
        val cmd_keyboard_space = CommunityMaterialIcon("cmd_keyboard_space", '\ue900')
        @JvmField
        val cmd_keyboard_tab = CommunityMaterialIcon("cmd_keyboard_tab", '\ue900')
        @JvmField
        val cmd_keyboard_variant = CommunityMaterialIcon("cmd_keyboard_variant", '\ue900')
        @JvmField
        val cmd_keyboard = CommunityMaterialIcon("cmd_keyboard", '\ue900')
        @JvmField
        val cmd_khanda = CommunityMaterialIcon("cmd_khanda", '\ue900')
        @JvmField
        val cmd_kickstarter = CommunityMaterialIcon("cmd_kickstarter", '\ue900')
        @JvmField
        val cmd_knife_military = CommunityMaterialIcon("cmd_knife_military", '\ue900')
        @JvmField
        val cmd_knife = CommunityMaterialIcon("cmd_knife", '\ue900')
        @JvmField
        val cmd_kodi = CommunityMaterialIcon("cmd_kodi", '\ue900')
        @JvmField
        val cmd_kotlin = CommunityMaterialIcon("cmd_kotlin", '\ue900')
        @JvmField
        val cmd_kubernetes = CommunityMaterialIcon("cmd_kubernetes", '\ue900')
        @JvmField
        val cmd_label_off_outline = CommunityMaterialIcon("cmd_label_off_outline", '\ue900')
        @JvmField
        val cmd_label_off = CommunityMaterialIcon("cmd_label_off", '\ue900')
        @JvmField
        val cmd_label_outline = CommunityMaterialIcon("cmd_label_outline", '\ue900')
        @JvmField
        val cmd_label_variant_outline = CommunityMaterialIcon("cmd_label_variant_outline", '\ue900')
        @JvmField
        val cmd_label_variant = CommunityMaterialIcon("cmd_label_variant", '\ue900')
        @JvmField
        val cmd_label = CommunityMaterialIcon("cmd_label", '\ue900')
        @JvmField
        val cmd_ladybug = CommunityMaterialIcon("cmd_ladybug", '\ue900')
        @JvmField
        val cmd_lambda = CommunityMaterialIcon("cmd_lambda", '\ue900')
        @JvmField
        val cmd_lamp = CommunityMaterialIcon("cmd_lamp", '\ue900')
        @JvmField
        val cmd_lan_check = CommunityMaterialIcon("cmd_lan_check", '\ue900')
        @JvmField
        val cmd_lan_connect = CommunityMaterialIcon("cmd_lan_connect", '\ue900')
        @JvmField
        val cmd_lan_disconnect = CommunityMaterialIcon("cmd_lan_disconnect", '\ue900')
        @JvmField
        val cmd_lan_pending = CommunityMaterialIcon("cmd_lan_pending", '\ue900')
        @JvmField
        val cmd_lan = CommunityMaterialIcon("cmd_lan", '\ue900')
        @JvmField
        val cmd_language_c = CommunityMaterialIcon("cmd_language_c", '\ue900')
        @JvmField
        val cmd_language_cpp = CommunityMaterialIcon("cmd_language_cpp", '\ue900')
        @JvmField
        val cmd_language_csharp = CommunityMaterialIcon("cmd_language_csharp", '\ue900')
        @JvmField
        val cmd_language_css3 = CommunityMaterialIcon("cmd_language_css3", '\ue900')
        @JvmField
        val cmd_language_fortran = CommunityMaterialIcon("cmd_language_fortran", '\ue900')
        @JvmField
        val cmd_language_go = CommunityMaterialIcon("cmd_language_go", '\ue900')
        @JvmField
        val cmd_language_haskell = CommunityMaterialIcon("cmd_language_haskell", '\ue900')
        @JvmField
        val cmd_language_html5 = CommunityMaterialIcon("cmd_language_html5", '\ue900')
        @JvmField
        val cmd_language_java = CommunityMaterialIcon("cmd_language_java", '\ue900')
        @JvmField
        val cmd_language_javascript = CommunityMaterialIcon("cmd_language_javascript", '\ue900')
        @JvmField
        val cmd_language_lua = CommunityMaterialIcon("cmd_language_lua", '\ue900')
        @JvmField
        val cmd_language_php = CommunityMaterialIcon("cmd_language_php", '\ue900')
        @JvmField
        val cmd_language_python_text = CommunityMaterialIcon("cmd_language_python_text", '\ue900')
        @JvmField
        val cmd_language_python = CommunityMaterialIcon("cmd_language_python", '\ue900')
        @JvmField
        val cmd_language_r = CommunityMaterialIcon("cmd_language_r", '\ue900')
        @JvmField
        val cmd_language_ruby_on_rails = CommunityMaterialIcon("cmd_language_ruby_on_rails", '\ue900')
        @JvmField
        val cmd_language_swift = CommunityMaterialIcon("cmd_language_swift", '\ue900')
        @JvmField
        val cmd_language_typescript = CommunityMaterialIcon("cmd_language_typescript", '\ue900')
        @JvmField
        val cmd_laptop_chromebook = CommunityMaterialIcon("cmd_laptop_chromebook", '\ue900')
        @JvmField
        val cmd_laptop_mac = CommunityMaterialIcon("cmd_laptop_mac", '\ue900')
        @JvmField
        val cmd_laptop_off = CommunityMaterialIcon("cmd_laptop_off", '\ue900')
        @JvmField
        val cmd_laptop_windows = CommunityMaterialIcon("cmd_laptop_windows", '\ue900')
        @JvmField
        val cmd_laptop = CommunityMaterialIcon("cmd_laptop", '\ue900')
        @JvmField
        val cmd_laravel = CommunityMaterialIcon("cmd_laravel", '\ue900')
        @JvmField
        val cmd_lasso = CommunityMaterialIcon("cmd_lasso", '\ue900')
        @JvmField
        val cmd_lastfm = CommunityMaterialIcon("cmd_lastfm", '\ue900')
        @JvmField
        val cmd_lastpass = CommunityMaterialIcon("cmd_lastpass", '\ue900')
        @JvmField
        val cmd_latitude = CommunityMaterialIcon("cmd_latitude", '\ue900')
        @JvmField
        val cmd_launch = CommunityMaterialIcon("cmd_launch", '\ue900')
        @JvmField
        val cmd_lava_lamp = CommunityMaterialIcon("cmd_lava_lamp", '\ue900')
        @JvmField
        val cmd_layers_minus = CommunityMaterialIcon("cmd_layers_minus", '\ue900')
        @JvmField
        val cmd_layers_off_outline = CommunityMaterialIcon("cmd_layers_off_outline", '\ue900')
        @JvmField
        val cmd_layers_off = CommunityMaterialIcon("cmd_layers_off", '\ue900')
        @JvmField
        val cmd_layers_outline = CommunityMaterialIcon("cmd_layers_outline", '\ue900')
        @JvmField
        val cmd_layers_plus = CommunityMaterialIcon("cmd_layers_plus", '\ue900')
        @JvmField
        val cmd_layers_remove = CommunityMaterialIcon("cmd_layers_remove", '\ue900')
        @JvmField
        val cmd_layers_search_outline = CommunityMaterialIcon("cmd_layers_search_outline", '\ue900')
        @JvmField
        val cmd_layers_search = CommunityMaterialIcon("cmd_layers_search", '\ue900')
        @JvmField
        val cmd_layers_triple_outline = CommunityMaterialIcon("cmd_layers_triple_outline", '\ue900')
        @JvmField
        val cmd_layers_triple = CommunityMaterialIcon("cmd_layers_triple", '\ue900')
        @JvmField
        val cmd_layers = CommunityMaterialIcon("cmd_layers", '\ue900')
        @JvmField
        val cmd_lead_pencil = CommunityMaterialIcon("cmd_lead_pencil", '\ue900')
        @JvmField
        val cmd_leaf_maple_off = CommunityMaterialIcon("cmd_leaf_maple_off", '\ue900')
        @JvmField
        val cmd_leaf_maple = CommunityMaterialIcon("cmd_leaf_maple", '\ue900')
        @JvmField
        val cmd_leaf_off = CommunityMaterialIcon("cmd_leaf_off", '\ue900')
        @JvmField
        val cmd_leaf = CommunityMaterialIcon("cmd_leaf", '\ue900')
        @JvmField
        val cmd_leak_off = CommunityMaterialIcon("cmd_leak_off", '\ue900')
        @JvmField
        val cmd_leak = CommunityMaterialIcon("cmd_leak", '\ue900')
        @JvmField
        val cmd_led_off = CommunityMaterialIcon("cmd_led_off", '\ue900')
        @JvmField
        val cmd_led_on = CommunityMaterialIcon("cmd_led_on", '\ue900')
        @JvmField
        val cmd_led_outline = CommunityMaterialIcon("cmd_led_outline", '\ue900')
        @JvmField
        val cmd_led_strip_variant = CommunityMaterialIcon("cmd_led_strip_variant", '\ue900')
        @JvmField
        val cmd_led_strip = CommunityMaterialIcon("cmd_led_strip", '\ue900')
        @JvmField
        val cmd_led_variant_off = CommunityMaterialIcon("cmd_led_variant_off", '\ue900')
        @JvmField
        val cmd_led_variant_on = CommunityMaterialIcon("cmd_led_variant_on", '\ue900')
        @JvmField
        val cmd_led_variant_outline = CommunityMaterialIcon("cmd_led_variant_outline", '\ue900')
        @JvmField
        val cmd_leek = CommunityMaterialIcon("cmd_leek", '\ue900')
        @JvmField
        val cmd_less_than_or_equal = CommunityMaterialIcon("cmd_less_than_or_equal", '\ue900')
        @JvmField
        val cmd_less_than = CommunityMaterialIcon("cmd_less_than", '\ue900')
        @JvmField
        val cmd_library_books = CommunityMaterialIcon("cmd_library_books", '\ue900')
        @JvmField
        val cmd_library_movie = CommunityMaterialIcon("cmd_library_movie", '\ue900')
        @JvmField
        val cmd_library_music_outline = CommunityMaterialIcon("cmd_library_music_outline", '\ue900')
        @JvmField
        val cmd_library_music = CommunityMaterialIcon("cmd_library_music", '\ue900')
        @JvmField
        val cmd_library_shelves = CommunityMaterialIcon("cmd_library_shelves", '\ue900')
        @JvmField
        val cmd_library_video = CommunityMaterialIcon("cmd_library_video", '\ue900')
        @JvmField
        val cmd_library = CommunityMaterialIcon("cmd_library", '\ue900')
        @JvmField
        val cmd_license = CommunityMaterialIcon("cmd_license", '\ue900')
        @JvmField
        val cmd_lifebuoy = CommunityMaterialIcon("cmd_lifebuoy", '\ue900')
        @JvmField
        val cmd_light_switch = CommunityMaterialIcon("cmd_light_switch", '\ue900')
        @JvmField
        val cmd_lightbulb_cfl_off = CommunityMaterialIcon("cmd_lightbulb_cfl_off", '\ue900')
        @JvmField
        val cmd_lightbulb_cfl_spiral_off = CommunityMaterialIcon("cmd_lightbulb_cfl_spiral_off", '\ue900')
        @JvmField
        val cmd_lightbulb_cfl_spiral = CommunityMaterialIcon("cmd_lightbulb_cfl_spiral", '\ue900')
        @JvmField
        val cmd_lightbulb_cfl = CommunityMaterialIcon("cmd_lightbulb_cfl", '\ue900')
        @JvmField
        val cmd_lightbulb_group_off_outline = CommunityMaterialIcon("cmd_lightbulb_group_off_outline", '\ue900')
        @JvmField
        val cmd_lightbulb_group_off = CommunityMaterialIcon("cmd_lightbulb_group_off", '\ue900')
        @JvmField
        val cmd_lightbulb_group_outline = CommunityMaterialIcon("cmd_lightbulb_group_outline", '\ue900')
        @JvmField
        val cmd_lightbulb_group = CommunityMaterialIcon("cmd_lightbulb_group", '\ue900')
        @JvmField
        val cmd_lightbulb_multiple_off_outline = CommunityMaterialIcon("cmd_lightbulb_multiple_off_outline", '\ue900')
        @JvmField
        val cmd_lightbulb_multiple_off = CommunityMaterialIcon("cmd_lightbulb_multiple_off", '\ue900')
        @JvmField
        val cmd_lightbulb_multiple_outline = CommunityMaterialIcon("cmd_lightbulb_multiple_outline", '\ue900')
        @JvmField
        val cmd_lightbulb_multiple = CommunityMaterialIcon("cmd_lightbulb_multiple", '\ue900')
        @JvmField
        val cmd_lightbulb_off_outline = CommunityMaterialIcon("cmd_lightbulb_off_outline", '\ue900')
        @JvmField
        val cmd_lightbulb_off = CommunityMaterialIcon("cmd_lightbulb_off", '\ue900')
        @JvmField
        val cmd_lightbulb_on_outline = CommunityMaterialIcon("cmd_lightbulb_on_outline", '\ue900')
        @JvmField
        val cmd_lightbulb_on = CommunityMaterialIcon("cmd_lightbulb_on", '\ue900')
        @JvmField
        val cmd_lightbulb_outline = CommunityMaterialIcon("cmd_lightbulb_outline", '\ue900')
        @JvmField
        val cmd_lightbulb = CommunityMaterialIcon("cmd_lightbulb", '\ue900')
        @JvmField
        val cmd_lighthouse_on = CommunityMaterialIcon("cmd_lighthouse_on", '\ue900')
        @JvmField
        val cmd_lighthouse = CommunityMaterialIcon("cmd_lighthouse", '\ue900')
        @JvmField
        val cmd_link_box_outline = CommunityMaterialIcon("cmd_link_box_outline", '\ue900')
        @JvmField
        val cmd_link_box_variant_outline = CommunityMaterialIcon("cmd_link_box_variant_outline", '\ue900')
        @JvmField
        val cmd_link_box_variant = CommunityMaterialIcon("cmd_link_box_variant", '\ue900')
        @JvmField
        val cmd_link_box = CommunityMaterialIcon("cmd_link_box", '\ue900')
        @JvmField
        val cmd_link_lock = CommunityMaterialIcon("cmd_link_lock", '\ue900')
        @JvmField
        val cmd_link_off = CommunityMaterialIcon("cmd_link_off", '\ue900')
        @JvmField
        val cmd_link_plus = CommunityMaterialIcon("cmd_link_plus", '\ue900')
        @JvmField
        val cmd_link_variant_minus = CommunityMaterialIcon("cmd_link_variant_minus", '\ue900')
        @JvmField
        val cmd_link_variant_off = CommunityMaterialIcon("cmd_link_variant_off", '\ue900')
        @JvmField
        val cmd_link_variant_plus = CommunityMaterialIcon("cmd_link_variant_plus", '\ue900')
        @JvmField
        val cmd_link_variant_remove = CommunityMaterialIcon("cmd_link_variant_remove", '\ue900')
        @JvmField
        val cmd_link_variant = CommunityMaterialIcon("cmd_link_variant", '\ue900')
        @JvmField
        val cmd_link = CommunityMaterialIcon("cmd_link", '\ue900')
        @JvmField
        val cmd_linkedin_box = CommunityMaterialIcon("cmd_linkedin_box", '\ue900')
        @JvmField
        val cmd_linkedin = CommunityMaterialIcon("cmd_linkedin", '\ue900')
        @JvmField
        val cmd_linux_mint = CommunityMaterialIcon("cmd_linux_mint", '\ue900')
        @JvmField
        val cmd_linux = CommunityMaterialIcon("cmd_linux", '\ue900')
        @JvmField
        val cmd_litecoin = CommunityMaterialIcon("cmd_litecoin", '\ue900')
        @JvmField
        val cmd_loading = CommunityMaterialIcon("cmd_loading", '\ue900')
        @JvmField
        val cmd_location_enter = CommunityMaterialIcon("cmd_location_enter", '\ue900')
        @JvmField
        val cmd_location_exit = CommunityMaterialIcon("cmd_location_exit", '\ue900')
        @JvmField
        val cmd_lock_alert = CommunityMaterialIcon("cmd_lock_alert", '\ue900')
        @JvmField
        val cmd_lock_clock = CommunityMaterialIcon("cmd_lock_clock", '\ue900')
        @JvmField
        val cmd_lock_open_outline = CommunityMaterialIcon("cmd_lock_open_outline", '\ue900')
        @JvmField
        val cmd_lock_open_variant_outline = CommunityMaterialIcon("cmd_lock_open_variant_outline", '\ue900')
        @JvmField
        val cmd_lock_open_variant = CommunityMaterialIcon("cmd_lock_open_variant", '\ue900')
        @JvmField
        val cmd_lock_open = CommunityMaterialIcon("cmd_lock_open", '\ue900')
        @JvmField
        val cmd_lock_outline = CommunityMaterialIcon("cmd_lock_outline", '\ue900')
        @JvmField
        val cmd_lock_pattern = CommunityMaterialIcon("cmd_lock_pattern", '\ue900')
        @JvmField
        val cmd_lock_plus = CommunityMaterialIcon("cmd_lock_plus", '\ue900')
        @JvmField
        val cmd_lock_question = CommunityMaterialIcon("cmd_lock_question", '\ue900')
        @JvmField
        val cmd_lock_reset = CommunityMaterialIcon("cmd_lock_reset", '\ue900')
        @JvmField
        val cmd_lock_smart = CommunityMaterialIcon("cmd_lock_smart", '\ue900')
        @JvmField
        val cmd_lock = CommunityMaterialIcon("cmd_lock", '\ue900')
        @JvmField
        val cmd_locker_multiple = CommunityMaterialIcon("cmd_locker_multiple", '\ue900')
        @JvmField
        val cmd_locker = CommunityMaterialIcon("cmd_locker", '\ue900')
        @JvmField
        val cmd_login_variant = CommunityMaterialIcon("cmd_login_variant", '\ue900')
        @JvmField
        val cmd_login = CommunityMaterialIcon("cmd_login", '\ue900')
        @JvmField
        val cmd_logout_variant = CommunityMaterialIcon("cmd_logout_variant", '\ue900')
        @JvmField
        val cmd_logout = CommunityMaterialIcon("cmd_logout", '\ue900')
        @JvmField
        val cmd_longitude = CommunityMaterialIcon("cmd_longitude", '\ue900')
        @JvmField
        val cmd_looks = CommunityMaterialIcon("cmd_looks", '\ue900')
        @JvmField
        val cmd_loupe = CommunityMaterialIcon("cmd_loupe", '\ue900')
        @JvmField
        val cmd_lumx = CommunityMaterialIcon("cmd_lumx", '\ue900')
        @JvmField
        val cmd_lungs = CommunityMaterialIcon("cmd_lungs", '\ue900')
        @JvmField
        val cmd_lyft = CommunityMaterialIcon("cmd_lyft", '\ue900')
        @JvmField
        val cmd_magnet_on = CommunityMaterialIcon("cmd_magnet_on", '\ue900')
        @JvmField
        val cmd_magnet = CommunityMaterialIcon("cmd_magnet", '\ue900')
        @JvmField
        val cmd_magnify_close = CommunityMaterialIcon("cmd_magnify_close", '\ue900')
        @JvmField
        val cmd_magnify_minus_cursor = CommunityMaterialIcon("cmd_magnify_minus_cursor", '\ue900')
        @JvmField
        val cmd_magnify_minus_outline = CommunityMaterialIcon("cmd_magnify_minus_outline", '\ue900')
        @JvmField
        val cmd_magnify_minus = CommunityMaterialIcon("cmd_magnify_minus", '\ue900')
        @JvmField
        val cmd_magnify_plus_cursor = CommunityMaterialIcon("cmd_magnify_plus_cursor", '\ue900')
        @JvmField
        val cmd_magnify_plus_outline = CommunityMaterialIcon("cmd_magnify_plus_outline", '\ue900')
        @JvmField
        val cmd_magnify_plus = CommunityMaterialIcon("cmd_magnify_plus", '\ue900')
        @JvmField
        val cmd_magnify_remove_cursor = CommunityMaterialIcon("cmd_magnify_remove_cursor", '\ue900')
        @JvmField
        val cmd_magnify_remove_outline = CommunityMaterialIcon("cmd_magnify_remove_outline", '\ue900')
        @JvmField
        val cmd_magnify_scan = CommunityMaterialIcon("cmd_magnify_scan", '\ue900')
        @JvmField
        val cmd_magnify = CommunityMaterialIcon("cmd_magnify", '\ue900')
        @JvmField
        val cmd_mail_ru = CommunityMaterialIcon("cmd_mail_ru", '\ue900')
        @JvmField
        val cmd_mail = CommunityMaterialIcon("cmd_mail", '\ue900')
        @JvmField
        val cmd_mailbox_open_outline = CommunityMaterialIcon("cmd_mailbox_open_outline", '\ue900')
        @JvmField
        val cmd_mailbox_open_up_outline = CommunityMaterialIcon("cmd_mailbox_open_up_outline", '\ue900')
        @JvmField
        val cmd_mailbox_open_up = CommunityMaterialIcon("cmd_mailbox_open_up", '\ue900')
        @JvmField
        val cmd_mailbox_open = CommunityMaterialIcon("cmd_mailbox_open", '\ue900')
        @JvmField
        val cmd_mailbox_outline = CommunityMaterialIcon("cmd_mailbox_outline", '\ue900')
        @JvmField
        val cmd_mailbox_up_outline = CommunityMaterialIcon("cmd_mailbox_up_outline", '\ue900')
        @JvmField
        val cmd_mailbox_up = CommunityMaterialIcon("cmd_mailbox_up", '\ue900')
        @JvmField
        val cmd_mailbox = CommunityMaterialIcon("cmd_mailbox", '\ue900')
        @JvmField
        val cmd_map_check_outline = CommunityMaterialIcon("cmd_map_check_outline", '\ue900')
        @JvmField
        val cmd_map_check = CommunityMaterialIcon("cmd_map_check", '\ue900')
        @JvmField
        val cmd_map_clock_outline = CommunityMaterialIcon("cmd_map_clock_outline", '\ue900')
        @JvmField
        val cmd_map_clock = CommunityMaterialIcon("cmd_map_clock", '\ue900')
        @JvmField
        val cmd_map_legend = CommunityMaterialIcon("cmd_map_legend", '\ue900')
        @JvmField
        val cmd_map_marker_alert_outline = CommunityMaterialIcon("cmd_map_marker_alert_outline", '\ue900')
        @JvmField
        val cmd_map_marker_alert = CommunityMaterialIcon("cmd_map_marker_alert", '\ue900')
        @JvmField
        val cmd_map_marker_check = CommunityMaterialIcon("cmd_map_marker_check", '\ue900')
        @JvmField
        val cmd_map_marker_circle = CommunityMaterialIcon("cmd_map_marker_circle", '\ue900')
        @JvmField
        val cmd_map_marker_distance = CommunityMaterialIcon("cmd_map_marker_distance", '\ue900')
        @JvmField
        val cmd_map_marker_down = CommunityMaterialIcon("cmd_map_marker_down", '\ue900')
        @JvmField
        val cmd_map_marker_left_outline = CommunityMaterialIcon("cmd_map_marker_left_outline", '\ue900')
        @JvmField
        val cmd_map_marker_left = CommunityMaterialIcon("cmd_map_marker_left", '\ue900')
        @JvmField
        val cmd_map_marker_minus = CommunityMaterialIcon("cmd_map_marker_minus", '\ue900')
        @JvmField
        val cmd_map_marker_multiple_outline = CommunityMaterialIcon("cmd_map_marker_multiple_outline", '\ue900')
        @JvmField
        val cmd_map_marker_multiple = CommunityMaterialIcon("cmd_map_marker_multiple", '\ue900')
        @JvmField
        val cmd_map_marker_off = CommunityMaterialIcon("cmd_map_marker_off", '\ue900')
        @JvmField
        val cmd_map_marker_outline = CommunityMaterialIcon("cmd_map_marker_outline", '\ue900')
        @JvmField
        val cmd_map_marker_path = CommunityMaterialIcon("cmd_map_marker_path", '\ue900')
        @JvmField
        val cmd_map_marker_plus = CommunityMaterialIcon("cmd_map_marker_plus", '\ue900')
        @JvmField
        val cmd_map_marker_question_outline = CommunityMaterialIcon("cmd_map_marker_question_outline", '\ue900')
        @JvmField
        val cmd_map_marker_question = CommunityMaterialIcon("cmd_map_marker_question", '\ue900')
        @JvmField
        val cmd_map_marker_radius = CommunityMaterialIcon("cmd_map_marker_radius", '\ue900')
        @JvmField
        val cmd_map_marker_remove_variant = CommunityMaterialIcon("cmd_map_marker_remove_variant", '\ue900')
        @JvmField
        val cmd_map_marker_remove = CommunityMaterialIcon("cmd_map_marker_remove", '\ue900')
        @JvmField
        val cmd_map_marker_right_outline = CommunityMaterialIcon("cmd_map_marker_right_outline", '\ue900')
        @JvmField
        val cmd_map_marker_right = CommunityMaterialIcon("cmd_map_marker_right", '\ue900')
        @JvmField
        val cmd_map_marker_up = CommunityMaterialIcon("cmd_map_marker_up", '\ue900')
        @JvmField
        val cmd_map_marker = CommunityMaterialIcon("cmd_map_marker", '\ue900')
        @JvmField
        val cmd_map_minus = CommunityMaterialIcon("cmd_map_minus", '\ue900')
        @JvmField
        val cmd_map_outline = CommunityMaterialIcon("cmd_map_outline", '\ue900')
        @JvmField
        val cmd_map_plus = CommunityMaterialIcon("cmd_map_plus", '\ue900')
        @JvmField
        val cmd_map_search_outline = CommunityMaterialIcon("cmd_map_search_outline", '\ue900')
        @JvmField
        val cmd_map_search = CommunityMaterialIcon("cmd_map_search", '\ue900')
        @JvmField
        val cmd_map = CommunityMaterialIcon("cmd_map", '\ue900')
        @JvmField
        val cmd_mapbox = CommunityMaterialIcon("cmd_mapbox", '\ue900')
        @JvmField
        val cmd_margin = CommunityMaterialIcon("cmd_margin", '\ue900')
        @JvmField
        val cmd_markdown_outline = CommunityMaterialIcon("cmd_markdown_outline", '\ue900')
        @JvmField
        val cmd_markdown = CommunityMaterialIcon("cmd_markdown", '\ue900')
        @JvmField
        val cmd_marker_cancel = CommunityMaterialIcon("cmd_marker_cancel", '\ue900')
        @JvmField
        val cmd_marker_check = CommunityMaterialIcon("cmd_marker_check", '\ue900')
        @JvmField
        val cmd_marker = CommunityMaterialIcon("cmd_marker", '\ue900')
        @JvmField
        val cmd_mastodon_variant = CommunityMaterialIcon("cmd_mastodon_variant", '\ue900')
        @JvmField
        val cmd_mastodon = CommunityMaterialIcon("cmd_mastodon", '\ue900')
        @JvmField
        val cmd_material_design = CommunityMaterialIcon("cmd_material_design", '\ue900')
        @JvmField
        val cmd_material_ui = CommunityMaterialIcon("cmd_material_ui", '\ue900')
        @JvmField
        val cmd_math_compass = CommunityMaterialIcon("cmd_math_compass", '\ue900')
        @JvmField
        val cmd_math_cos = CommunityMaterialIcon("cmd_math_cos", '\ue900')
        @JvmField
        val cmd_math_integral_box = CommunityMaterialIcon("cmd_math_integral_box", '\ue900')
        @JvmField
        val cmd_math_integral = CommunityMaterialIcon("cmd_math_integral", '\ue900')
        @JvmField
        val cmd_math_log = CommunityMaterialIcon("cmd_math_log", '\ue900')
        @JvmField
        val cmd_math_norm_box = CommunityMaterialIcon("cmd_math_norm_box", '\ue900')
        @JvmField
        val cmd_math_norm = CommunityMaterialIcon("cmd_math_norm", '\ue900')
        @JvmField
        val cmd_math_sin = CommunityMaterialIcon("cmd_math_sin", '\ue900')
        @JvmField
        val cmd_math_tan = CommunityMaterialIcon("cmd_math_tan", '\ue900')
        @JvmField
        val cmd_matrix = CommunityMaterialIcon("cmd_matrix", '\ue900')
        @JvmField
        val cmd_medal = CommunityMaterialIcon("cmd_medal", '\ue900')
        @JvmField
        val cmd_medical_bag = CommunityMaterialIcon("cmd_medical_bag", '\ue900')
        @JvmField
        val cmd_meditation = CommunityMaterialIcon("cmd_meditation", '\ue900')
        @JvmField
        val cmd_medium = CommunityMaterialIcon("cmd_medium", '\ue900')
        @JvmField
        val cmd_meetup = CommunityMaterialIcon("cmd_meetup", '\ue900')
        @JvmField
        val cmd_memory = CommunityMaterialIcon("cmd_memory", '\ue900')
        @JvmField
        val cmd_menu_down_outline = CommunityMaterialIcon("cmd_menu_down_outline", '\ue900')
        @JvmField
        val cmd_menu_down = CommunityMaterialIcon("cmd_menu_down", '\ue900')
        @JvmField
        val cmd_menu_left_outline = CommunityMaterialIcon("cmd_menu_left_outline", '\ue900')
        @JvmField
        val cmd_menu_left = CommunityMaterialIcon("cmd_menu_left", '\ue900')
        @JvmField
        val cmd_menu_open = CommunityMaterialIcon("cmd_menu_open", '\ue900')
        @JvmField
        val cmd_menu_right_outline = CommunityMaterialIcon("cmd_menu_right_outline", '\ue900')
        @JvmField
        val cmd_menu_right = CommunityMaterialIcon("cmd_menu_right", '\ue900')
        @JvmField
        val cmd_menu_swap_outline = CommunityMaterialIcon("cmd_menu_swap_outline", '\ue900')
        @JvmField
        val cmd_menu_swap = CommunityMaterialIcon("cmd_menu_swap", '\ue900')
        @JvmField
        val cmd_menu_up_outline = CommunityMaterialIcon("cmd_menu_up_outline", '\ue900')
        @JvmField
        val cmd_menu_up = CommunityMaterialIcon("cmd_menu_up", '\ue900')
        @JvmField
        val cmd_menu = CommunityMaterialIcon("cmd_menu", '\ue900')
        @JvmField
        val cmd_merge = CommunityMaterialIcon("cmd_merge", '\ue900')
        @JvmField
        val cmd_message_alert_outline = CommunityMaterialIcon("cmd_message_alert_outline", '\ue900')
        @JvmField
        val cmd_message_alert = CommunityMaterialIcon("cmd_message_alert", '\ue900')
        @JvmField
        val cmd_message_bulleted_off = CommunityMaterialIcon("cmd_message_bulleted_off", '\ue900')
        @JvmField
        val cmd_message_bulleted = CommunityMaterialIcon("cmd_message_bulleted", '\ue900')
        @JvmField
        val cmd_message_draw = CommunityMaterialIcon("cmd_message_draw", '\ue900')
        @JvmField
        val cmd_message_image_outline = CommunityMaterialIcon("cmd_message_image_outline", '\ue900')
        @JvmField
        val cmd_message_image = CommunityMaterialIcon("cmd_message_image", '\ue900')
        @JvmField
        val cmd_message_lock_outline = CommunityMaterialIcon("cmd_message_lock_outline", '\ue900')
        @JvmField
        val cmd_message_lock = CommunityMaterialIcon("cmd_message_lock", '\ue900')
        @JvmField
        val cmd_message_minus_outline = CommunityMaterialIcon("cmd_message_minus_outline", '\ue900')
        @JvmField
        val cmd_message_minus = CommunityMaterialIcon("cmd_message_minus", '\ue900')
        @JvmField
        val cmd_message_outline = CommunityMaterialIcon("cmd_message_outline", '\ue900')
        @JvmField
        val cmd_message_plus_outline = CommunityMaterialIcon("cmd_message_plus_outline", '\ue900')
        @JvmField
        val cmd_message_plus = CommunityMaterialIcon("cmd_message_plus", '\ue900')
        @JvmField
        val cmd_message_processing_outline = CommunityMaterialIcon("cmd_message_processing_outline", '\ue900')
        @JvmField
        val cmd_message_processing = CommunityMaterialIcon("cmd_message_processing", '\ue900')
        @JvmField
        val cmd_message_reply_text = CommunityMaterialIcon("cmd_message_reply_text", '\ue900')
        @JvmField
        val cmd_message_reply = CommunityMaterialIcon("cmd_message_reply", '\ue900')
        @JvmField
        val cmd_message_settings_outline = CommunityMaterialIcon("cmd_message_settings_outline", '\ue900')
        @JvmField
        val cmd_message_settings_variant_outline = CommunityMaterialIcon("cmd_message_settings_variant_outline", '\ue900')
        @JvmField
        val cmd_message_settings_variant = CommunityMaterialIcon("cmd_message_settings_variant", '\ue900')
        @JvmField
        val cmd_message_settings = CommunityMaterialIcon("cmd_message_settings", '\ue900')
        @JvmField
        val cmd_message_text_clock_outline = CommunityMaterialIcon("cmd_message_text_clock_outline", '\ue900')
        @JvmField
        val cmd_message_text_clock = CommunityMaterialIcon("cmd_message_text_clock", '\ue900')
        @JvmField
        val cmd_message_text_lock_outline = CommunityMaterialIcon("cmd_message_text_lock_outline", '\ue900')
        @JvmField
        val cmd_message_text_lock = CommunityMaterialIcon("cmd_message_text_lock", '\ue900')
        @JvmField
        val cmd_message_text_outline = CommunityMaterialIcon("cmd_message_text_outline", '\ue900')
        @JvmField
        val cmd_message_text = CommunityMaterialIcon("cmd_message_text", '\ue900')
        @JvmField
        val cmd_message_video = CommunityMaterialIcon("cmd_message_video", '\ue900')
        @JvmField
        val cmd_message = CommunityMaterialIcon("cmd_message", '\ue900')
        @JvmField
        val cmd_meteor = CommunityMaterialIcon("cmd_meteor", '\ue900')
        @JvmField
        val cmd_metronome_tick = CommunityMaterialIcon("cmd_metronome_tick", '\ue900')
        @JvmField
        val cmd_metronome = CommunityMaterialIcon("cmd_metronome", '\ue900')
        @JvmField
        val cmd_micro_sd = CommunityMaterialIcon("cmd_micro_sd", '\ue900')
        @JvmField
        val cmd_microphone_minus = CommunityMaterialIcon("cmd_microphone_minus", '\ue900')
        @JvmField
        val cmd_microphone_off = CommunityMaterialIcon("cmd_microphone_off", '\ue900')
        @JvmField
        val cmd_microphone_outline = CommunityMaterialIcon("cmd_microphone_outline", '\ue900')
        @JvmField
        val cmd_microphone_plus = CommunityMaterialIcon("cmd_microphone_plus", '\ue900')
        @JvmField
        val cmd_microphone_settings = CommunityMaterialIcon("cmd_microphone_settings", '\ue900')
        @JvmField
        val cmd_microphone_variant_off = CommunityMaterialIcon("cmd_microphone_variant_off", '\ue900')
        @JvmField
        val cmd_microphone_variant = CommunityMaterialIcon("cmd_microphone_variant", '\ue900')
        @JvmField
        val cmd_microphone = CommunityMaterialIcon("cmd_microphone", '\ue900')
        @JvmField
        val cmd_microscope = CommunityMaterialIcon("cmd_microscope", '\ue900')
        @JvmField
        val cmd_microsoft_dynamics = CommunityMaterialIcon("cmd_microsoft_dynamics", '\ue900')
        @JvmField
        val cmd_microsoft = CommunityMaterialIcon("cmd_microsoft", '\ue900')
        @JvmField
        val cmd_microwave = CommunityMaterialIcon("cmd_microwave", '\ue900')
        @JvmField
        val cmd_middleware_outline = CommunityMaterialIcon("cmd_middleware_outline", '\ue900')
        @JvmField
        val cmd_middleware = CommunityMaterialIcon("cmd_middleware", '\ue900')
        @JvmField
        val cmd_midi_port = CommunityMaterialIcon("cmd_midi_port", '\ue900')
        @JvmField
        val cmd_midi = CommunityMaterialIcon("cmd_midi", '\ue900')
        @JvmField
        val cmd_mine = CommunityMaterialIcon("cmd_mine", '\ue900')
        @JvmField
        val cmd_minecraft = CommunityMaterialIcon("cmd_minecraft", '\ue900')
        @JvmField
        val cmd_mini_sd = CommunityMaterialIcon("cmd_mini_sd", '\ue900')
        @JvmField
        val cmd_minidisc = CommunityMaterialIcon("cmd_minidisc", '\ue900')
        @JvmField
        val cmd_minus_box_multiple_outline = CommunityMaterialIcon("cmd_minus_box_multiple_outline", '\ue900')
        @JvmField
        val cmd_minus_box_multiple = CommunityMaterialIcon("cmd_minus_box_multiple", '\ue900')
        @JvmField
        val cmd_minus_box_outline = CommunityMaterialIcon("cmd_minus_box_outline", '\ue900')
        @JvmField
        val cmd_minus_box = CommunityMaterialIcon("cmd_minus_box", '\ue900')
        @JvmField
        val cmd_minus_circle_outline = CommunityMaterialIcon("cmd_minus_circle_outline", '\ue900')
        @JvmField
        val cmd_minus_circle = CommunityMaterialIcon("cmd_minus_circle", '\ue900')
        @JvmField
        val cmd_minus_network_outline = CommunityMaterialIcon("cmd_minus_network_outline", '\ue900')
        @JvmField
        val cmd_minus_network = CommunityMaterialIcon("cmd_minus_network", '\ue900')
        @JvmField
        val cmd_minus = CommunityMaterialIcon("cmd_minus", '\ue900')
        @JvmField
        val cmd_mirror = CommunityMaterialIcon("cmd_mirror", '\ue900')
        @JvmField
        val cmd_mixcloud = CommunityMaterialIcon("cmd_mixcloud", '\ue900')
        @JvmField
        val cmd_mixed_martial_arts = CommunityMaterialIcon("cmd_mixed_martial_arts", '\ue900')
        @JvmField
        val cmd_mixed_reality = CommunityMaterialIcon("cmd_mixed_reality", '\ue900')
        @JvmField
        val cmd_mixer = CommunityMaterialIcon("cmd_mixer", '\ue900')
        @JvmField
        val cmd_molecule = CommunityMaterialIcon("cmd_molecule", '\ue900')
        @JvmField
        val cmd_monitor_cellphone_star = CommunityMaterialIcon("cmd_monitor_cellphone_star", '\ue900')
        @JvmField
        val cmd_monitor_cellphone = CommunityMaterialIcon("cmd_monitor_cellphone", '\ue900')
        @JvmField
        val cmd_monitor_clean = CommunityMaterialIcon("cmd_monitor_clean", '\ue900')
        @JvmField
        val cmd_monitor_dashboard = CommunityMaterialIcon("cmd_monitor_dashboard", '\ue900')
        @JvmField
        val cmd_monitor_edit = CommunityMaterialIcon("cmd_monitor_edit", '\ue900')
        @JvmField
        val cmd_monitor_lock = CommunityMaterialIcon("cmd_monitor_lock", '\ue900')
        @JvmField
        val cmd_monitor_multiple = CommunityMaterialIcon("cmd_monitor_multiple", '\ue900')
        @JvmField
        val cmd_monitor_off = CommunityMaterialIcon("cmd_monitor_off", '\ue900')
        @JvmField
        val cmd_monitor_screenshot = CommunityMaterialIcon("cmd_monitor_screenshot", '\ue900')
        @JvmField
        val cmd_monitor_speaker_off = CommunityMaterialIcon("cmd_monitor_speaker_off", '\ue900')
        @JvmField
        val cmd_monitor_speaker = CommunityMaterialIcon("cmd_monitor_speaker", '\ue900')
        @JvmField
        val cmd_monitor_star = CommunityMaterialIcon("cmd_monitor_star", '\ue900')
        @JvmField
        val cmd_monitor = CommunityMaterialIcon("cmd_monitor", '\ue900')
        @JvmField
        val cmd_moon_first_quarter = CommunityMaterialIcon("cmd_moon_first_quarter", '\ue900')
        @JvmField
        val cmd_moon_full = CommunityMaterialIcon("cmd_moon_full", '\ue900')
        @JvmField
        val cmd_moon_last_quarter = CommunityMaterialIcon("cmd_moon_last_quarter", '\ue900')
        @JvmField
        val cmd_moon_new = CommunityMaterialIcon("cmd_moon_new", '\ue900')
        @JvmField
        val cmd_moon_waning_crescent = CommunityMaterialIcon("cmd_moon_waning_crescent", '\ue900')
        @JvmField
        val cmd_moon_waning_gibbous = CommunityMaterialIcon("cmd_moon_waning_gibbous", '\ue900')
        @JvmField
        val cmd_moon_waxing_crescent = CommunityMaterialIcon("cmd_moon_waxing_crescent", '\ue900')
        @JvmField
        val cmd_moon_waxing_gibbous = CommunityMaterialIcon("cmd_moon_waxing_gibbous", '\ue900')
        @JvmField
        val cmd_moped = CommunityMaterialIcon("cmd_moped", '\ue900')
        @JvmField
        val cmd_more = CommunityMaterialIcon("cmd_more", '\ue900')
        @JvmField
        val cmd_mother_nurse = CommunityMaterialIcon("cmd_mother_nurse", '\ue900')
        @JvmField
        val cmd_motion_sensor = CommunityMaterialIcon("cmd_motion_sensor", '\ue900')
        @JvmField
        val cmd_motorbike = CommunityMaterialIcon("cmd_motorbike", '\ue900')
        @JvmField
        val cmd_mouse_bluetooth = CommunityMaterialIcon("cmd_mouse_bluetooth", '\ue900')
        @JvmField
        val cmd_mouse_off = CommunityMaterialIcon("cmd_mouse_off", '\ue900')
        @JvmField
        val cmd_mouse_variant_off = CommunityMaterialIcon("cmd_mouse_variant_off", '\ue900')
        @JvmField
        val cmd_mouse_variant = CommunityMaterialIcon("cmd_mouse_variant", '\ue900')
        @JvmField
        val cmd_mouse = CommunityMaterialIcon("cmd_mouse", '\ue900')
        @JvmField
        val cmd_move_resize_variant = CommunityMaterialIcon("cmd_move_resize_variant", '\ue900')
        @JvmField
        val cmd_move_resize = CommunityMaterialIcon("cmd_move_resize", '\ue900')
        @JvmField
        val cmd_movie_edit_outline = CommunityMaterialIcon("cmd_movie_edit_outline", '\ue900')
        @JvmField
        val cmd_movie_edit = CommunityMaterialIcon("cmd_movie_edit", '\ue900')
        @JvmField
        val cmd_movie_filter_outline = CommunityMaterialIcon("cmd_movie_filter_outline", '\ue900')
        @JvmField
        val cmd_movie_filter = CommunityMaterialIcon("cmd_movie_filter", '\ue900')
        @JvmField
        val cmd_movie_open_outline = CommunityMaterialIcon("cmd_movie_open_outline", '\ue900')
        @JvmField
        val cmd_movie_open = CommunityMaterialIcon("cmd_movie_open", '\ue900')
        @JvmField
        val cmd_movie_outline = CommunityMaterialIcon("cmd_movie_outline", '\ue900')
        @JvmField
        val cmd_movie_roll = CommunityMaterialIcon("cmd_movie_roll", '\ue900')
        @JvmField
        val cmd_movie_search_outline = CommunityMaterialIcon("cmd_movie_search_outline", '\ue900')
        @JvmField
        val cmd_movie_search = CommunityMaterialIcon("cmd_movie_search", '\ue900')
        @JvmField
        val cmd_movie = CommunityMaterialIcon("cmd_movie", '\ue900')
        @JvmField
        val cmd_muffin = CommunityMaterialIcon("cmd_muffin", '\ue900')
        @JvmField
        val cmd_multiplication_box = CommunityMaterialIcon("cmd_multiplication_box", '\ue900')
        @JvmField
        val cmd_multiplication = CommunityMaterialIcon("cmd_multiplication", '\ue900')
        @JvmField
        val cmd_mushroom_outline = CommunityMaterialIcon("cmd_mushroom_outline", '\ue900')
        @JvmField
        val cmd_mushroom = CommunityMaterialIcon("cmd_mushroom", '\ue900')
        @JvmField
        val cmd_music_accidental_double_flat = CommunityMaterialIcon("cmd_music_accidental_double_flat", '\ue900')
        @JvmField
        val cmd_music_accidental_double_sharp = CommunityMaterialIcon("cmd_music_accidental_double_sharp", '\ue900')
        @JvmField
        val cmd_music_accidental_flat = CommunityMaterialIcon("cmd_music_accidental_flat", '\ue900')
        @JvmField
        val cmd_music_accidental_natural = CommunityMaterialIcon("cmd_music_accidental_natural", '\ue900')
        @JvmField
        val cmd_music_accidental_sharp = CommunityMaterialIcon("cmd_music_accidental_sharp", '\ue900')
        @JvmField
        val cmd_music_box_outline = CommunityMaterialIcon("cmd_music_box_outline", '\ue900')
        @JvmField
        val cmd_music_box = CommunityMaterialIcon("cmd_music_box", '\ue900')
        @JvmField
        val cmd_music_circle_outline = CommunityMaterialIcon("cmd_music_circle_outline", '\ue900')
        @JvmField
        val cmd_music_circle = CommunityMaterialIcon("cmd_music_circle", '\ue900')
        @JvmField
        val cmd_music_clef_alto = CommunityMaterialIcon("cmd_music_clef_alto", '\ue900')
        @JvmField
        val cmd_music_clef_bass = CommunityMaterialIcon("cmd_music_clef_bass", '\ue900')
        @JvmField
        val cmd_music_clef_treble = CommunityMaterialIcon("cmd_music_clef_treble", '\ue900')
        @JvmField
        val cmd_music_note_bluetooth_off = CommunityMaterialIcon("cmd_music_note_bluetooth_off", '\ue900')
        @JvmField
        val cmd_music_note_bluetooth = CommunityMaterialIcon("cmd_music_note_bluetooth", '\ue900')
        @JvmField
        val cmd_music_note_eighth_dotted = CommunityMaterialIcon("cmd_music_note_eighth_dotted", '\ue900')
        @JvmField
        val cmd_music_note_eighth = CommunityMaterialIcon("cmd_music_note_eighth", '\ue900')
        @JvmField
        val cmd_music_note_half_dotted = CommunityMaterialIcon("cmd_music_note_half_dotted", '\ue900')
        @JvmField
        val cmd_music_note_half = CommunityMaterialIcon("cmd_music_note_half", '\ue900')
        @JvmField
        val cmd_music_note_off_outline = CommunityMaterialIcon("cmd_music_note_off_outline", '\ue900')
        @JvmField
        val cmd_music_note_off = CommunityMaterialIcon("cmd_music_note_off", '\ue900')
        @JvmField
        val cmd_music_note_outline = CommunityMaterialIcon("cmd_music_note_outline", '\ue900')
        @JvmField
        val cmd_music_note_plus = CommunityMaterialIcon("cmd_music_note_plus", '\ue900')
        @JvmField
        val cmd_music_note_quarter_dotted = CommunityMaterialIcon("cmd_music_note_quarter_dotted", '\ue900')
        @JvmField
        val cmd_music_note_quarter = CommunityMaterialIcon("cmd_music_note_quarter", '\ue900')
        @JvmField
        val cmd_music_note_sixteenth_dotted = CommunityMaterialIcon("cmd_music_note_sixteenth_dotted", '\ue900')
        @JvmField
        val cmd_music_note_sixteenth = CommunityMaterialIcon("cmd_music_note_sixteenth", '\ue900')
        @JvmField
        val cmd_music_note_whole_dotted = CommunityMaterialIcon("cmd_music_note_whole_dotted", '\ue900')
        @JvmField
        val cmd_music_note_whole = CommunityMaterialIcon("cmd_music_note_whole", '\ue900')
        @JvmField
        val cmd_music_note = CommunityMaterialIcon("cmd_music_note", '\ue900')
        @JvmField
        val cmd_music_off = CommunityMaterialIcon("cmd_music_off", '\ue900')
        @JvmField
        val cmd_music_rest_eighth = CommunityMaterialIcon("cmd_music_rest_eighth", '\ue900')
        @JvmField
        val cmd_music_rest_half = CommunityMaterialIcon("cmd_music_rest_half", '\ue900')
        @JvmField
        val cmd_music_rest_quarter = CommunityMaterialIcon("cmd_music_rest_quarter", '\ue900')
        @JvmField
        val cmd_music_rest_sixteenth = CommunityMaterialIcon("cmd_music_rest_sixteenth", '\ue900')
        @JvmField
        val cmd_music_rest_whole = CommunityMaterialIcon("cmd_music_rest_whole", '\ue900')
        @JvmField
        val cmd_music = CommunityMaterialIcon("cmd_music", '\ue900')
        @JvmField
        val cmd_nail = CommunityMaterialIcon("cmd_nail", '\ue900')
        @JvmField
        val cmd_nas = CommunityMaterialIcon("cmd_nas", '\ue900')
        @JvmField
        val cmd_nativescript = CommunityMaterialIcon("cmd_nativescript", '\ue900')
        @JvmField
        val cmd_nature_people = CommunityMaterialIcon("cmd_nature_people", '\ue900')
        @JvmField
        val cmd_nature = CommunityMaterialIcon("cmd_nature", '\ue900')
        @JvmField
        val cmd_navigation = CommunityMaterialIcon("cmd_navigation", '\ue900')
        @JvmField
        val cmd_near_me = CommunityMaterialIcon("cmd_near_me", '\ue900')
        @JvmField
        val cmd_necklace = CommunityMaterialIcon("cmd_necklace", '\ue900')
        @JvmField
        val cmd_needle = CommunityMaterialIcon("cmd_needle", '\ue900')
        @JvmField
        val cmd_netflix = CommunityMaterialIcon("cmd_netflix", '\ue900')
        @JvmField
        val cmd_network_off_outline = CommunityMaterialIcon("cmd_network_off_outline", '\ue900')
        @JvmField
        val cmd_network_off = CommunityMaterialIcon("cmd_network_off", '\ue900')
        @JvmField
        val cmd_network_outline = CommunityMaterialIcon("cmd_network_outline", '\ue900')
        @JvmField
        val cmd_network_router = CommunityMaterialIcon("cmd_network_router", '\ue900')
        @JvmField
        val cmd_network_strength_1_alert = CommunityMaterialIcon("cmd_network_strength_1_alert", '\ue900')
        @JvmField
        val cmd_network_strength_1 = CommunityMaterialIcon("cmd_network_strength_1", '\ue900')
        @JvmField
        val cmd_network_strength_2_alert = CommunityMaterialIcon("cmd_network_strength_2_alert", '\ue900')
        @JvmField
        val cmd_network_strength_2 = CommunityMaterialIcon("cmd_network_strength_2", '\ue900')
        @JvmField
        val cmd_network_strength_3_alert = CommunityMaterialIcon("cmd_network_strength_3_alert", '\ue900')
        @JvmField
        val cmd_network_strength_3 = CommunityMaterialIcon("cmd_network_strength_3", '\ue900')
        @JvmField
        val cmd_network_strength_4_alert = CommunityMaterialIcon("cmd_network_strength_4_alert", '\ue900')
        @JvmField
        val cmd_network_strength_4 = CommunityMaterialIcon("cmd_network_strength_4", '\ue900')
        @JvmField
        val cmd_network_strength_off_outline = CommunityMaterialIcon("cmd_network_strength_off_outline", '\ue900')
        @JvmField
        val cmd_network_strength_off = CommunityMaterialIcon("cmd_network_strength_off", '\ue900')
        @JvmField
        val cmd_network_strength_outline = CommunityMaterialIcon("cmd_network_strength_outline", '\ue900')
        @JvmField
        val cmd_network = CommunityMaterialIcon("cmd_network", '\ue900')
        @JvmField
        val cmd_new_box = CommunityMaterialIcon("cmd_new_box", '\ue900')
        @JvmField
        val cmd_newspaper_minus = CommunityMaterialIcon("cmd_newspaper_minus", '\ue900')
        @JvmField
        val cmd_newspaper_plus = CommunityMaterialIcon("cmd_newspaper_plus", '\ue900')
        @JvmField
        val cmd_newspaper_variant_multiple_outline = CommunityMaterialIcon("cmd_newspaper_variant_multiple_outline", '\ue900')
        @JvmField
        val cmd_newspaper_variant_multiple = CommunityMaterialIcon("cmd_newspaper_variant_multiple", '\ue900')
        @JvmField
        val cmd_newspaper_variant_outline = CommunityMaterialIcon("cmd_newspaper_variant_outline", '\ue900')
        @JvmField
        val cmd_newspaper_variant = CommunityMaterialIcon("cmd_newspaper_variant", '\ue900')
        @JvmField
        val cmd_newspaper = CommunityMaterialIcon("cmd_newspaper", '\ue900')
        @JvmField
        val cmd_nfc_off = CommunityMaterialIcon("cmd_nfc_off", '\ue900')
        @JvmField
        val cmd_nfc_search_variant = CommunityMaterialIcon("cmd_nfc_search_variant", '\ue900')
        @JvmField
        val cmd_nfc_tap = CommunityMaterialIcon("cmd_nfc_tap", '\ue900')
        @JvmField
        val cmd_nfc_variant_off = CommunityMaterialIcon("cmd_nfc_variant_off", '\ue900')
        @JvmField
        val cmd_nfc_variant = CommunityMaterialIcon("cmd_nfc_variant", '\ue900')
        @JvmField
        val cmd_nfc = CommunityMaterialIcon("cmd_nfc", '\ue900')
        @JvmField
        val cmd_ninja = CommunityMaterialIcon("cmd_ninja", '\ue900')
        @JvmField
        val cmd_nintendo_switch = CommunityMaterialIcon("cmd_nintendo_switch", '\ue900')
        @JvmField
        val cmd_nix = CommunityMaterialIcon("cmd_nix", '\ue900')
        @JvmField
        val cmd_nodejs = CommunityMaterialIcon("cmd_nodejs", '\ue900')
        @JvmField
        val cmd_noodles = CommunityMaterialIcon("cmd_noodles", '\ue900')
        @JvmField
        val cmd_not_equal_variant = CommunityMaterialIcon("cmd_not_equal_variant", '\ue900')
        @JvmField
        val cmd_not_equal = CommunityMaterialIcon("cmd_not_equal", '\ue900')
        @JvmField
        val cmd_note_multiple_outline = CommunityMaterialIcon("cmd_note_multiple_outline", '\ue900')
        @JvmField
        val cmd_note_multiple = CommunityMaterialIcon("cmd_note_multiple", '\ue900')
        @JvmField
        val cmd_note_outline = CommunityMaterialIcon("cmd_note_outline", '\ue900')
        @JvmField
        val cmd_note_plus_outline = CommunityMaterialIcon("cmd_note_plus_outline", '\ue900')
        @JvmField
        val cmd_note_plus = CommunityMaterialIcon("cmd_note_plus", '\ue900')
        @JvmField
        val cmd_note_text_outline = CommunityMaterialIcon("cmd_note_text_outline", '\ue900')
        @JvmField
        val cmd_note_text = CommunityMaterialIcon("cmd_note_text", '\ue900')
        @JvmField
        val cmd_note = CommunityMaterialIcon("cmd_note", '\ue900')
        @JvmField
        val cmd_notebook_multiple = CommunityMaterialIcon("cmd_notebook_multiple", '\ue900')
        @JvmField
        val cmd_notebook_outline = CommunityMaterialIcon("cmd_notebook_outline", '\ue900')
        @JvmField
        val cmd_notebook = CommunityMaterialIcon("cmd_notebook", '\ue900')
        @JvmField
        val cmd_notification_clear_all = CommunityMaterialIcon("cmd_notification_clear_all", '\ue900')
        @JvmField
        val cmd_npm_variant_outline = CommunityMaterialIcon("cmd_npm_variant_outline", '\ue900')
        @JvmField
        val cmd_npm_variant = CommunityMaterialIcon("cmd_npm_variant", '\ue900')
        @JvmField
        val cmd_npm = CommunityMaterialIcon("cmd_npm", '\ue900')
        @JvmField
        val cmd_nuke = CommunityMaterialIcon("cmd_nuke", '\ue900')
        @JvmField
        val cmd_null = CommunityMaterialIcon("cmd_null", '\ue900')
        @JvmField
        val cmd_numeric_0_box_multiple_outline = CommunityMaterialIcon("cmd_numeric_0_box_multiple_outline", '\ue900')
        @JvmField
        val cmd_numeric_0_box_multiple = CommunityMaterialIcon("cmd_numeric_0_box_multiple", '\ue900')
        @JvmField
        val cmd_numeric_0_box_outline = CommunityMaterialIcon("cmd_numeric_0_box_outline", '\ue900')
        @JvmField
        val cmd_numeric_0_box = CommunityMaterialIcon("cmd_numeric_0_box", '\ue900')
        @JvmField
        val cmd_numeric_0_circle_outline = CommunityMaterialIcon("cmd_numeric_0_circle_outline", '\ue900')
        @JvmField
        val cmd_numeric_0_circle = CommunityMaterialIcon("cmd_numeric_0_circle", '\ue900')
        @JvmField
        val cmd_numeric_0 = CommunityMaterialIcon("cmd_numeric_0", '\ue900')
        @JvmField
        val cmd_numeric_1_box_multiple_outline = CommunityMaterialIcon("cmd_numeric_1_box_multiple_outline", '\ue900')
        @JvmField
        val cmd_numeric_1_box_multiple = CommunityMaterialIcon("cmd_numeric_1_box_multiple", '\ue900')
        @JvmField
        val cmd_numeric_1_box_outline = CommunityMaterialIcon("cmd_numeric_1_box_outline", '\ue900')
        @JvmField
        val cmd_numeric_1_box = CommunityMaterialIcon("cmd_numeric_1_box", '\ue900')
        @JvmField
        val cmd_numeric_1_circle_outline = CommunityMaterialIcon("cmd_numeric_1_circle_outline", '\ue900')
        @JvmField
        val cmd_numeric_1_circle = CommunityMaterialIcon("cmd_numeric_1_circle", '\ue900')
        @JvmField
        val cmd_numeric_1 = CommunityMaterialIcon("cmd_numeric_1", '\ue900')
        @JvmField
        val cmd_numeric_2_box_multiple_outline = CommunityMaterialIcon("cmd_numeric_2_box_multiple_outline", '\ue900')
        @JvmField
        val cmd_numeric_2_box_multiple = CommunityMaterialIcon("cmd_numeric_2_box_multiple", '\ue900')
        @JvmField
        val cmd_numeric_2_box_outline = CommunityMaterialIcon("cmd_numeric_2_box_outline", '\ue900')
        @JvmField
        val cmd_numeric_2_box = CommunityMaterialIcon("cmd_numeric_2_box", '\ue900')
        @JvmField
        val cmd_numeric_2_circle_outline = CommunityMaterialIcon("cmd_numeric_2_circle_outline", '\ue900')
        @JvmField
        val cmd_numeric_2_circle = CommunityMaterialIcon("cmd_numeric_2_circle", '\ue900')
        @JvmField
        val cmd_numeric_2 = CommunityMaterialIcon("cmd_numeric_2", '\ue900')
        @JvmField
        val cmd_numeric_3_box_multiple_outline = CommunityMaterialIcon("cmd_numeric_3_box_multiple_outline", '\ue900')
        @JvmField
        val cmd_numeric_3_box_multiple = CommunityMaterialIcon("cmd_numeric_3_box_multiple", '\ue900')
        @JvmField
        val cmd_numeric_3_box_outline = CommunityMaterialIcon("cmd_numeric_3_box_outline", '\ue900')
        @JvmField
        val cmd_numeric_3_box = CommunityMaterialIcon("cmd_numeric_3_box", '\ue900')
        @JvmField
        val cmd_numeric_3_circle_outline = CommunityMaterialIcon("cmd_numeric_3_circle_outline", '\ue900')
        @JvmField
        val cmd_numeric_3_circle = CommunityMaterialIcon("cmd_numeric_3_circle", '\ue900')
        @JvmField
        val cmd_numeric_3 = CommunityMaterialIcon("cmd_numeric_3", '\ue900')
        @JvmField
        val cmd_numeric_4_box_multiple_outline = CommunityMaterialIcon("cmd_numeric_4_box_multiple_outline", '\ue900')
        @JvmField
        val cmd_numeric_4_box_multiple = CommunityMaterialIcon("cmd_numeric_4_box_multiple", '\ue900')
        @JvmField
        val cmd_numeric_4_box_outline = CommunityMaterialIcon("cmd_numeric_4_box_outline", '\ue900')
        @JvmField
        val cmd_numeric_4_box = CommunityMaterialIcon("cmd_numeric_4_box", '\ue900')
        @JvmField
        val cmd_numeric_4_circle_outline = CommunityMaterialIcon("cmd_numeric_4_circle_outline", '\ue900')
        @JvmField
        val cmd_numeric_4_circle = CommunityMaterialIcon("cmd_numeric_4_circle", '\ue900')
        @JvmField
        val cmd_numeric_4 = CommunityMaterialIcon("cmd_numeric_4", '\ue900')
        @JvmField
        val cmd_numeric_5_box_multiple_outline = CommunityMaterialIcon("cmd_numeric_5_box_multiple_outline", '\ue900')
        @JvmField
        val cmd_numeric_5_box_multiple = CommunityMaterialIcon("cmd_numeric_5_box_multiple", '\ue900')
        @JvmField
        val cmd_numeric_5_box_outline = CommunityMaterialIcon("cmd_numeric_5_box_outline", '\ue900')
        @JvmField
        val cmd_numeric_5_box = CommunityMaterialIcon("cmd_numeric_5_box", '\ue900')
        @JvmField
        val cmd_numeric_5_circle_outline = CommunityMaterialIcon("cmd_numeric_5_circle_outline", '\ue900')
        @JvmField
        val cmd_numeric_5_circle = CommunityMaterialIcon("cmd_numeric_5_circle", '\ue900')
        @JvmField
        val cmd_numeric_5 = CommunityMaterialIcon("cmd_numeric_5", '\ue900')
        @JvmField
        val cmd_numeric_6_box_multiple_outline = CommunityMaterialIcon("cmd_numeric_6_box_multiple_outline", '\ue900')
        @JvmField
        val cmd_numeric_6_box_multiple = CommunityMaterialIcon("cmd_numeric_6_box_multiple", '\ue900')
        @JvmField
        val cmd_numeric_6_box_outline = CommunityMaterialIcon("cmd_numeric_6_box_outline", '\ue900')
        @JvmField
        val cmd_numeric_6_box = CommunityMaterialIcon("cmd_numeric_6_box", '\ue900')
        @JvmField
        val cmd_numeric_6_circle_outline = CommunityMaterialIcon("cmd_numeric_6_circle_outline", '\ue900')
        @JvmField
        val cmd_numeric_6_circle = CommunityMaterialIcon("cmd_numeric_6_circle", '\ue900')
        @JvmField
        val cmd_numeric_6 = CommunityMaterialIcon("cmd_numeric_6", '\ue900')
        @JvmField
        val cmd_numeric_7_box_multiple_outline = CommunityMaterialIcon("cmd_numeric_7_box_multiple_outline", '\ue900')
        @JvmField
        val cmd_numeric_7_box_multiple = CommunityMaterialIcon("cmd_numeric_7_box_multiple", '\ue900')
        @JvmField
        val cmd_numeric_7_box_outline = CommunityMaterialIcon("cmd_numeric_7_box_outline", '\ue900')
        @JvmField
        val cmd_numeric_7_box = CommunityMaterialIcon("cmd_numeric_7_box", '\ue900')
        @JvmField
        val cmd_numeric_7_circle_outline = CommunityMaterialIcon("cmd_numeric_7_circle_outline", '\ue900')
        @JvmField
        val cmd_numeric_7_circle = CommunityMaterialIcon("cmd_numeric_7_circle", '\ue900')
        @JvmField
        val cmd_numeric_7 = CommunityMaterialIcon("cmd_numeric_7", '\ue900')
        @JvmField
        val cmd_numeric_8_box_multiple_outline = CommunityMaterialIcon("cmd_numeric_8_box_multiple_outline", '\ue900')
        @JvmField
        val cmd_numeric_8_box_multiple = CommunityMaterialIcon("cmd_numeric_8_box_multiple", '\ue900')
        @JvmField
        val cmd_numeric_8_box_outline = CommunityMaterialIcon("cmd_numeric_8_box_outline", '\ue900')
        @JvmField
        val cmd_numeric_8_box = CommunityMaterialIcon("cmd_numeric_8_box", '\ue900')
        @JvmField
        val cmd_numeric_8_circle_outline = CommunityMaterialIcon("cmd_numeric_8_circle_outline", '\ue900')
        @JvmField
        val cmd_numeric_8_circle = CommunityMaterialIcon("cmd_numeric_8_circle", '\ue900')
        @JvmField
        val cmd_numeric_8 = CommunityMaterialIcon("cmd_numeric_8", '\ue900')
        @JvmField
        val cmd_numeric_9_box_multiple_outline = CommunityMaterialIcon("cmd_numeric_9_box_multiple_outline", '\ue900')
        @JvmField
        val cmd_numeric_9_box_multiple = CommunityMaterialIcon("cmd_numeric_9_box_multiple", '\ue900')
        @JvmField
        val cmd_numeric_9_box_outline = CommunityMaterialIcon("cmd_numeric_9_box_outline", '\ue900')
        @JvmField
        val cmd_numeric_9_box = CommunityMaterialIcon("cmd_numeric_9_box", '\ue900')
        @JvmField
        val cmd_numeric_9_circle_outline = CommunityMaterialIcon("cmd_numeric_9_circle_outline", '\ue900')
        @JvmField
        val cmd_numeric_9_circle = CommunityMaterialIcon("cmd_numeric_9_circle", '\ue900')
        @JvmField
        val cmd_numeric_9_plus_box_multiple_outline =
                CommunityMaterialIcon("cmd_numeric_9_plus_box_multiple_outline", '\ue900')
        @JvmField
        val cmd_numeric_9_plus_box_multiple = CommunityMaterialIcon("cmd_numeric_9_plus_box_multiple", '\ue900')
        @JvmField
        val cmd_numeric_9_plus_box_outline = CommunityMaterialIcon("cmd_numeric_9_plus_box_outline", '\ue900')
        @JvmField
        val cmd_numeric_9_plus_box = CommunityMaterialIcon("cmd_numeric_9_plus_box", '\ue900')
        @JvmField
        val cmd_numeric_9_plus_circle_outline = CommunityMaterialIcon("cmd_numeric_9_plus_circle_outline", '\ue900')
        @JvmField
        val cmd_numeric_9_plus_circle = CommunityMaterialIcon("cmd_numeric_9_plus_circle", '\ue900')
        @JvmField
        val cmd_numeric_9_plus = CommunityMaterialIcon("cmd_numeric_9_plus", '\ue900')
        @JvmField
        val cmd_numeric_9 = CommunityMaterialIcon("cmd_numeric_9", '\ue900')
        @JvmField
        val cmd_numeric_10_box_multiple_outline = CommunityMaterialIcon("cmd_numeric_10_box_multiple_outline", '\ue900')
        @JvmField
        val cmd_numeric_10_box_multiple = CommunityMaterialIcon("cmd_numeric_10_box_multiple", '\ue900')
        @JvmField
        val cmd_numeric_10_box_outline = CommunityMaterialIcon("cmd_numeric_10_box_outline", '\ue900')
        @JvmField
        val cmd_numeric_10_box = CommunityMaterialIcon("cmd_numeric_10_box", '\ue900')
        @JvmField
        val cmd_numeric_10_circle_outline = CommunityMaterialIcon("cmd_numeric_10_circle_outline", '\ue900')
        @JvmField
        val cmd_numeric_10_circle = CommunityMaterialIcon("cmd_numeric_10_circle", '\ue900')
        @JvmField
        val cmd_numeric_10 = CommunityMaterialIcon("cmd_numeric_10", '\ue900')
        @JvmField
        val cmd_numeric_negative_1 = CommunityMaterialIcon("cmd_numeric_negative_1", '\ue900')
        @JvmField
        val cmd_numeric = CommunityMaterialIcon("cmd_numeric", '\ue900')
        @JvmField
        val cmd_nut = CommunityMaterialIcon("cmd_nut", '\ue900')
        @JvmField
        val cmd_nutrition = CommunityMaterialIcon("cmd_nutrition", '\ue900')
        @JvmField
        val cmd_nuxt = CommunityMaterialIcon("cmd_nuxt", '\ue900')
        @JvmField
        val cmd_oar = CommunityMaterialIcon("cmd_oar", '\ue900')
        @JvmField
        val cmd_ocarina = CommunityMaterialIcon("cmd_ocarina", '\ue900')
        @JvmField
        val cmd_ocr = CommunityMaterialIcon("cmd_ocr", '\ue900')
        @JvmField
        val cmd_octagon_outline = CommunityMaterialIcon("cmd_octagon_outline", '\ue900')
        @JvmField
        val cmd_octagon = CommunityMaterialIcon("cmd_octagon", '\ue900')
        @JvmField
        val cmd_octagram_outline = CommunityMaterialIcon("cmd_octagram_outline", '\ue900')
        @JvmField
        val cmd_octagram = CommunityMaterialIcon("cmd_octagram", '\ue900')
        @JvmField
        val cmd_odnoklassniki = CommunityMaterialIcon("cmd_odnoklassniki", '\ue900')
        @JvmField
        val cmd_offer = CommunityMaterialIcon("cmd_offer", '\ue900')
        @JvmField
        val cmd_office_building = CommunityMaterialIcon("cmd_office_building", '\ue900')
        @JvmField
        val cmd_office = CommunityMaterialIcon("cmd_office", '\ue900')
        @JvmField
        val cmd_oil_lamp = CommunityMaterialIcon("cmd_oil_lamp", '\ue900')
        @JvmField
        val cmd_oil_level = CommunityMaterialIcon("cmd_oil_level", '\ue900')
        @JvmField
        val cmd_oil_temperature = CommunityMaterialIcon("cmd_oil_temperature", '\ue900')
        @JvmField
        val cmd_oil = CommunityMaterialIcon("cmd_oil", '\ue900')
        @JvmField
        val cmd_omega = CommunityMaterialIcon("cmd_omega", '\ue900')
        @JvmField
        val cmd_one_up = CommunityMaterialIcon("cmd_one_up", '\ue900')
        @JvmField
        val cmd_onedrive = CommunityMaterialIcon("cmd_onedrive", '\ue900')
        @JvmField
        val cmd_onenote = CommunityMaterialIcon("cmd_onenote", '\ue900')
        @JvmField
        val cmd_onepassword = CommunityMaterialIcon("cmd_onepassword", '\ue900')
        @JvmField
        val cmd_opacity = CommunityMaterialIcon("cmd_opacity", '\ue900')
        @JvmField
        val cmd_open_in_app = CommunityMaterialIcon("cmd_open_in_app", '\ue900')
        @JvmField
        val cmd_open_in_new = CommunityMaterialIcon("cmd_open_in_new", '\ue900')
        @JvmField
        val cmd_open_source_initiative = CommunityMaterialIcon("cmd_open_source_initiative", '\ue900')
        @JvmField
        val cmd_openid = CommunityMaterialIcon("cmd_openid", '\ue900')
        @JvmField
        val cmd_opera = CommunityMaterialIcon("cmd_opera", '\ue900')
        @JvmField
        val cmd_orbit = CommunityMaterialIcon("cmd_orbit", '\ue900')
        @JvmField
        val cmd_origin = CommunityMaterialIcon("cmd_origin", '\ue900')
        @JvmField
        val cmd_ornament_variant = CommunityMaterialIcon("cmd_ornament_variant", '\ue900')
        @JvmField
        val cmd_ornament = CommunityMaterialIcon("cmd_ornament", '\ue900')
        @JvmField
        val cmd_outdoor_lamp = CommunityMaterialIcon("cmd_outdoor_lamp", '\ue900')
        @JvmField
        val cmd_outlook = CommunityMaterialIcon("cmd_outlook", '\ue900')
        @JvmField
        val cmd_overscan = CommunityMaterialIcon("cmd_overscan", '\ue900')
        @JvmField
        val cmd_owl = CommunityMaterialIcon("cmd_owl", '\ue900')
        @JvmField
        val cmd_pac_man = CommunityMaterialIcon("cmd_pac_man", '\ue900')
        @JvmField
        val cmd_package_down = CommunityMaterialIcon("cmd_package_down", '\ue900')
        @JvmField
        val cmd_package_up = CommunityMaterialIcon("cmd_package_up", '\ue900')
        @JvmField
        val cmd_package_variant_closed = CommunityMaterialIcon("cmd_package_variant_closed", '\ue900')
        @JvmField
        val cmd_package_variant = CommunityMaterialIcon("cmd_package_variant", '\ue900')
        @JvmField
        val cmd_package = CommunityMaterialIcon("cmd_package", '\ue900')
        @JvmField
        val cmd_page_first = CommunityMaterialIcon("cmd_page_first", '\ue900')
        @JvmField
        val cmd_page_last = CommunityMaterialIcon("cmd_page_last", '\ue900')
        @JvmField
        val cmd_page_layout_body = CommunityMaterialIcon("cmd_page_layout_body", '\ue900')
        @JvmField
        val cmd_page_layout_footer = CommunityMaterialIcon("cmd_page_layout_footer", '\ue900')
        @JvmField
        val cmd_page_layout_header_footer = CommunityMaterialIcon("cmd_page_layout_header_footer", '\ue900')
        @JvmField
        val cmd_page_layout_header = CommunityMaterialIcon("cmd_page_layout_header", '\ue900')
        @JvmField
        val cmd_page_layout_sidebar_left = CommunityMaterialIcon("cmd_page_layout_sidebar_left", '\ue900')
        @JvmField
        val cmd_page_layout_sidebar_right = CommunityMaterialIcon("cmd_page_layout_sidebar_right", '\ue900')
        @JvmField
        val cmd_page_next_outline = CommunityMaterialIcon("cmd_page_next_outline", '\ue900')
        @JvmField
        val cmd_page_next = CommunityMaterialIcon("cmd_page_next", '\ue900')
        @JvmField
        val cmd_page_previous_outline = CommunityMaterialIcon("cmd_page_previous_outline", '\ue900')
        @JvmField
        val cmd_page_previous = CommunityMaterialIcon("cmd_page_previous", '\ue900')
        @JvmField
        val cmd_palette_advanced = CommunityMaterialIcon("cmd_palette_advanced", '\ue900')
        @JvmField
        val cmd_palette_outline = CommunityMaterialIcon("cmd_palette_outline", '\ue900')
        @JvmField
        val cmd_palette_swatch = CommunityMaterialIcon("cmd_palette_swatch", '\ue900')
        @JvmField
        val cmd_palette = CommunityMaterialIcon("cmd_palette", '\ue900')
        @JvmField
        val cmd_palm_tree = CommunityMaterialIcon("cmd_palm_tree", '\ue900')
        @JvmField
        val cmd_pan_bottom_left = CommunityMaterialIcon("cmd_pan_bottom_left", '\ue900')
        @JvmField
        val cmd_pan_bottom_right = CommunityMaterialIcon("cmd_pan_bottom_right", '\ue900')
        @JvmField
        val cmd_pan_down = CommunityMaterialIcon("cmd_pan_down", '\ue900')
        @JvmField
        val cmd_pan_horizontal = CommunityMaterialIcon("cmd_pan_horizontal", '\ue900')
        @JvmField
        val cmd_pan_left = CommunityMaterialIcon("cmd_pan_left", '\ue900')
        @JvmField
        val cmd_pan_right = CommunityMaterialIcon("cmd_pan_right", '\ue900')
        @JvmField
        val cmd_pan_top_left = CommunityMaterialIcon("cmd_pan_top_left", '\ue900')
        @JvmField
        val cmd_pan_top_right = CommunityMaterialIcon("cmd_pan_top_right", '\ue900')
        @JvmField
        val cmd_pan_up = CommunityMaterialIcon("cmd_pan_up", '\ue900')
        @JvmField
        val cmd_pan_vertical = CommunityMaterialIcon("cmd_pan_vertical", '\ue900')
        @JvmField
        val cmd_pan = CommunityMaterialIcon("cmd_pan", '\ue900')
        @JvmField
        val cmd_panda = CommunityMaterialIcon("cmd_panda", '\ue900')
        @JvmField
        val cmd_pandora = CommunityMaterialIcon("cmd_pandora", '\ue900')
        @JvmField
        val cmd_panorama_fisheye = CommunityMaterialIcon("cmd_panorama_fisheye", '\ue900')
        @JvmField
        val cmd_panorama_horizontal = CommunityMaterialIcon("cmd_panorama_horizontal", '\ue900')
        @JvmField
        val cmd_panorama_vertical = CommunityMaterialIcon("cmd_panorama_vertical", '\ue900')
        @JvmField
        val cmd_panorama_wide_angle = CommunityMaterialIcon("cmd_panorama_wide_angle", '\ue900')
        @JvmField
        val cmd_panorama = CommunityMaterialIcon("cmd_panorama", '\ue900')
        @JvmField
        val cmd_paper_cut_vertical = CommunityMaterialIcon("cmd_paper_cut_vertical", '\ue900')
        @JvmField
        val cmd_paper_roll_outline = CommunityMaterialIcon("cmd_paper_roll_outline", '\ue900')
        @JvmField
        val cmd_paper_roll = CommunityMaterialIcon("cmd_paper_roll", '\ue900')
        @JvmField
        val cmd_paperclip = CommunityMaterialIcon("cmd_paperclip", '\ue900')
        @JvmField
        val cmd_parachute_outline = CommunityMaterialIcon("cmd_parachute_outline", '\ue900')
        @JvmField
        val cmd_parachute = CommunityMaterialIcon("cmd_parachute", '\ue900')
        @JvmField
        val cmd_parking = CommunityMaterialIcon("cmd_parking", '\ue900')
        @JvmField
        val cmd_party_popper = CommunityMaterialIcon("cmd_party_popper", '\ue900')
        @JvmField
        val cmd_passport_biometric = CommunityMaterialIcon("cmd_passport_biometric", '\ue900')
        @JvmField
        val cmd_passport = CommunityMaterialIcon("cmd_passport", '\ue900')
        @JvmField
        val cmd_pasta = CommunityMaterialIcon("cmd_pasta", '\ue900')
        @JvmField
        val cmd_patio_heater = CommunityMaterialIcon("cmd_patio_heater", '\ue900')
        @JvmField
        val cmd_patreon = CommunityMaterialIcon("cmd_patreon", '\ue900')
        @JvmField
        val cmd_pause_circle_outline = CommunityMaterialIcon("cmd_pause_circle_outline", '\ue900')
        @JvmField
        val cmd_pause_circle = CommunityMaterialIcon("cmd_pause_circle", '\ue900')
        @JvmField
        val cmd_pause_octagon_outline = CommunityMaterialIcon("cmd_pause_octagon_outline", '\ue900')
        @JvmField
        val cmd_pause_octagon = CommunityMaterialIcon("cmd_pause_octagon", '\ue900')
        @JvmField
        val cmd_pause = CommunityMaterialIcon("cmd_pause", '\ue900')
        @JvmField
        val cmd_paw_off = CommunityMaterialIcon("cmd_paw_off", '\ue900')
        @JvmField
        val cmd_paw = CommunityMaterialIcon("cmd_paw", '\ue900')
        @JvmField
        val cmd_paypal = CommunityMaterialIcon("cmd_paypal", '\ue900')
        @JvmField
        val cmd_pdf_box = CommunityMaterialIcon("cmd_pdf_box", '\ue900')
        @JvmField
        val cmd_peace = CommunityMaterialIcon("cmd_peace", '\ue900')
        @JvmField
        val cmd_peanut_off_outline = CommunityMaterialIcon("cmd_peanut_off_outline", '\ue900')
        @JvmField
        val cmd_peanut_off = CommunityMaterialIcon("cmd_peanut_off", '\ue900')
        @JvmField
        val cmd_peanut_outline = CommunityMaterialIcon("cmd_peanut_outline", '\ue900')
        @JvmField
        val cmd_peanut = CommunityMaterialIcon("cmd_peanut", '\ue900')
        @JvmField
        val cmd_pen_lock = CommunityMaterialIcon("cmd_pen_lock", '\ue900')
        @JvmField
        val cmd_pen_minus = CommunityMaterialIcon("cmd_pen_minus", '\ue900')
        @JvmField
        val cmd_pen_off = CommunityMaterialIcon("cmd_pen_off", '\ue900')
        @JvmField
        val cmd_pen_plus = CommunityMaterialIcon("cmd_pen_plus", '\ue900')
        @JvmField
        val cmd_pen_remove = CommunityMaterialIcon("cmd_pen_remove", '\ue900')
        @JvmField
        val cmd_pen = CommunityMaterialIcon("cmd_pen", '\ue900')
        @JvmField
        val cmd_pencil_box_multiple_outline = CommunityMaterialIcon("cmd_pencil_box_multiple_outline", '\ue900')
        @JvmField
        val cmd_pencil_box_multiple = CommunityMaterialIcon("cmd_pencil_box_multiple", '\ue900')
        @JvmField
        val cmd_pencil_box_outline = CommunityMaterialIcon("cmd_pencil_box_outline", '\ue900')
        @JvmField
        val cmd_pencil_box = CommunityMaterialIcon("cmd_pencil_box", '\ue900')
        @JvmField
        val cmd_pencil_circle_outline = CommunityMaterialIcon("cmd_pencil_circle_outline", '\ue900')
        @JvmField
        val cmd_pencil_circle = CommunityMaterialIcon("cmd_pencil_circle", '\ue900')
        @JvmField
        val cmd_pencil_lock_outline = CommunityMaterialIcon("cmd_pencil_lock_outline", '\ue900')
        @JvmField
        val cmd_pencil_lock = CommunityMaterialIcon("cmd_pencil_lock", '\ue900')
        @JvmField
        val cmd_pencil_minus_outline = CommunityMaterialIcon("cmd_pencil_minus_outline", '\ue900')
        @JvmField
        val cmd_pencil_minus = CommunityMaterialIcon("cmd_pencil_minus", '\ue900')
        @JvmField
        val cmd_pencil_off_outline = CommunityMaterialIcon("cmd_pencil_off_outline", '\ue900')
        @JvmField
        val cmd_pencil_off = CommunityMaterialIcon("cmd_pencil_off", '\ue900')
        @JvmField
        val cmd_pencil_outline = CommunityMaterialIcon("cmd_pencil_outline", '\ue900')
        @JvmField
        val cmd_pencil_plus_outline = CommunityMaterialIcon("cmd_pencil_plus_outline", '\ue900')
        @JvmField
        val cmd_pencil_plus = CommunityMaterialIcon("cmd_pencil_plus", '\ue900')
        @JvmField
        val cmd_pencil_remove_outline = CommunityMaterialIcon("cmd_pencil_remove_outline", '\ue900')
        @JvmField
        val cmd_pencil_remove = CommunityMaterialIcon("cmd_pencil_remove", '\ue900')
        @JvmField
        val cmd_pencil = CommunityMaterialIcon("cmd_pencil", '\ue900')
        @JvmField
        val cmd_penguin = CommunityMaterialIcon("cmd_penguin", '\ue900')
        @JvmField
        val cmd_pentagon_outline = CommunityMaterialIcon("cmd_pentagon_outline", '\ue900')
        @JvmField
        val cmd_pentagon = CommunityMaterialIcon("cmd_pentagon", '\ue900')
        @JvmField
        val cmd_percent_outline = CommunityMaterialIcon("cmd_percent_outline", '\ue900')
        @JvmField
        val cmd_percent = CommunityMaterialIcon("cmd_percent", '\ue900')
        @JvmField
        val cmd_periodic_table_co2 = CommunityMaterialIcon("cmd_periodic_table_co2", '\ue900')
        @JvmField
        val cmd_periodic_table = CommunityMaterialIcon("cmd_periodic_table", '\ue900')
        @JvmField
        val cmd_periscope = CommunityMaterialIcon("cmd_periscope", '\ue900')
        @JvmField
        val cmd_perspective_less = CommunityMaterialIcon("cmd_perspective_less", '\ue900')
        @JvmField
        val cmd_perspective_more = CommunityMaterialIcon("cmd_perspective_more", '\ue900')
        @JvmField
        val cmd_pharmacy = CommunityMaterialIcon("cmd_pharmacy", '\ue900')
        @JvmField
        val cmd_phone_alert_outline = CommunityMaterialIcon("cmd_phone_alert_outline", '\ue900')
        @JvmField
        val cmd_phone_alert = CommunityMaterialIcon("cmd_phone_alert", '\ue900')
        @JvmField
        val cmd_phone_bluetooth_outline = CommunityMaterialIcon("cmd_phone_bluetooth_outline", '\ue900')
        @JvmField
        val cmd_phone_bluetooth = CommunityMaterialIcon("cmd_phone_bluetooth", '\ue900')
        @JvmField
        val cmd_phone_cancel_outline = CommunityMaterialIcon("cmd_phone_cancel_outline", '\ue900')
        @JvmField
        val cmd_phone_cancel = CommunityMaterialIcon("cmd_phone_cancel", '\ue900')
        @JvmField
        val cmd_phone_check_outline = CommunityMaterialIcon("cmd_phone_check_outline", '\ue900')
        @JvmField
        val cmd_phone_check = CommunityMaterialIcon("cmd_phone_check", '\ue900')
        @JvmField
        val cmd_phone_classic_off = CommunityMaterialIcon("cmd_phone_classic_off", '\ue900')
        @JvmField
        val cmd_phone_classic = CommunityMaterialIcon("cmd_phone_classic", '\ue900')
        @JvmField
        val cmd_phone_forward_outline = CommunityMaterialIcon("cmd_phone_forward_outline", '\ue900')
        @JvmField
        val cmd_phone_forward = CommunityMaterialIcon("cmd_phone_forward", '\ue900')
        @JvmField
        val cmd_phone_hangup_outline = CommunityMaterialIcon("cmd_phone_hangup_outline", '\ue900')
        @JvmField
        val cmd_phone_hangup = CommunityMaterialIcon("cmd_phone_hangup", '\ue900')
        @JvmField
        val cmd_phone_in_talk_outline = CommunityMaterialIcon("cmd_phone_in_talk_outline", '\ue900')
        @JvmField
        val cmd_phone_in_talk = CommunityMaterialIcon("cmd_phone_in_talk", '\ue900')
        @JvmField
        val cmd_phone_incoming_outline = CommunityMaterialIcon("cmd_phone_incoming_outline", '\ue900')
        @JvmField
        val cmd_phone_incoming = CommunityMaterialIcon("cmd_phone_incoming", '\ue900')
        @JvmField
        val cmd_phone_lock_outline = CommunityMaterialIcon("cmd_phone_lock_outline", '\ue900')
        @JvmField
        val cmd_phone_lock = CommunityMaterialIcon("cmd_phone_lock", '\ue900')
        @JvmField
        val cmd_phone_log_outline = CommunityMaterialIcon("cmd_phone_log_outline", '\ue900')
        @JvmField
        val cmd_phone_log = CommunityMaterialIcon("cmd_phone_log", '\ue900')
        @JvmField
        val cmd_phone_message_outline = CommunityMaterialIcon("cmd_phone_message_outline", '\ue900')
        @JvmField
        val cmd_phone_message = CommunityMaterialIcon("cmd_phone_message", '\ue900')
        @JvmField
        val cmd_phone_minus_outline = CommunityMaterialIcon("cmd_phone_minus_outline", '\ue900')
        @JvmField
        val cmd_phone_minus = CommunityMaterialIcon("cmd_phone_minus", '\ue900')
        @JvmField
        val cmd_phone_missed_outline = CommunityMaterialIcon("cmd_phone_missed_outline", '\ue900')
        @JvmField
        val cmd_phone_missed = CommunityMaterialIcon("cmd_phone_missed", '\ue900')
        @JvmField
        val cmd_phone_off_outline = CommunityMaterialIcon("cmd_phone_off_outline", '\ue900')
        @JvmField
        val cmd_phone_off = CommunityMaterialIcon("cmd_phone_off", '\ue900')
        @JvmField
        val cmd_phone_outgoing_outline = CommunityMaterialIcon("cmd_phone_outgoing_outline", '\ue900')
        @JvmField
        val cmd_phone_outgoing = CommunityMaterialIcon("cmd_phone_outgoing", '\ue900')
        @JvmField
        val cmd_phone_outline = CommunityMaterialIcon("cmd_phone_outline", '\ue900')
        @JvmField
        val cmd_phone_paused_outline = CommunityMaterialIcon("cmd_phone_paused_outline", '\ue900')
        @JvmField
        val cmd_phone_paused = CommunityMaterialIcon("cmd_phone_paused", '\ue900')
        @JvmField
        val cmd_phone_plus_outline = CommunityMaterialIcon("cmd_phone_plus_outline", '\ue900')
        @JvmField
        val cmd_phone_plus = CommunityMaterialIcon("cmd_phone_plus", '\ue900')
        @JvmField
        val cmd_phone_return_outline = CommunityMaterialIcon("cmd_phone_return_outline", '\ue900')
        @JvmField
        val cmd_phone_return = CommunityMaterialIcon("cmd_phone_return", '\ue900')
        @JvmField
        val cmd_phone_ring_outline = CommunityMaterialIcon("cmd_phone_ring_outline", '\ue900')
        @JvmField
        val cmd_phone_ring = CommunityMaterialIcon("cmd_phone_ring", '\ue900')
        @JvmField
        val cmd_phone_rotate_landscape = CommunityMaterialIcon("cmd_phone_rotate_landscape", '\ue900')
        @JvmField
        val cmd_phone_rotate_portrait = CommunityMaterialIcon("cmd_phone_rotate_portrait", '\ue900')
        @JvmField
        val cmd_phone_settings_outline = CommunityMaterialIcon("cmd_phone_settings_outline", '\ue900')
        @JvmField
        val cmd_phone_settings = CommunityMaterialIcon("cmd_phone_settings", '\ue900')
        @JvmField
        val cmd_phone_voip = CommunityMaterialIcon("cmd_phone_voip", '\ue900')
        @JvmField
        val cmd_phone = CommunityMaterialIcon("cmd_phone", '\ue900')
        @JvmField
        val cmd_pi_box = CommunityMaterialIcon("cmd_pi_box", '\ue900')
        @JvmField
        val cmd_pi_hole = CommunityMaterialIcon("cmd_pi_hole", '\ue900')
        @JvmField
        val cmd_pi = CommunityMaterialIcon("cmd_pi", '\ue900')
        @JvmField
        val cmd_piano = CommunityMaterialIcon("cmd_piano", '\ue900')
        @JvmField
        val cmd_pickaxe = CommunityMaterialIcon("cmd_pickaxe", '\ue900')
        @JvmField
        val cmd_picture_in_picture_bottom_right_outline =
                CommunityMaterialIcon("cmd_picture_in_picture_bottom_right_outline", '\ue900')
        @JvmField
        val cmd_picture_in_picture_bottom_right = CommunityMaterialIcon("cmd_picture_in_picture_bottom_right", '\ue900')
        @JvmField
        val cmd_picture_in_picture_top_right_outline =
                CommunityMaterialIcon("cmd_picture_in_picture_top_right_outline", '\ue900')
        @JvmField
        val cmd_picture_in_picture_top_right = CommunityMaterialIcon("cmd_picture_in_picture_top_right", '\ue900')
        @JvmField
        val cmd_pier_crane = CommunityMaterialIcon("cmd_pier_crane", '\ue900')
        @JvmField
        val cmd_pier = CommunityMaterialIcon("cmd_pier", '\ue900')
        @JvmField
        val cmd_pig_variant = CommunityMaterialIcon("cmd_pig_variant", '\ue900')
        @JvmField
        val cmd_pig = CommunityMaterialIcon("cmd_pig", '\ue900')
        @JvmField
        val cmd_piggy_bank = CommunityMaterialIcon("cmd_piggy_bank", '\ue900')
        @JvmField
        val cmd_pill = CommunityMaterialIcon("cmd_pill", '\ue900')
        @JvmField
        val cmd_pillar = CommunityMaterialIcon("cmd_pillar", '\ue900')
        @JvmField
        val cmd_pin_off_outline = CommunityMaterialIcon("cmd_pin_off_outline", '\ue900')
        @JvmField
        val cmd_pin_off = CommunityMaterialIcon("cmd_pin_off", '\ue900')
        @JvmField
        val cmd_pin_outline = CommunityMaterialIcon("cmd_pin_outline", '\ue900')
        @JvmField
        val cmd_pin = CommunityMaterialIcon("cmd_pin", '\ue900')
        @JvmField
        val cmd_pine_tree_box = CommunityMaterialIcon("cmd_pine_tree_box", '\ue900')
        @JvmField
        val cmd_pine_tree = CommunityMaterialIcon("cmd_pine_tree", '\ue900')
        @JvmField
        val cmd_pinterest_box = CommunityMaterialIcon("cmd_pinterest_box", '\ue900')
        @JvmField
        val cmd_pinterest = CommunityMaterialIcon("cmd_pinterest", '\ue900')
        @JvmField
        val cmd_pinwheel_outline = CommunityMaterialIcon("cmd_pinwheel_outline", '\ue900')
        @JvmField
        val cmd_pinwheel = CommunityMaterialIcon("cmd_pinwheel", '\ue900')
        @JvmField
        val cmd_pipe_disconnected = CommunityMaterialIcon("cmd_pipe_disconnected", '\ue900')
        @JvmField
        val cmd_pipe_leak = CommunityMaterialIcon("cmd_pipe_leak", '\ue900')
        @JvmField
        val cmd_pipe = CommunityMaterialIcon("cmd_pipe", '\ue900')
        @JvmField
        val cmd_pirate = CommunityMaterialIcon("cmd_pirate", '\ue900')
        @JvmField
        val cmd_pistol = CommunityMaterialIcon("cmd_pistol", '\ue900')
        @JvmField
        val cmd_piston = CommunityMaterialIcon("cmd_piston", '\ue900')
        @JvmField
        val cmd_pizza = CommunityMaterialIcon("cmd_pizza", '\ue900')
        @JvmField
        val cmd_play_box_outline = CommunityMaterialIcon("cmd_play_box_outline", '\ue900')
        @JvmField
        val cmd_play_box = CommunityMaterialIcon("cmd_play_box", '\ue900')
        @JvmField
        val cmd_play_circle_outline = CommunityMaterialIcon("cmd_play_circle_outline", '\ue900')
        @JvmField
        val cmd_play_circle = CommunityMaterialIcon("cmd_play_circle", '\ue900')
        @JvmField
        val cmd_play_network_outline = CommunityMaterialIcon("cmd_play_network_outline", '\ue900')
        @JvmField
        val cmd_play_network = CommunityMaterialIcon("cmd_play_network", '\ue900')
        @JvmField
        val cmd_play_outline = CommunityMaterialIcon("cmd_play_outline", '\ue900')
        @JvmField
        val cmd_play_pause = CommunityMaterialIcon("cmd_play_pause", '\ue900')
        @JvmField
        val cmd_play_protected_content = CommunityMaterialIcon("cmd_play_protected_content", '\ue900')
        @JvmField
        val cmd_play_speed = CommunityMaterialIcon("cmd_play_speed", '\ue900')
        @JvmField
        val cmd_play = CommunityMaterialIcon("cmd_play", '\ue900')
        @JvmField
        val cmd_playlist_check = CommunityMaterialIcon("cmd_playlist_check", '\ue900')
        @JvmField
        val cmd_playlist_edit = CommunityMaterialIcon("cmd_playlist_edit", '\ue900')
        @JvmField
        val cmd_playlist_minus = CommunityMaterialIcon("cmd_playlist_minus", '\ue900')
        @JvmField
        val cmd_playlist_music_outline = CommunityMaterialIcon("cmd_playlist_music_outline", '\ue900')
        @JvmField
        val cmd_playlist_music = CommunityMaterialIcon("cmd_playlist_music", '\ue900')
        @JvmField
        val cmd_playlist_play = CommunityMaterialIcon("cmd_playlist_play", '\ue900')
        @JvmField
        val cmd_playlist_plus = CommunityMaterialIcon("cmd_playlist_plus", '\ue900')
        @JvmField
        val cmd_playlist_remove = CommunityMaterialIcon("cmd_playlist_remove", '\ue900')
        @JvmField
        val cmd_playlist_star = CommunityMaterialIcon("cmd_playlist_star", '\ue900')
        @JvmField
        val cmd_playstation = CommunityMaterialIcon("cmd_playstation", '\ue900')
        @JvmField
        val cmd_plex = CommunityMaterialIcon("cmd_plex", '\ue900')
        @JvmField
        val cmd_plus_box_multiple_outline = CommunityMaterialIcon("cmd_plus_box_multiple_outline", '\ue900')
        @JvmField
        val cmd_plus_box_multiple = CommunityMaterialIcon("cmd_plus_box_multiple", '\ue900')
        @JvmField
        val cmd_plus_box_outline = CommunityMaterialIcon("cmd_plus_box_outline", '\ue900')
        @JvmField
        val cmd_plus_box = CommunityMaterialIcon("cmd_plus_box", '\ue900')
        @JvmField
        val cmd_plus_circle_multiple_outline = CommunityMaterialIcon("cmd_plus_circle_multiple_outline", '\ue900')
        @JvmField
        val cmd_plus_circle_outline = CommunityMaterialIcon("cmd_plus_circle_outline", '\ue900')
        @JvmField
        val cmd_plus_circle = CommunityMaterialIcon("cmd_plus_circle", '\ue900')
        @JvmField
        val cmd_plus_minus_box = CommunityMaterialIcon("cmd_plus_minus_box", '\ue900')
        @JvmField
        val cmd_plus_minus = CommunityMaterialIcon("cmd_plus_minus", '\ue900')
        @JvmField
        val cmd_plus_network_outline = CommunityMaterialIcon("cmd_plus_network_outline", '\ue900')
        @JvmField
        val cmd_plus_network = CommunityMaterialIcon("cmd_plus_network", '\ue900')
        @JvmField
        val cmd_plus_one = CommunityMaterialIcon("cmd_plus_one", '\ue900')
        @JvmField
        val cmd_plus_outline = CommunityMaterialIcon("cmd_plus_outline", '\ue900')
        @JvmField
        val cmd_plus_thick = CommunityMaterialIcon("cmd_plus_thick", '\ue900')
        @JvmField
        val cmd_plus = CommunityMaterialIcon("cmd_plus", '\ue900')
        @JvmField
        val cmd_pocket = CommunityMaterialIcon("cmd_pocket", '\ue900')
        @JvmField
        val cmd_podcast = CommunityMaterialIcon("cmd_podcast", '\ue900')
        @JvmField
        val cmd_podium_bronze = CommunityMaterialIcon("cmd_podium_bronze", '\ue900')
        @JvmField
        val cmd_podium_gold = CommunityMaterialIcon("cmd_podium_gold", '\ue900')
        @JvmField
        val cmd_podium_silver = CommunityMaterialIcon("cmd_podium_silver", '\ue900')
        @JvmField
        val cmd_podium = CommunityMaterialIcon("cmd_podium", '\ue900')
        @JvmField
        val cmd_point_of_sale = CommunityMaterialIcon("cmd_point_of_sale", '\ue900')
        @JvmField
        val cmd_pokeball = CommunityMaterialIcon("cmd_pokeball", '\ue900')
        @JvmField
        val cmd_pokemon_go = CommunityMaterialIcon("cmd_pokemon_go", '\ue900')
        @JvmField
        val cmd_poker_chip = CommunityMaterialIcon("cmd_poker_chip", '\ue900')
        @JvmField
        val cmd_polaroid = CommunityMaterialIcon("cmd_polaroid", '\ue900')
        @JvmField
        val cmd_police_badge_outline = CommunityMaterialIcon("cmd_police_badge_outline", '\ue900')
        @JvmField
        val cmd_police_badge = CommunityMaterialIcon("cmd_police_badge", '\ue900')
        @JvmField
        val cmd_poll_box_outline = CommunityMaterialIcon("cmd_poll_box_outline", '\ue900')
        @JvmField
        val cmd_poll_box = CommunityMaterialIcon("cmd_poll_box", '\ue900')
        @JvmField
        val cmd_poll = CommunityMaterialIcon("cmd_poll", '\ue900')
        @JvmField
        val cmd_polymer = CommunityMaterialIcon("cmd_polymer", '\ue900')
        @JvmField
        val cmd_pool = CommunityMaterialIcon("cmd_pool", '\ue900')
        @JvmField
        val cmd_popcorn = CommunityMaterialIcon("cmd_popcorn", '\ue900')
        @JvmField
        val cmd_post_outline = CommunityMaterialIcon("cmd_post_outline", '\ue900')
        @JvmField
        val cmd_post = CommunityMaterialIcon("cmd_post", '\ue900')
        @JvmField
        val cmd_postage_stamp = CommunityMaterialIcon("cmd_postage_stamp", '\ue900')
        @JvmField
        val cmd_pot_mix = CommunityMaterialIcon("cmd_pot_mix", '\ue900')
        @JvmField
        val cmd_pot = CommunityMaterialIcon("cmd_pot", '\ue900')
        @JvmField
        val cmd_pound_box_outline = CommunityMaterialIcon("cmd_pound_box_outline", '\ue900')
        @JvmField
        val cmd_pound_box = CommunityMaterialIcon("cmd_pound_box", '\ue900')
        @JvmField
        val cmd_pound = CommunityMaterialIcon("cmd_pound", '\ue900')
        @JvmField
        val cmd_power_cycle = CommunityMaterialIcon("cmd_power_cycle", '\ue900')
        @JvmField
        val cmd_power_off = CommunityMaterialIcon("cmd_power_off", '\ue900')
        @JvmField
        val cmd_power_on = CommunityMaterialIcon("cmd_power_on", '\ue900')
        @JvmField
        val cmd_power_plug_off = CommunityMaterialIcon("cmd_power_plug_off", '\ue900')
        @JvmField
        val cmd_power_plug = CommunityMaterialIcon("cmd_power_plug", '\ue900')
        @JvmField
        val cmd_power_settings = CommunityMaterialIcon("cmd_power_settings", '\ue900')
        @JvmField
        val cmd_power_sleep = CommunityMaterialIcon("cmd_power_sleep", '\ue900')
        @JvmField
        val cmd_power_socket_au = CommunityMaterialIcon("cmd_power_socket_au", '\ue900')
        @JvmField
        val cmd_power_socket_de = CommunityMaterialIcon("cmd_power_socket_de", '\ue900')
        @JvmField
        val cmd_power_socket_eu = CommunityMaterialIcon("cmd_power_socket_eu", '\ue900')
        @JvmField
        val cmd_power_socket_fr = CommunityMaterialIcon("cmd_power_socket_fr", '\ue900')
        @JvmField
        val cmd_power_socket_jp = CommunityMaterialIcon("cmd_power_socket_jp", '\ue900')
        @JvmField
        val cmd_power_socket_uk = CommunityMaterialIcon("cmd_power_socket_uk", '\ue900')
        @JvmField
        val cmd_power_socket_us = CommunityMaterialIcon("cmd_power_socket_us", '\ue900')
        @JvmField
        val cmd_power_socket = CommunityMaterialIcon("cmd_power_socket", '\ue900')
        @JvmField
        val cmd_power_standby = CommunityMaterialIcon("cmd_power_standby", '\ue900')
        @JvmField
        val cmd_power = CommunityMaterialIcon("cmd_power", '\ue900')
        @JvmField
        val cmd_powershell = CommunityMaterialIcon("cmd_powershell", '\ue900')
        @JvmField
        val cmd_prescription = CommunityMaterialIcon("cmd_prescription", '\ue900')
        @JvmField
        val cmd_presentation_play = CommunityMaterialIcon("cmd_presentation_play", '\ue900')
        @JvmField
        val cmd_presentation = CommunityMaterialIcon("cmd_presentation", '\ue900')
        @JvmField
        val cmd_printer_3d_nozzle_alert_outline = CommunityMaterialIcon("cmd_printer_3d_nozzle_alert_outline", '\ue900')
        @JvmField
        val cmd_printer_3d_nozzle_alert = CommunityMaterialIcon("cmd_printer_3d_nozzle_alert", '\ue900')
        @JvmField
        val cmd_printer_3d_nozzle_outline = CommunityMaterialIcon("cmd_printer_3d_nozzle_outline", '\ue900')
        @JvmField
        val cmd_printer_3d_nozzle = CommunityMaterialIcon("cmd_printer_3d_nozzle", '\ue900')
        @JvmField
        val cmd_printer_3d = CommunityMaterialIcon("cmd_printer_3d", '\ue900')
        @JvmField
        val cmd_printer_alert = CommunityMaterialIcon("cmd_printer_alert", '\ue900')
        @JvmField
        val cmd_printer_check = CommunityMaterialIcon("cmd_printer_check", '\ue900')
        @JvmField
        val cmd_printer_off = CommunityMaterialIcon("cmd_printer_off", '\ue900')
        @JvmField
        val cmd_printer_pos = CommunityMaterialIcon("cmd_printer_pos", '\ue900')
        @JvmField
        val cmd_printer_settings = CommunityMaterialIcon("cmd_printer_settings", '\ue900')
        @JvmField
        val cmd_printer_wireless = CommunityMaterialIcon("cmd_printer_wireless", '\ue900')
        @JvmField
        val cmd_printer = CommunityMaterialIcon("cmd_printer", '\ue900')
        @JvmField
        val cmd_priority_high = CommunityMaterialIcon("cmd_priority_high", '\ue900')
        @JvmField
        val cmd_priority_low = CommunityMaterialIcon("cmd_priority_low", '\ue900')
        @JvmField
        val cmd_professional_hexagon = CommunityMaterialIcon("cmd_professional_hexagon", '\ue900')
        @JvmField
        val cmd_progress_alert = CommunityMaterialIcon("cmd_progress_alert", '\ue900')
        @JvmField
        val cmd_progress_check = CommunityMaterialIcon("cmd_progress_check", '\ue900')
        @JvmField
        val cmd_progress_clock = CommunityMaterialIcon("cmd_progress_clock", '\ue900')
        @JvmField
        val cmd_progress_close = CommunityMaterialIcon("cmd_progress_close", '\ue900')
        @JvmField
        val cmd_progress_download = CommunityMaterialIcon("cmd_progress_download", '\ue900')
        @JvmField
        val cmd_progress_upload = CommunityMaterialIcon("cmd_progress_upload", '\ue900')
        @JvmField
        val cmd_progress_wrench = CommunityMaterialIcon("cmd_progress_wrench", '\ue900')
        @JvmField
        val cmd_projector_screen = CommunityMaterialIcon("cmd_projector_screen", '\ue900')
        @JvmField
        val cmd_projector = CommunityMaterialIcon("cmd_projector", '\ue900')
        @JvmField
        val cmd_protocol = CommunityMaterialIcon("cmd_protocol", '\ue900')
        @JvmField
        val cmd_publish = CommunityMaterialIcon("cmd_publish", '\ue900')
        @JvmField
        val cmd_pulse = CommunityMaterialIcon("cmd_pulse", '\ue900')
        @JvmField
        val cmd_pumpkin = CommunityMaterialIcon("cmd_pumpkin", '\ue900')
        @JvmField
        val cmd_purse_outline = CommunityMaterialIcon("cmd_purse_outline", '\ue900')
        @JvmField
        val cmd_purse = CommunityMaterialIcon("cmd_purse", '\ue900')
        @JvmField
        val cmd_puzzle_outline = CommunityMaterialIcon("cmd_puzzle_outline", '\ue900')
        @JvmField
        val cmd_puzzle = CommunityMaterialIcon("cmd_puzzle", '\ue900')
        @JvmField
        val cmd_qi = CommunityMaterialIcon("cmd_qi", '\ue900')
        @JvmField
        val cmd_qqchat = CommunityMaterialIcon("cmd_qqchat", '\ue900')
        @JvmField
        val cmd_qrcode_edit = CommunityMaterialIcon("cmd_qrcode_edit", '\ue900')
        @JvmField
        val cmd_qrcode_minus = CommunityMaterialIcon("cmd_qrcode_minus", '\ue900')
        @JvmField
        val cmd_qrcode_plus = CommunityMaterialIcon("cmd_qrcode_plus", '\ue900')
        @JvmField
        val cmd_qrcode_remove = CommunityMaterialIcon("cmd_qrcode_remove", '\ue900')
        @JvmField
        val cmd_qrcode_scan = CommunityMaterialIcon("cmd_qrcode_scan", '\ue900')
        @JvmField
        val cmd_qrcode = CommunityMaterialIcon("cmd_qrcode", '\ue900')
        @JvmField
        val cmd_quadcopter = CommunityMaterialIcon("cmd_quadcopter", '\ue900')
        @JvmField
        val cmd_quality_high = CommunityMaterialIcon("cmd_quality_high", '\ue900')
        @JvmField
        val cmd_quality_low = CommunityMaterialIcon("cmd_quality_low", '\ue900')
        @JvmField
        val cmd_quality_medium = CommunityMaterialIcon("cmd_quality_medium", '\ue900')
        @JvmField
        val cmd_quicktime = CommunityMaterialIcon("cmd_quicktime", '\ue900')
        @JvmField
        val cmd_quora = CommunityMaterialIcon("cmd_quora", '\ue900')
        @JvmField
        val cmd_rabbit = CommunityMaterialIcon("cmd_rabbit", '\ue900')
        @JvmField
        val cmd_racing_helmet = CommunityMaterialIcon("cmd_racing_helmet", '\ue900')
        @JvmField
        val cmd_racquetball = CommunityMaterialIcon("cmd_racquetball", '\ue900')
        @JvmField
        val cmd_radar = CommunityMaterialIcon("cmd_radar", '\ue900')
        @JvmField
        val cmd_radiator_disabled = CommunityMaterialIcon("cmd_radiator_disabled", '\ue900')
        @JvmField
        val cmd_radiator_off = CommunityMaterialIcon("cmd_radiator_off", '\ue900')
        @JvmField
        val cmd_radiator = CommunityMaterialIcon("cmd_radiator", '\ue900')
        @JvmField
        val cmd_radio_am = CommunityMaterialIcon("cmd_radio_am", '\ue900')
        @JvmField
        val cmd_radio_fm = CommunityMaterialIcon("cmd_radio_fm", '\ue900')
        @JvmField
        val cmd_radio_handheld = CommunityMaterialIcon("cmd_radio_handheld", '\ue900')
        @JvmField
        val cmd_radio_off = CommunityMaterialIcon("cmd_radio_off", '\ue900')
        @JvmField
        val cmd_radio_tower = CommunityMaterialIcon("cmd_radio_tower", '\ue900')
        @JvmField
        val cmd_radio = CommunityMaterialIcon("cmd_radio", '\ue900')
        @JvmField
        val cmd_radioactive_off = CommunityMaterialIcon("cmd_radioactive_off", '\ue900')
        @JvmField
        val cmd_radioactive = CommunityMaterialIcon("cmd_radioactive", '\ue900')
        @JvmField
        val cmd_radiobox_blank = CommunityMaterialIcon("cmd_radiobox_blank", '\ue900')
        @JvmField
        val cmd_radiobox_marked = CommunityMaterialIcon("cmd_radiobox_marked", '\ue900')
        @JvmField
        val cmd_radius_outline = CommunityMaterialIcon("cmd_radius_outline", '\ue900')
        @JvmField
        val cmd_radius = CommunityMaterialIcon("cmd_radius", '\ue900')
        @JvmField
        val cmd_railroad_light = CommunityMaterialIcon("cmd_railroad_light", '\ue900')
        @JvmField
        val cmd_raspberry_pi = CommunityMaterialIcon("cmd_raspberry_pi", '\ue900')
        @JvmField
        val cmd_ray_end_arrow = CommunityMaterialIcon("cmd_ray_end_arrow", '\ue900')
        @JvmField
        val cmd_ray_end = CommunityMaterialIcon("cmd_ray_end", '\ue900')
        @JvmField
        val cmd_ray_start_arrow = CommunityMaterialIcon("cmd_ray_start_arrow", '\ue900')
        @JvmField
        val cmd_ray_start_end = CommunityMaterialIcon("cmd_ray_start_end", '\ue900')
        @JvmField
        val cmd_ray_start = CommunityMaterialIcon("cmd_ray_start", '\ue900')
        @JvmField
        val cmd_ray_vertex = CommunityMaterialIcon("cmd_ray_vertex", '\ue900')
        @JvmField
        val cmd_react = CommunityMaterialIcon("cmd_react", '\ue900')
        @JvmField
        val cmd_call_made = CommunityMaterialIcon("cmd_call_made", '\ue900')
        @JvmField
        val cmd_call_merge = CommunityMaterialIcon("cmd_call_merge", '\ue900')
        @JvmField
        val cmd_call_missed = CommunityMaterialIcon("cmd_call_missed", '\ue900')
        @JvmField
        val cmd_call_received = CommunityMaterialIcon("cmd_call_received", '\ue900')
        @JvmField
        val cmd_call_split = CommunityMaterialIcon("cmd_call_split", '\ue900')
        @JvmField
        val cmd_camcorder_box_off = CommunityMaterialIcon("cmd_camcorder_box_off", '\ue900')
        @JvmField
        val cmd_camcorder_box = CommunityMaterialIcon("cmd_camcorder_box", '\ue900')
        @JvmField
        val cmd_camcorder_off = CommunityMaterialIcon("cmd_camcorder_off", '\ue900')
        @JvmField
        val cmd_camcorder = CommunityMaterialIcon("cmd_camcorder", '\ue900')
        @JvmField
        val cmd_camera_account = CommunityMaterialIcon("cmd_camera_account", '\ue900')
        @JvmField
        val cmd_camera_burst = CommunityMaterialIcon("cmd_camera_burst", '\ue900')
        @JvmField
        val cmd_camera_control = CommunityMaterialIcon("cmd_camera_control", '\ue900')
        @JvmField
        val cmd_camera_enhance_outline = CommunityMaterialIcon("cmd_camera_enhance_outline", '\ue900')
        @JvmField
        val cmd_camera_enhance = CommunityMaterialIcon("cmd_camera_enhance", '\ue900')
        @JvmField
        val cmd_camera_front_variant = CommunityMaterialIcon("cmd_camera_front_variant", '\ue900')
        @JvmField
        val cmd_camera_front = CommunityMaterialIcon("cmd_camera_front", '\ue900')
        @JvmField
        val cmd_camera_gopro = CommunityMaterialIcon("cmd_camera_gopro", '\ue900')
        @JvmField
        val cmd_camera_image = CommunityMaterialIcon("cmd_camera_image", '\ue900')
        @JvmField
        val cmd_camera_iris = CommunityMaterialIcon("cmd_camera_iris", '\ue900')
        @JvmField
        val cmd_camera_metering_center = CommunityMaterialIcon("cmd_camera_metering_center", '\ue900')
        @JvmField
        val cmd_camera_metering_matrix = CommunityMaterialIcon("cmd_camera_metering_matrix", '\ue900')
        @JvmField
        val cmd_camera_metering_partial = CommunityMaterialIcon("cmd_camera_metering_partial", '\ue900')
        @JvmField
        val cmd_camera_metering_spot = CommunityMaterialIcon("cmd_camera_metering_spot", '\ue900')
        @JvmField
        val cmd_camera_off = CommunityMaterialIcon("cmd_camera_off", '\ue900')
        @JvmField
        val cmd_camera_outline = CommunityMaterialIcon("cmd_camera_outline", '\ue900')
        @JvmField
        val cmd_camera_party_mode = CommunityMaterialIcon("cmd_camera_party_mode", '\ue900')
        @JvmField
        val cmd_camera_plus_outline = CommunityMaterialIcon("cmd_camera_plus_outline", '\ue900')
        @JvmField
        val cmd_camera_plus = CommunityMaterialIcon("cmd_camera_plus", '\ue900')
        @JvmField
        val cmd_camera_rear_variant = CommunityMaterialIcon("cmd_camera_rear_variant", '\ue900')
        @JvmField
        val cmd_camera_rear = CommunityMaterialIcon("cmd_camera_rear", '\ue900')
        @JvmField
        val cmd_camera_retake_outline = CommunityMaterialIcon("cmd_camera_retake_outline", '\ue900')
        @JvmField
        val cmd_camera_retake = CommunityMaterialIcon("cmd_camera_retake", '\ue900')
        @JvmField
        val cmd_camera_switch = CommunityMaterialIcon("cmd_camera_switch", '\ue900')
        @JvmField
        val cmd_camera_timer = CommunityMaterialIcon("cmd_camera_timer", '\ue900')
        @JvmField
        val cmd_camera_wireless_outline = CommunityMaterialIcon("cmd_camera_wireless_outline", '\ue900')
        @JvmField
        val cmd_camera_wireless = CommunityMaterialIcon("cmd_camera_wireless", '\ue900')
        @JvmField
        val cmd_camera = CommunityMaterialIcon("cmd_camera", '\ue900')
        @JvmField
        val cmd_campfire = CommunityMaterialIcon("cmd_campfire", '\ue900')
        @JvmField
        val cmd_cancel = CommunityMaterialIcon("cmd_cancel", '\ue900')
        @JvmField
        val cmd_candle = CommunityMaterialIcon("cmd_candle", '\ue900')
        @JvmField
        val cmd_candycane = CommunityMaterialIcon("cmd_candycane", '\ue900')
        @JvmField
        val cmd_cannabis = CommunityMaterialIcon("cmd_cannabis", '\ue900')
        @JvmField
        val cmd_caps_lock = CommunityMaterialIcon("cmd_caps_lock", '\ue900')
        @JvmField
        val cmd_car_2_plus = CommunityMaterialIcon("cmd_car_2_plus", '\ue900')
        @JvmField
        val cmd_car_3_plus = CommunityMaterialIcon("cmd_car_3_plus", '\ue900')
        @JvmField
        val cmd_car_back = CommunityMaterialIcon("cmd_car_back", '\ue900')
        @JvmField
        val cmd_car_battery = CommunityMaterialIcon("cmd_car_battery", '\ue900')
        @JvmField
        val cmd_car_brake_abs = CommunityMaterialIcon("cmd_car_brake_abs", '\ue900')
        @JvmField
        val cmd_car_brake_alert = CommunityMaterialIcon("cmd_car_brake_alert", '\ue900')
        @JvmField
        val cmd_car_brake_hold = CommunityMaterialIcon("cmd_car_brake_hold", '\ue900')
        @JvmField
        val cmd_car_brake_parking = CommunityMaterialIcon("cmd_car_brake_parking", '\ue900')
        @JvmField
        val cmd_car_brake_retarder = CommunityMaterialIcon("cmd_car_brake_retarder", '\ue900')
        @JvmField
        val cmd_car_child_seat = CommunityMaterialIcon("cmd_car_child_seat", '\ue900')
        @JvmField
        val cmd_car_clutch = CommunityMaterialIcon("cmd_car_clutch", '\ue900')
        @JvmField
        val cmd_car_connected = CommunityMaterialIcon("cmd_car_connected", '\ue900')
        @JvmField
        val cmd_car_convertible = CommunityMaterialIcon("cmd_car_convertible", '\ue900')
        @JvmField
        val cmd_car_coolant_level = CommunityMaterialIcon("cmd_car_coolant_level", '\ue900')
        @JvmField
        val cmd_car_cruise_control = CommunityMaterialIcon("cmd_car_cruise_control", '\ue900')
        @JvmField
        val cmd_car_defrost_front = CommunityMaterialIcon("cmd_car_defrost_front", '\ue900')
        @JvmField
        val cmd_car_defrost_rear = CommunityMaterialIcon("cmd_car_defrost_rear", '\ue900')
        @JvmField
        val cmd_car_door_lock = CommunityMaterialIcon("cmd_car_door_lock", '\ue900')
        @JvmField
        val cmd_car_door = CommunityMaterialIcon("cmd_car_door", '\ue900')
        @JvmField
        val cmd_car_electric = CommunityMaterialIcon("cmd_car_electric", '\ue900')
        @JvmField
        val cmd_car_esp = CommunityMaterialIcon("cmd_car_esp", '\ue900')
        @JvmField
        val cmd_car_estate = CommunityMaterialIcon("cmd_car_estate", '\ue900')
        @JvmField
        val cmd_car_hatchback = CommunityMaterialIcon("cmd_car_hatchback", '\ue900')
        @JvmField
        val cmd_car_info = CommunityMaterialIcon("cmd_car_info", '\ue900')
        @JvmField
        val cmd_car_key = CommunityMaterialIcon("cmd_car_key", '\ue900')
        @JvmField
        val cmd_car_light_dimmed = CommunityMaterialIcon("cmd_car_light_dimmed", '\ue900')
        @JvmField
        val cmd_car_light_fog = CommunityMaterialIcon("cmd_car_light_fog", '\ue900')
        @JvmField
        val cmd_car_light_high = CommunityMaterialIcon("cmd_car_light_high", '\ue900')
        @JvmField
        val cmd_car_limousine = CommunityMaterialIcon("cmd_car_limousine", '\ue900')
        @JvmField
        val cmd_car_multiple = CommunityMaterialIcon("cmd_car_multiple", '\ue900')
        @JvmField
        val cmd_car_off = CommunityMaterialIcon("cmd_car_off", '\ue900')
        @JvmField
        val cmd_car_parking_lights = CommunityMaterialIcon("cmd_car_parking_lights", '\ue900')
        @JvmField
        val cmd_car_pickup = CommunityMaterialIcon("cmd_car_pickup", '\ue900')
        @JvmField
        val cmd_car_seat_cooler = CommunityMaterialIcon("cmd_car_seat_cooler", '\ue900')
        @JvmField
        val cmd_car_seat_heater = CommunityMaterialIcon("cmd_car_seat_heater", '\ue900')
        @JvmField
        val cmd_car_seat = CommunityMaterialIcon("cmd_car_seat", '\ue900')
        @JvmField
        val cmd_car_shift_pattern = CommunityMaterialIcon("cmd_car_shift_pattern", '\ue900')
        @JvmField
        val cmd_car_side = CommunityMaterialIcon("cmd_car_side", '\ue900')
        @JvmField
        val cmd_car_sports = CommunityMaterialIcon("cmd_car_sports", '\ue900')
        @JvmField
        val cmd_car_tire_alert = CommunityMaterialIcon("cmd_car_tire_alert", '\ue900')
        @JvmField
        val cmd_car_traction_control = CommunityMaterialIcon("cmd_car_traction_control", '\ue900')
        @JvmField
        val cmd_car_turbocharger = CommunityMaterialIcon("cmd_car_turbocharger", '\ue900')
        @JvmField
        val cmd_car_wash = CommunityMaterialIcon("cmd_car_wash", '\ue900')
        @JvmField
        val cmd_car_windshield_outline = CommunityMaterialIcon("cmd_car_windshield_outline", '\ue900')
        @JvmField
        val cmd_car_windshield = CommunityMaterialIcon("cmd_car_windshield", '\ue900')
        @JvmField
        val cmd_car = CommunityMaterialIcon("cmd_car", '\ue900')
        @JvmField
        val cmd_caravan = CommunityMaterialIcon("cmd_caravan", '\ue900')
        @JvmField
        val cmd_card_bulleted_off_outline = CommunityMaterialIcon("cmd_card_bulleted_off_outline", '\ue900')
        @JvmField
        val cmd_card_bulleted_off = CommunityMaterialIcon("cmd_card_bulleted_off", '\ue900')
        @JvmField
        val cmd_card_bulleted_outline = CommunityMaterialIcon("cmd_card_bulleted_outline", '\ue900')
        @JvmField
        val cmd_card_bulleted_settings_outline = CommunityMaterialIcon("cmd_card_bulleted_settings_outline", '\ue900')
        @JvmField
        val cmd_card_bulleted_settings = CommunityMaterialIcon("cmd_card_bulleted_settings", '\ue900')
        @JvmField
        val cmd_card_bulleted = CommunityMaterialIcon("cmd_card_bulleted", '\ue900')
        @JvmField
        val cmd_card_outline = CommunityMaterialIcon("cmd_card_outline", '\ue900')
        @JvmField
        val cmd_card_plus_outline = CommunityMaterialIcon("cmd_card_plus_outline", '\ue900')
        @JvmField
        val cmd_card_plus = CommunityMaterialIcon("cmd_card_plus", '\ue900')
        @JvmField
        val cmd_card_search_outline = CommunityMaterialIcon("cmd_card_search_outline", '\ue900')
        @JvmField
        val cmd_card_search = CommunityMaterialIcon("cmd_card_search", '\ue900')
        @JvmField
        val cmd_card_text_outline = CommunityMaterialIcon("cmd_card_text_outline", '\ue900')
        @JvmField
        val cmd_card_text = CommunityMaterialIcon("cmd_card_text", '\ue900')
        @JvmField
        val cmd_card = CommunityMaterialIcon("cmd_card", '\ue900')
        @JvmField
        val cmd_cards_club = CommunityMaterialIcon("cmd_cards_club", '\ue900')
        @JvmField
        val cmd_cards_diamond_outline = CommunityMaterialIcon("cmd_cards_diamond_outline", '\ue900')
        @JvmField
        val cmd_cards_diamond = CommunityMaterialIcon("cmd_cards_diamond", '\ue900')
        @JvmField
        val cmd_cards_heart = CommunityMaterialIcon("cmd_cards_heart", '\ue900')
        @JvmField
        val cmd_cards_outline = CommunityMaterialIcon("cmd_cards_outline", '\ue900')
        @JvmField
        val cmd_cards_playing_outline = CommunityMaterialIcon("cmd_cards_playing_outline", '\ue900')
        @JvmField
        val cmd_cards_spade = CommunityMaterialIcon("cmd_cards_spade", '\ue900')
        @JvmField
        val cmd_cards_variant = CommunityMaterialIcon("cmd_cards_variant", '\ue900')
        @JvmField
        val cmd_cards = CommunityMaterialIcon("cmd_cards", '\ue900')
        @JvmField
        val cmd_carrot = CommunityMaterialIcon("cmd_carrot", '\ue900')
        @JvmField
        val cmd_cart_arrow_down = CommunityMaterialIcon("cmd_cart_arrow_down", '\ue900')
        @JvmField
        val cmd_cart_arrow_right = CommunityMaterialIcon("cmd_cart_arrow_right", '\ue900')
        @JvmField
        val cmd_cart_arrow_up = CommunityMaterialIcon("cmd_cart_arrow_up", '\ue900')
        @JvmField
        val cmd_cart_minus = CommunityMaterialIcon("cmd_cart_minus", '\ue900')
        @JvmField
        val cmd_cart_off = CommunityMaterialIcon("cmd_cart_off", '\ue900')
        @JvmField
        val cmd_cart_outline = CommunityMaterialIcon("cmd_cart_outline", '\ue900')
        @JvmField
        val cmd_cart_plus = CommunityMaterialIcon("cmd_cart_plus", '\ue900')
        @JvmField
        val cmd_cart_remove = CommunityMaterialIcon("cmd_cart_remove", '\ue900')
        @JvmField
        val cmd_cart = CommunityMaterialIcon("cmd_cart", '\ue900')
        @JvmField
        val cmd_case_sensitive_alt = CommunityMaterialIcon("cmd_case_sensitive_alt", '\ue900')
        @JvmField
        val cmd_cash_100 = CommunityMaterialIcon("cmd_cash_100", '\ue900')
        @JvmField
        val cmd_cash_marker = CommunityMaterialIcon("cmd_cash_marker", '\ue900')
        @JvmField
        val cmd_cash_minus = CommunityMaterialIcon("cmd_cash_minus", '\ue900')
        @JvmField
        val cmd_cash_multiple = CommunityMaterialIcon("cmd_cash_multiple", '\ue900')
        @JvmField
        val cmd_cash_plus = CommunityMaterialIcon("cmd_cash_plus", '\ue900')
        @JvmField
        val cmd_cash_refund = CommunityMaterialIcon("cmd_cash_refund", '\ue900')
        @JvmField
        val cmd_cash_register = CommunityMaterialIcon("cmd_cash_register", '\ue900')
        @JvmField
        val cmd_cash_remove = CommunityMaterialIcon("cmd_cash_remove", '\ue900')
        @JvmField
        val cmd_cash_usd_outline = CommunityMaterialIcon("cmd_cash_usd_outline", '\ue900')
        @JvmField
        val cmd_cash_usd = CommunityMaterialIcon("cmd_cash_usd", '\ue900')
        @JvmField
        val cmd_cash = CommunityMaterialIcon("cmd_cash", '\ue900')
        @JvmField
        val cmd_cassette = CommunityMaterialIcon("cmd_cassette", '\ue900')
        @JvmField
        val cmd_cast_audio = CommunityMaterialIcon("cmd_cast_audio", '\ue900')
        @JvmField
        val cmd_cast_connected = CommunityMaterialIcon("cmd_cast_connected", '\ue900')
        @JvmField
        val cmd_cast_education = CommunityMaterialIcon("cmd_cast_education", '\ue900')
        @JvmField
        val cmd_cast_off = CommunityMaterialIcon("cmd_cast_off", '\ue900')
        @JvmField
        val cmd_cast = CommunityMaterialIcon("cmd_cast", '\ue900')
        @JvmField
        val cmd_castle = CommunityMaterialIcon("cmd_castle", '\ue900')
        @JvmField
        val cmd_cat = CommunityMaterialIcon("cmd_cat", '\ue900')
        @JvmField
        val cmd_cctv = CommunityMaterialIcon("cmd_cctv", '\ue900')
        @JvmField
        val cmd_ceiling_light = CommunityMaterialIcon("cmd_ceiling_light", '\ue900')
        @JvmField
        val cmd_cellphone_android = CommunityMaterialIcon("cmd_cellphone_android", '\ue900')
        @JvmField
        val cmd_cellphone_arrow_down = CommunityMaterialIcon("cmd_cellphone_arrow_down", '\ue900')
        @JvmField
        val cmd_cellphone_basic = CommunityMaterialIcon("cmd_cellphone_basic", '\ue900')
        @JvmField
        val cmd_cellphone_dock = CommunityMaterialIcon("cmd_cellphone_dock", '\ue900')
        @JvmField
        val cmd_cellphone_erase = CommunityMaterialIcon("cmd_cellphone_erase", '\ue900')
        @JvmField
        val cmd_cellphone_information = CommunityMaterialIcon("cmd_cellphone_information", '\ue900')
        @JvmField
        val cmd_cellphone_iphone = CommunityMaterialIcon("cmd_cellphone_iphone", '\ue900')
        @JvmField
        val cmd_cellphone_key = CommunityMaterialIcon("cmd_cellphone_key", '\ue900')
        @JvmField
        val cmd_cellphone_link_off = CommunityMaterialIcon("cmd_cellphone_link_off", '\ue900')
        @JvmField
        val cmd_cellphone_link = CommunityMaterialIcon("cmd_cellphone_link", '\ue900')
        @JvmField
        val cmd_cellphone_lock = CommunityMaterialIcon("cmd_cellphone_lock", '\ue900')
        @JvmField
        val cmd_cellphone_message_off = CommunityMaterialIcon("cmd_cellphone_message_off", '\ue900')
        @JvmField
        val cmd_cellphone_message = CommunityMaterialIcon("cmd_cellphone_message", '\ue900')
        @JvmField
        val cmd_cellphone_nfc_off = CommunityMaterialIcon("cmd_cellphone_nfc_off", '\ue900')
        @JvmField
        val cmd_cellphone_nfc = CommunityMaterialIcon("cmd_cellphone_nfc", '\ue900')
        @JvmField
        val cmd_cellphone_off = CommunityMaterialIcon("cmd_cellphone_off", '\ue900')
        @JvmField
        val cmd_cellphone_play = CommunityMaterialIcon("cmd_cellphone_play", '\ue900')
        @JvmField
        val cmd_cellphone_screenshot = CommunityMaterialIcon("cmd_cellphone_screenshot", '\ue900')
        @JvmField
        val cmd_cellphone_settings_variant = CommunityMaterialIcon("cmd_cellphone_settings_variant", '\ue900')
        @JvmField
        val cmd_cellphone_settings = CommunityMaterialIcon("cmd_cellphone_settings", '\ue900')
        @JvmField
        val cmd_cellphone_sound = CommunityMaterialIcon("cmd_cellphone_sound", '\ue900')
        @JvmField
        val cmd_cellphone_text = CommunityMaterialIcon("cmd_cellphone_text", '\ue900')
        @JvmField
        val cmd_cellphone_wireless = CommunityMaterialIcon("cmd_cellphone_wireless", '\ue900')
        @JvmField
        val cmd_cellphone = CommunityMaterialIcon("cmd_cellphone", '\ue900')
        @JvmField
        val cmd_celtic_cross = CommunityMaterialIcon("cmd_celtic_cross", '\ue900')
        @JvmField
        val cmd_centos = CommunityMaterialIcon("cmd_centos", '\ue900')
        @JvmField
        val cmd_certificate_outline = CommunityMaterialIcon("cmd_certificate_outline", '\ue900')
        @JvmField
        val cmd_certificate = CommunityMaterialIcon("cmd_certificate", '\ue900')
        @JvmField
        val cmd_chair_rolling = CommunityMaterialIcon("cmd_chair_rolling", '\ue900')
        @JvmField
        val cmd_chair_school = CommunityMaterialIcon("cmd_chair_school", '\ue900')
        @JvmField
        val cmd_charity = CommunityMaterialIcon("cmd_charity", '\ue900')
        @JvmField
        val cmd_chart_arc = CommunityMaterialIcon("cmd_chart_arc", '\ue900')
        @JvmField
        val cmd_chart_areaspline_variant = CommunityMaterialIcon("cmd_chart_areaspline_variant", '\ue900')
        @JvmField
        val cmd_chart_areaspline = CommunityMaterialIcon("cmd_chart_areaspline", '\ue900')
        @JvmField
        val cmd_chart_bar_stacked = CommunityMaterialIcon("cmd_chart_bar_stacked", '\ue900')
        @JvmField
        val cmd_chart_bar = CommunityMaterialIcon("cmd_chart_bar", '\ue900')
        @JvmField
        val cmd_chart_bell_curve_cumulative = CommunityMaterialIcon("cmd_chart_bell_curve_cumulative", '\ue900')
        @JvmField
        val cmd_chart_bell_curve = CommunityMaterialIcon("cmd_chart_bell_curve", '\ue900')
        @JvmField
        val cmd_chart_bubble = CommunityMaterialIcon("cmd_chart_bubble", '\ue900')
        @JvmField
        val cmd_chart_donut_variant = CommunityMaterialIcon("cmd_chart_donut_variant", '\ue900')
        @JvmField
        val cmd_chart_donut = CommunityMaterialIcon("cmd_chart_donut", '\ue900')
        @JvmField
        val cmd_chart_gantt = CommunityMaterialIcon("cmd_chart_gantt", '\ue900')
        @JvmField
        val cmd_chart_histogram = CommunityMaterialIcon("cmd_chart_histogram", '\ue900')
        @JvmField
        val cmd_chart_line_stacked = CommunityMaterialIcon("cmd_chart_line_stacked", '\ue900')
        @JvmField
        val cmd_chart_line_variant = CommunityMaterialIcon("cmd_chart_line_variant", '\ue900')
        @JvmField
        val cmd_chart_line = CommunityMaterialIcon("cmd_chart_line", '\ue900')
        @JvmField
        val cmd_chart_multiline = CommunityMaterialIcon("cmd_chart_multiline", '\ue900')
        @JvmField
        val cmd_chart_multiple = CommunityMaterialIcon("cmd_chart_multiple", '\ue900')
        @JvmField
        val cmd_chart_pie = CommunityMaterialIcon("cmd_chart_pie", '\ue900')
        @JvmField
        val cmd_chart_scatter_plot_hexbin = CommunityMaterialIcon("cmd_chart_scatter_plot_hexbin", '\ue900')
        @JvmField
        val cmd_chart_scatter_plot = CommunityMaterialIcon("cmd_chart_scatter_plot", '\ue900')
        @JvmField
        val cmd_chart_snakey_variant = CommunityMaterialIcon("cmd_chart_snakey_variant", '\ue900')
        @JvmField
        val cmd_chart_snakey = CommunityMaterialIcon("cmd_chart_snakey", '\ue900')
        @JvmField
        val cmd_chart_timeline_variant = CommunityMaterialIcon("cmd_chart_timeline_variant", '\ue900')
        @JvmField
        val cmd_chart_timeline = CommunityMaterialIcon("cmd_chart_timeline", '\ue900')
        @JvmField
        val cmd_chart_tree = CommunityMaterialIcon("cmd_chart_tree", '\ue900')
        @JvmField
        val cmd_chat_alert_outline = CommunityMaterialIcon("cmd_chat_alert_outline", '\ue900')
        @JvmField
        val cmd_chat_alert = CommunityMaterialIcon("cmd_chat_alert", '\ue900')
        @JvmField
        val cmd_chat_outline = CommunityMaterialIcon("cmd_chat_outline", '\ue900')
        @JvmField
        val cmd_chat_processing_outline = CommunityMaterialIcon("cmd_chat_processing_outline", '\ue900')
        @JvmField
        val cmd_chat_processing = CommunityMaterialIcon("cmd_chat_processing", '\ue900')
        @JvmField
        val cmd_chat_sleep_outline = CommunityMaterialIcon("cmd_chat_sleep_outline", '\ue900')
        @JvmField
        val cmd_chat_sleep = CommunityMaterialIcon("cmd_chat_sleep", '\ue900')
        @JvmField
        val cmd_chat = CommunityMaterialIcon("cmd_chat", '\ue900')
        @JvmField
        val cmd_check_all = CommunityMaterialIcon("cmd_check_all", '\ue900')
        @JvmField
        val cmd_check_bold = CommunityMaterialIcon("cmd_check_bold", '\ue900')
        @JvmField
        val cmd_check_box_multiple_outline = CommunityMaterialIcon("cmd_check_box_multiple_outline", '\ue900')
        @JvmField
        val cmd_check_box_outline = CommunityMaterialIcon("cmd_check_box_outline", '\ue900')
        @JvmField
        val cmd_check_circle_outline = CommunityMaterialIcon("cmd_check_circle_outline", '\ue900')
        @JvmField
        val cmd_check_circle = CommunityMaterialIcon("cmd_check_circle", '\ue900')
        @JvmField
        val cmd_check_decagram = CommunityMaterialIcon("cmd_check_decagram", '\ue900')
        @JvmField
        val cmd_check_network_outline = CommunityMaterialIcon("cmd_check_network_outline", '\ue900')
        @JvmField
        val cmd_check_network = CommunityMaterialIcon("cmd_check_network", '\ue900')
        @JvmField
        val cmd_check_outline = CommunityMaterialIcon("cmd_check_outline", '\ue900')
        @JvmField
        val cmd_check_underline_circle_outline = CommunityMaterialIcon("cmd_check_underline_circle_outline", '\ue900')
        @JvmField
        val cmd_check_underline_circle = CommunityMaterialIcon("cmd_check_underline_circle", '\ue900')
        @JvmField
        val cmd_check_underline = CommunityMaterialIcon("cmd_check_underline", '\ue900')
        @JvmField
        val cmd_check = CommunityMaterialIcon("cmd_check", '\ue900')
        @JvmField
        val cmd_checkbook = CommunityMaterialIcon("cmd_checkbook", '\ue900')
        @JvmField
        val cmd_checkbox_blank_circle_outline = CommunityMaterialIcon("cmd_checkbox_blank_circle_outline", '\ue900')
        @JvmField
        val cmd_checkbox_blank_circle = CommunityMaterialIcon("cmd_checkbox_blank_circle", '\ue900')
        @JvmField
        val cmd_checkbox_blank_outline = CommunityMaterialIcon("cmd_checkbox_blank_outline", '\ue900')
        @JvmField
        val cmd_checkbox_blank = CommunityMaterialIcon("cmd_checkbox_blank", '\ue900')
        @JvmField
        val cmd_checkbox_intermediate = CommunityMaterialIcon("cmd_checkbox_intermediate", '\ue900')
        @JvmField
        val cmd_checkbox_marked_circle_outline = CommunityMaterialIcon("cmd_checkbox_marked_circle_outline", '\ue900')
        @JvmField
        val cmd_checkbox_marked_circle = CommunityMaterialIcon("cmd_checkbox_marked_circle", '\ue900')
        @JvmField
        val cmd_checkbox_marked_outline = CommunityMaterialIcon("cmd_checkbox_marked_outline", '\ue900')
        @JvmField
        val cmd_checkbox_marked = CommunityMaterialIcon("cmd_checkbox_marked", '\ue900')
        @JvmField
        val cmd_checkbox_multiple_blank_circle_outline =
                CommunityMaterialIcon("cmd_checkbox_multiple_blank_circle_outline", '\ue900')
        @JvmField
        val cmd_checkbox_multiple_blank_circle = CommunityMaterialIcon("cmd_checkbox_multiple_blank_circle", '\ue900')
        @JvmField
        val cmd_checkbox_multiple_blank_outline = CommunityMaterialIcon("cmd_checkbox_multiple_blank_outline", '\ue900')
        @JvmField
        val cmd_checkbox_multiple_blank = CommunityMaterialIcon("cmd_checkbox_multiple_blank", '\ue900')
        @JvmField
        val cmd_checkbox_multiple_marked_circle_outline =
                CommunityMaterialIcon("cmd_checkbox_multiple_marked_circle_outline", '\ue900')
        @JvmField
        val cmd_checkbox_multiple_marked_circle = CommunityMaterialIcon("cmd_checkbox_multiple_marked_circle", '\ue900')
        @JvmField
        val cmd_checkbox_multiple_marked_outline = CommunityMaterialIcon("cmd_checkbox_multiple_marked_outline", '\ue900')
        @JvmField
        val cmd_checkbox_multiple_marked = CommunityMaterialIcon("cmd_checkbox_multiple_marked", '\ue900')
        @JvmField
        val cmd_checkerboard_minus = CommunityMaterialIcon("cmd_checkerboard_minus", '\ue900')
        @JvmField
        val cmd_checkerboard_plus = CommunityMaterialIcon("cmd_checkerboard_plus", '\ue900')
        @JvmField
        val cmd_checkerboard_remove = CommunityMaterialIcon("cmd_checkerboard_remove", '\ue900')
        @JvmField
        val cmd_checkerboard = CommunityMaterialIcon("cmd_checkerboard", '\ue900')
        @JvmField
        val cmd_cheese = CommunityMaterialIcon("cmd_cheese", '\ue900')
        @JvmField
        val cmd_chef_hat = CommunityMaterialIcon("cmd_chef_hat", '\ue900')
        @JvmField
        val cmd_chemical_weapon = CommunityMaterialIcon("cmd_chemical_weapon", '\ue900')
        @JvmField
        val cmd_chess_bishop = CommunityMaterialIcon("cmd_chess_bishop", '\ue900')
        @JvmField
        val cmd_chess_king = CommunityMaterialIcon("cmd_chess_king", '\ue900')
        @JvmField
        val cmd_chess_knight = CommunityMaterialIcon("cmd_chess_knight", '\ue900')
        @JvmField
        val cmd_chess_pawn = CommunityMaterialIcon("cmd_chess_pawn", '\ue900')
        @JvmField
        val cmd_chess_queen = CommunityMaterialIcon("cmd_chess_queen", '\ue900')
        @JvmField
        val cmd_chess_rook = CommunityMaterialIcon("cmd_chess_rook", '\ue900')
        @JvmField
        val cmd_chevron_double_down = CommunityMaterialIcon("cmd_chevron_double_down", '\ue900')
        @JvmField
        val cmd_chevron_double_left = CommunityMaterialIcon("cmd_chevron_double_left", '\ue900')
        @JvmField
        val cmd_chevron_double_right = CommunityMaterialIcon("cmd_chevron_double_right", '\ue900')
        @JvmField
        val cmd_chevron_double_up = CommunityMaterialIcon("cmd_chevron_double_up", '\ue900')
        @JvmField
        val cmd_chevron_down_box_outline = CommunityMaterialIcon("cmd_chevron_down_box_outline", '\ue900')
        @JvmField
        val cmd_chevron_down_box = CommunityMaterialIcon("cmd_chevron_down_box", '\ue900')
        @JvmField
        val cmd_chevron_down_circle_outline = CommunityMaterialIcon("cmd_chevron_down_circle_outline", '\ue900')
        @JvmField
        val cmd_chevron_down_circle = CommunityMaterialIcon("cmd_chevron_down_circle", '\ue900')
        @JvmField
        val cmd_chevron_down = CommunityMaterialIcon("cmd_chevron_down", '\ue900')
        @JvmField
        val cmd_chevron_left_box_outline = CommunityMaterialIcon("cmd_chevron_left_box_outline", '\ue900')
        @JvmField
        val cmd_chevron_left_box = CommunityMaterialIcon("cmd_chevron_left_box", '\ue900')
        @JvmField
        val cmd_chevron_left_circle_outline = CommunityMaterialIcon("cmd_chevron_left_circle_outline", '\ue900')
        @JvmField
        val cmd_chevron_left_circle = CommunityMaterialIcon("cmd_chevron_left_circle", '\ue900')
        @JvmField
        val cmd_chevron_left = CommunityMaterialIcon("cmd_chevron_left", '\ue900')
        @JvmField
        val cmd_chevron_right_box_outline = CommunityMaterialIcon("cmd_chevron_right_box_outline", '\ue900')
        @JvmField
        val cmd_chevron_right_box = CommunityMaterialIcon("cmd_chevron_right_box", '\ue900')
        @JvmField
        val cmd_chevron_right_circle_outline = CommunityMaterialIcon("cmd_chevron_right_circle_outline", '\ue900')
        @JvmField
        val cmd_chevron_right_circle = CommunityMaterialIcon("cmd_chevron_right_circle", '\ue900')
        @JvmField
        val cmd_chevron_right = CommunityMaterialIcon("cmd_chevron_right", '\ue900')
        @JvmField
        val cmd_chevron_triple_down = CommunityMaterialIcon("cmd_chevron_triple_down", '\ue900')
        @JvmField
        val cmd_chevron_triple_left = CommunityMaterialIcon("cmd_chevron_triple_left", '\ue900')
        @JvmField
        val cmd_chevron_triple_right = CommunityMaterialIcon("cmd_chevron_triple_right", '\ue900')
        @JvmField
        val cmd_chevron_triple_up = CommunityMaterialIcon("cmd_chevron_triple_up", '\ue900')
        @JvmField
        val cmd_chevron_up_box_outline = CommunityMaterialIcon("cmd_chevron_up_box_outline", '\ue900')
        @JvmField
        val cmd_chevron_up_box = CommunityMaterialIcon("cmd_chevron_up_box", '\ue900')
        @JvmField
        val cmd_chevron_up_circle_outline = CommunityMaterialIcon("cmd_chevron_up_circle_outline", '\ue900')
        @JvmField
        val cmd_chevron_up_circle = CommunityMaterialIcon("cmd_chevron_up_circle", '\ue900')
        @JvmField
        val cmd_chevron_up = CommunityMaterialIcon("cmd_chevron_up", '\ue900')
        @JvmField
        val cmd_chili_hot = CommunityMaterialIcon("cmd_chili_hot", '\ue900')
        @JvmField
        val cmd_chili_medium = CommunityMaterialIcon("cmd_chili_medium", '\ue900')
        @JvmField
        val cmd_chili_mild = CommunityMaterialIcon("cmd_chili_mild", '\ue900')
        @JvmField
        val cmd_chip = CommunityMaterialIcon("cmd_chip", '\ue900')
        @JvmField
        val cmd_christianity_outline = CommunityMaterialIcon("cmd_christianity_outline", '\ue900')
        @JvmField
        val cmd_christianity = CommunityMaterialIcon("cmd_christianity", '\ue900')
        @JvmField
        val cmd_church = CommunityMaterialIcon("cmd_church", '\ue900')
        @JvmField
        val cmd_cigar = CommunityMaterialIcon("cmd_cigar", '\ue900')
        @JvmField
        val cmd_circle_double = CommunityMaterialIcon("cmd_circle_double", '\ue900')
        @JvmField
        val cmd_circle_edit_outline = CommunityMaterialIcon("cmd_circle_edit_outline", '\ue900')
        @JvmField
        val cmd_circle_expand = CommunityMaterialIcon("cmd_circle_expand", '\ue900')
        @JvmField
        val cmd_circle_medium = CommunityMaterialIcon("cmd_circle_medium", '\ue900')
        @JvmField
        val cmd_circle_off_outline = CommunityMaterialIcon("cmd_circle_off_outline", '\ue900')
        @JvmField
        val cmd_circle_outline = CommunityMaterialIcon("cmd_circle_outline", '\ue900')
        @JvmField
        val cmd_circle_slice_1 = CommunityMaterialIcon("cmd_circle_slice_1", '\ue900')
        @JvmField
        val cmd_circle_slice_2 = CommunityMaterialIcon("cmd_circle_slice_2", '\ue900')
        @JvmField
        val cmd_circle_slice_3 = CommunityMaterialIcon("cmd_circle_slice_3", '\ue900')
        @JvmField
        val cmd_circle_slice_4 = CommunityMaterialIcon("cmd_circle_slice_4", '\ue900')
        @JvmField
        val cmd_circle_slice_5 = CommunityMaterialIcon("cmd_circle_slice_5", '\ue900')
        @JvmField
        val cmd_circle_slice_6 = CommunityMaterialIcon("cmd_circle_slice_6", '\ue900')
        @JvmField
        val cmd_circle_slice_7 = CommunityMaterialIcon("cmd_circle_slice_7", '\ue900')
        @JvmField
        val cmd_circle_slice_8 = CommunityMaterialIcon("cmd_circle_slice_8", '\ue900')
        @JvmField
        val cmd_circle_small = CommunityMaterialIcon("cmd_circle_small", '\ue900')
        @JvmField
        val cmd_circle = CommunityMaterialIcon("cmd_circle", '\ue900')
        @JvmField
        val cmd_circular_saw = CommunityMaterialIcon("cmd_circular_saw", '\ue900')
        @JvmField
        val cmd_cisco_webex = CommunityMaterialIcon("cmd_cisco_webex", '\ue900')
        @JvmField
        val cmd_city_variant_outline = CommunityMaterialIcon("cmd_city_variant_outline", '\ue900')
        @JvmField
        val cmd_city_variant = CommunityMaterialIcon("cmd_city_variant", '\ue900')
        @JvmField
        val cmd_city = CommunityMaterialIcon("cmd_city", '\ue900')
        @JvmField
        val cmd_clipboard_account_outline = CommunityMaterialIcon("cmd_clipboard_account_outline", '\ue900')
        @JvmField
        val cmd_clipboard_account = CommunityMaterialIcon("cmd_clipboard_account", '\ue900')
        @JvmField
        val cmd_clipboard_alert_outline = CommunityMaterialIcon("cmd_clipboard_alert_outline", '\ue900')
        @JvmField
        val cmd_clipboard_alert = CommunityMaterialIcon("cmd_clipboard_alert", '\ue900')
        @JvmField
        val cmd_clipboard_arrow_down_outline = CommunityMaterialIcon("cmd_clipboard_arrow_down_outline", '\ue900')
        @JvmField
        val cmd_clipboard_arrow_down = CommunityMaterialIcon("cmd_clipboard_arrow_down", '\ue900')
        @JvmField
        val cmd_clipboard_arrow_left_outline = CommunityMaterialIcon("cmd_clipboard_arrow_left_outline", '\ue900')
        @JvmField
        val cmd_clipboard_arrow_left = CommunityMaterialIcon("cmd_clipboard_arrow_left", '\ue900')
        @JvmField
        val cmd_clipboard_arrow_right_outline = CommunityMaterialIcon("cmd_clipboard_arrow_right_outline", '\ue900')
        @JvmField
        val cmd_clipboard_arrow_right = CommunityMaterialIcon("cmd_clipboard_arrow_right", '\ue900')
        @JvmField
        val cmd_clipboard_arrow_up_outline = CommunityMaterialIcon("cmd_clipboard_arrow_up_outline", '\ue900')
        @JvmField
        val cmd_clipboard_arrow_up = CommunityMaterialIcon("cmd_clipboard_arrow_up", '\ue900')
        @JvmField
        val cmd_clipboard_check_multiple_outline = CommunityMaterialIcon("cmd_clipboard_check_multiple_outline", '\ue900')
        @JvmField
        val cmd_clipboard_check_multiple = CommunityMaterialIcon("cmd_clipboard_check_multiple", '\ue900')
        @JvmField
        val cmd_clipboard_check_outline = CommunityMaterialIcon("cmd_clipboard_check_outline", '\ue900')
        @JvmField
        val cmd_clipboard_check = CommunityMaterialIcon("cmd_clipboard_check", '\ue900')
        @JvmField
        val cmd_clipboard_file_outline = CommunityMaterialIcon("cmd_clipboard_file_outline", '\ue900')
        @JvmField
        val cmd_clipboard_file = CommunityMaterialIcon("cmd_clipboard_file", '\ue900')
        @JvmField
        val cmd_clipboard_flow_outline = CommunityMaterialIcon("cmd_clipboard_flow_outline", '\ue900')
        @JvmField
        val cmd_clipboard_flow = CommunityMaterialIcon("cmd_clipboard_flow", '\ue900')
        @JvmField
        val cmd_clipboard_list_outline = CommunityMaterialIcon("cmd_clipboard_list_outline", '\ue900')
        @JvmField
        val cmd_clipboard_list = CommunityMaterialIcon("cmd_clipboard_list", '\ue900')
        @JvmField
        val cmd_clipboard_multiple_outline = CommunityMaterialIcon("cmd_clipboard_multiple_outline", '\ue900')
        @JvmField
        val cmd_clipboard_multiple = CommunityMaterialIcon("cmd_clipboard_multiple", '\ue900')
        @JvmField
        val cmd_clipboard_outline = CommunityMaterialIcon("cmd_clipboard_outline", '\ue900')
        @JvmField
        val cmd_clipboard_play_multiple_outline = CommunityMaterialIcon("cmd_clipboard_play_multiple_outline", '\ue900')
        @JvmField
        val cmd_clipboard_play_multiple = CommunityMaterialIcon("cmd_clipboard_play_multiple", '\ue900')
        @JvmField
        val cmd_clipboard_play_outline = CommunityMaterialIcon("cmd_clipboard_play_outline", '\ue900')
        @JvmField
        val cmd_clipboard_play = CommunityMaterialIcon("cmd_clipboard_play", '\ue900')
        @JvmField
        val cmd_clipboard_plus = CommunityMaterialIcon("cmd_clipboard_plus", '\ue900')
        @JvmField
        val cmd_clipboard_pulse_outline = CommunityMaterialIcon("cmd_clipboard_pulse_outline", '\ue900')
        @JvmField
        val cmd_clipboard_pulse = CommunityMaterialIcon("cmd_clipboard_pulse", '\ue900')
        @JvmField
        val cmd_clipboard_text_multiple_outline = CommunityMaterialIcon("cmd_clipboard_text_multiple_outline", '\ue900')
        @JvmField
        val cmd_clipboard_text_multiple = CommunityMaterialIcon("cmd_clipboard_text_multiple", '\ue900')
        @JvmField
        val cmd_clipboard_text_outline = CommunityMaterialIcon("cmd_clipboard_text_outline", '\ue900')
        @JvmField
        val cmd_clipboard_text_play_outline = CommunityMaterialIcon("cmd_clipboard_text_play_outline", '\ue900')
        @JvmField
        val cmd_clipboard_text_play = CommunityMaterialIcon("cmd_clipboard_text_play", '\ue900')
        @JvmField
        val cmd_clipboard_text = CommunityMaterialIcon("cmd_clipboard_text", '\ue900')
        @JvmField
        val cmd_clipboard = CommunityMaterialIcon("cmd_clipboard", '\ue900')
        @JvmField
        val cmd_clippy = CommunityMaterialIcon("cmd_clippy", '\ue900')
        @JvmField
        val cmd_clock_alert_outline = CommunityMaterialIcon("cmd_clock_alert_outline", '\ue900')
        @JvmField
        val cmd_clock_alert = CommunityMaterialIcon("cmd_clock_alert", '\ue900')
        @JvmField
        val cmd_clock_check_outline = CommunityMaterialIcon("cmd_clock_check_outline", '\ue900')
        @JvmField
        val cmd_clock_check = CommunityMaterialIcon("cmd_clock_check", '\ue900')
        @JvmField
        val cmd_clock_digital = CommunityMaterialIcon("cmd_clock_digital", '\ue900')
        @JvmField
        val cmd_clock_end = CommunityMaterialIcon("cmd_clock_end", '\ue900')
        @JvmField
        val cmd_clock_fast = CommunityMaterialIcon("cmd_clock_fast", '\ue900')
        @JvmField
        val cmd_clock_in = CommunityMaterialIcon("cmd_clock_in", '\ue900')
        @JvmField
        val cmd_clock_out = CommunityMaterialIcon("cmd_clock_out", '\ue900')
        @JvmField
        val cmd_clock_outline = CommunityMaterialIcon("cmd_clock_outline", '\ue900')
        @JvmField
        val cmd_clock_start = CommunityMaterialIcon("cmd_clock_start", '\ue900')
        @JvmField
        val cmd_clock = CommunityMaterialIcon("cmd_clock", '\ue900')
        @JvmField
        val cmd_close_box_multiple_outline = CommunityMaterialIcon("cmd_close_box_multiple_outline", '\ue900')
        @JvmField
        val cmd_close_box_multiple = CommunityMaterialIcon("cmd_close_box_multiple", '\ue900')
        @JvmField
        val cmd_close_box_outline = CommunityMaterialIcon("cmd_close_box_outline", '\ue900')
        @JvmField
        val cmd_close_box = CommunityMaterialIcon("cmd_close_box", '\ue900')
        @JvmField
        val cmd_close_circle_outline = CommunityMaterialIcon("cmd_close_circle_outline", '\ue900')
        @JvmField
        val cmd_close_circle = CommunityMaterialIcon("cmd_close_circle", '\ue900')
        @JvmField
        val cmd_close_network_outline = CommunityMaterialIcon("cmd_close_network_outline", '\ue900')
        @JvmField
        val cmd_close_network = CommunityMaterialIcon("cmd_close_network", '\ue900')
        @JvmField
        val cmd_close_octagon_outline = CommunityMaterialIcon("cmd_close_octagon_outline", '\ue900')
        @JvmField
        val cmd_close_octagon = CommunityMaterialIcon("cmd_close_octagon", '\ue900')
        @JvmField
        val cmd_close_outline = CommunityMaterialIcon("cmd_close_outline", '\ue900')
        @JvmField
        val cmd_close = CommunityMaterialIcon("cmd_close", '\ue900')
        @JvmField
        val cmd_closed_caption_outline = CommunityMaterialIcon("cmd_closed_caption_outline", '\ue900')
        @JvmField
        val cmd_closed_caption = CommunityMaterialIcon("cmd_closed_caption", '\ue900')
        @JvmField
        val cmd_cloud_alert = CommunityMaterialIcon("cmd_cloud_alert", '\ue900')
        @JvmField
        val cmd_cloud_braces = CommunityMaterialIcon("cmd_cloud_braces", '\ue900')
        @JvmField
        val cmd_cloud_check_outline = CommunityMaterialIcon("cmd_cloud_check_outline", '\ue900')
        @JvmField
        val cmd_cloud_check = CommunityMaterialIcon("cmd_cloud_check", '\ue900')
        @JvmField
        val cmd_cloud_circle = CommunityMaterialIcon("cmd_cloud_circle", '\ue900')
        @JvmField
        val cmd_cloud_download_outline = CommunityMaterialIcon("cmd_cloud_download_outline", '\ue900')
        @JvmField
        val cmd_cloud_download = CommunityMaterialIcon("cmd_cloud_download", '\ue900')
        @JvmField
        val cmd_cloud_lock_outline = CommunityMaterialIcon("cmd_cloud_lock_outline", '\ue900')
        @JvmField
        val cmd_cloud_lock = CommunityMaterialIcon("cmd_cloud_lock", '\ue900')
        @JvmField
        val cmd_cloud_off_outline = CommunityMaterialIcon("cmd_cloud_off_outline", '\ue900')
        @JvmField
        val cmd_cloud_outline = CommunityMaterialIcon("cmd_cloud_outline", '\ue900')
        @JvmField
        val cmd_cloud_print_outline = CommunityMaterialIcon("cmd_cloud_print_outline", '\ue900')
        @JvmField
        val cmd_cloud_print = CommunityMaterialIcon("cmd_cloud_print", '\ue900')
        @JvmField
        val cmd_cloud_question = CommunityMaterialIcon("cmd_cloud_question", '\ue900')
        @JvmField
        val cmd_cloud_search_outline = CommunityMaterialIcon("cmd_cloud_search_outline", '\ue900')
        @JvmField
        val cmd_cloud_search = CommunityMaterialIcon("cmd_cloud_search", '\ue900')
        @JvmField
        val cmd_cloud_sync_outline = CommunityMaterialIcon("cmd_cloud_sync_outline", '\ue900')
        @JvmField
        val cmd_cloud_sync = CommunityMaterialIcon("cmd_cloud_sync", '\ue900')
        @JvmField
        val cmd_cloud_tags = CommunityMaterialIcon("cmd_cloud_tags", '\ue900')
        @JvmField
        val cmd_cloud_upload_outline = CommunityMaterialIcon("cmd_cloud_upload_outline", '\ue900')
        @JvmField
        val cmd_cloud_upload = CommunityMaterialIcon("cmd_cloud_upload", '\ue900')
        @JvmField
        val cmd_cloud = CommunityMaterialIcon("cmd_cloud", '\ue900')
        @JvmField
        val cmd_clover = CommunityMaterialIcon("cmd_clover", '\ue900')
        @JvmField
        val cmd_coach_lamp = CommunityMaterialIcon("cmd_coach_lamp", '\ue900')
        @JvmField
        val cmd_coat_rack = CommunityMaterialIcon("cmd_coat_rack", '\ue900')
        @JvmField
        val cmd_code_array = CommunityMaterialIcon("cmd_code_array", '\ue900')
        @JvmField
        val cmd_code_braces_box = CommunityMaterialIcon("cmd_code_braces_box", '\ue900')
        @JvmField
        val cmd_code_braces = CommunityMaterialIcon("cmd_code_braces", '\ue900')
        @JvmField
        val cmd_code_brackets = CommunityMaterialIcon("cmd_code_brackets", '\ue900')
        @JvmField
        val cmd_code_equal = CommunityMaterialIcon("cmd_code_equal", '\ue900')
        @JvmField
        val cmd_code_greater_than_or_equal = CommunityMaterialIcon("cmd_code_greater_than_or_equal", '\ue900')
        @JvmField
        val cmd_code_greater_than = CommunityMaterialIcon("cmd_code_greater_than", '\ue900')
        @JvmField
        val cmd_code_less_than_or_equal = CommunityMaterialIcon("cmd_code_less_than_or_equal", '\ue900')
        @JvmField
        val cmd_code_less_than = CommunityMaterialIcon("cmd_code_less_than", '\ue900')
        @JvmField
        val cmd_code_not_equal_variant = CommunityMaterialIcon("cmd_code_not_equal_variant", '\ue900')
        @JvmField
        val cmd_code_not_equal = CommunityMaterialIcon("cmd_code_not_equal", '\ue900')
        @JvmField
        val cmd_code_parentheses_box = CommunityMaterialIcon("cmd_code_parentheses_box", '\ue900')
        @JvmField
        val cmd_code_parentheses = CommunityMaterialIcon("cmd_code_parentheses", '\ue900')
        @JvmField
        val cmd_code_string = CommunityMaterialIcon("cmd_code_string", '\ue900')
        @JvmField
        val cmd_code_tags_check = CommunityMaterialIcon("cmd_code_tags_check", '\ue900')
        @JvmField
        val cmd_code_tags = CommunityMaterialIcon("cmd_code_tags", '\ue900')
        @JvmField
        val cmd_codepen = CommunityMaterialIcon("cmd_codepen", '\ue900')
        @JvmField
        val cmd_coffee_maker = CommunityMaterialIcon("cmd_coffee_maker", '\ue900')
        @JvmField
        val cmd_coffee_off_outline = CommunityMaterialIcon("cmd_coffee_off_outline", '\ue900')
        @JvmField
        val cmd_coffee_off = CommunityMaterialIcon("cmd_coffee_off", '\ue900')
        @JvmField
        val cmd_coffee_outline = CommunityMaterialIcon("cmd_coffee_outline", '\ue900')
        @JvmField
        val cmd_coffee_to_go = CommunityMaterialIcon("cmd_coffee_to_go", '\ue900')
        @JvmField
        val cmd_coffee = CommunityMaterialIcon("cmd_coffee", '\ue900')
        @JvmField
        val cmd_coffin = CommunityMaterialIcon("cmd_coffin", '\ue900')
        @JvmField
        val cmd_cog_clockwise = CommunityMaterialIcon("cmd_cog_clockwise", '\ue900')
        @JvmField
        val cmd_cog_counterclockwise = CommunityMaterialIcon("cmd_cog_counterclockwise", '\ue900')
        @JvmField
        val cmd_cogs = CommunityMaterialIcon("cmd_cogs", '\ue900')
        @JvmField
        val cmd_coin_outline = CommunityMaterialIcon("cmd_coin_outline", '\ue900')
        @JvmField
        val cmd_coin = CommunityMaterialIcon("cmd_coin", '\ue900')
        @JvmField
        val cmd_coins = CommunityMaterialIcon("cmd_coins", '\ue900')
        @JvmField
        val cmd_collage = CommunityMaterialIcon("cmd_collage", '\ue900')
        @JvmField
        val cmd_collapse_all_outline = CommunityMaterialIcon("cmd_collapse_all_outline", '\ue900')
        @JvmField
        val cmd_collapse_all = CommunityMaterialIcon("cmd_collapse_all", '\ue900')
        @JvmField
        val cmd_color_helper = CommunityMaterialIcon("cmd_color_helper", '\ue900')
        @JvmField
        val cmd_comma_box_outline = CommunityMaterialIcon("cmd_comma_box_outline", '\ue900')
        @JvmField
        val cmd_comma_box = CommunityMaterialIcon("cmd_comma_box", '\ue900')
        @JvmField
        val cmd_comma_circle_outline = CommunityMaterialIcon("cmd_comma_circle_outline", '\ue900')
        @JvmField
        val cmd_comma_circle = CommunityMaterialIcon("cmd_comma_circle", '\ue900')
        @JvmField
        val cmd_comma = CommunityMaterialIcon("cmd_comma", '\ue900')
        @JvmField
        val cmd_comment_account_outline = CommunityMaterialIcon("cmd_comment_account_outline", '\ue900')
        @JvmField
        val cmd_comment_account = CommunityMaterialIcon("cmd_comment_account", '\ue900')
        @JvmField
        val cmd_comment_alert_outline = CommunityMaterialIcon("cmd_comment_alert_outline", '\ue900')
        @JvmField
        val cmd_comment_alert = CommunityMaterialIcon("cmd_comment_alert", '\ue900')
        @JvmField
        val cmd_comment_arrow_left_outline = CommunityMaterialIcon("cmd_comment_arrow_left_outline", '\ue900')
        @JvmField
        val cmd_comment_arrow_left = CommunityMaterialIcon("cmd_comment_arrow_left", '\ue900')
        @JvmField
        val cmd_comment_arrow_right_outline = CommunityMaterialIcon("cmd_comment_arrow_right_outline", '\ue900')
        @JvmField
        val cmd_comment_arrow_right = CommunityMaterialIcon("cmd_comment_arrow_right", '\ue900')
        @JvmField
        val cmd_comment_check_outline = CommunityMaterialIcon("cmd_comment_check_outline", '\ue900')
        @JvmField
        val cmd_comment_check = CommunityMaterialIcon("cmd_comment_check", '\ue900')
        @JvmField
        val cmd_comment_edit_outline = CommunityMaterialIcon("cmd_comment_edit_outline", '\ue900')
        @JvmField
        val cmd_comment_edit = CommunityMaterialIcon("cmd_comment_edit", '\ue900')
        @JvmField
        val cmd_comment_eye_outline = CommunityMaterialIcon("cmd_comment_eye_outline", '\ue900')
        @JvmField
        val cmd_comment_eye = CommunityMaterialIcon("cmd_comment_eye", '\ue900')
        @JvmField
        val cmd_comment_multiple_outline = CommunityMaterialIcon("cmd_comment_multiple_outline", '\ue900')
        @JvmField
        val cmd_comment_multiple = CommunityMaterialIcon("cmd_comment_multiple", '\ue900')
        @JvmField
        val cmd_comment_outline = CommunityMaterialIcon("cmd_comment_outline", '\ue900')
        @JvmField
        val cmd_comment_plus_outline = CommunityMaterialIcon("cmd_comment_plus_outline", '\ue900')
        @JvmField
        val cmd_comment_plus = CommunityMaterialIcon("cmd_comment_plus", '\ue900')
        @JvmField
        val cmd_comment_processing_outline = CommunityMaterialIcon("cmd_comment_processing_outline", '\ue900')
        @JvmField
        val cmd_comment_processing = CommunityMaterialIcon("cmd_comment_processing", '\ue900')
        @JvmField
        val cmd_comment_question_outline = CommunityMaterialIcon("cmd_comment_question_outline", '\ue900')
        @JvmField
        val cmd_comment_question = CommunityMaterialIcon("cmd_comment_question", '\ue900')
        @JvmField
        val cmd_comment_quote_outline = CommunityMaterialIcon("cmd_comment_quote_outline", '\ue900')
        @JvmField
        val cmd_comment_quote = CommunityMaterialIcon("cmd_comment_quote", '\ue900')
        @JvmField
        val cmd_comment_remove_outline = CommunityMaterialIcon("cmd_comment_remove_outline", '\ue900')
        @JvmField
        val cmd_comment_remove = CommunityMaterialIcon("cmd_comment_remove", '\ue900')
        @JvmField
        val cmd_comment_search_outline = CommunityMaterialIcon("cmd_comment_search_outline", '\ue900')
        @JvmField
        val cmd_comment_search = CommunityMaterialIcon("cmd_comment_search", '\ue900')
        @JvmField
        val cmd_comment_text_multiple_outline = CommunityMaterialIcon("cmd_comment_text_multiple_outline", '\ue900')
        @JvmField
        val cmd_comment_text_multiple = CommunityMaterialIcon("cmd_comment_text_multiple", '\ue900')
        @JvmField
        val cmd_comment_text_outline = CommunityMaterialIcon("cmd_comment_text_outline", '\ue900')
        @JvmField
        val cmd_comment_text = CommunityMaterialIcon("cmd_comment_text", '\ue900')
        @JvmField
        val cmd_comment = CommunityMaterialIcon("cmd_comment", '\ue900')
        @JvmField
        val cmd_compare = CommunityMaterialIcon("cmd_compare", '\ue900')
        @JvmField
        val cmd_compass_off_outline = CommunityMaterialIcon("cmd_compass_off_outline", '\ue900')
        @JvmField
        val cmd_compass_off = CommunityMaterialIcon("cmd_compass_off", '\ue900')
        @JvmField
        val cmd_compass_outline = CommunityMaterialIcon("cmd_compass_outline", '\ue900')
        @JvmField
        val cmd_compass = CommunityMaterialIcon("cmd_compass", '\ue900')
        @JvmField
        val cmd_concourse_ci = CommunityMaterialIcon("cmd_concourse_ci", '\ue900')
        @JvmField
        val cmd_console_line = CommunityMaterialIcon("cmd_console_line", '\ue900')
        @JvmField
        val cmd_console_network_outline = CommunityMaterialIcon("cmd_console_network_outline", '\ue900')
        @JvmField
        val cmd_console_network = CommunityMaterialIcon("cmd_console_network", '\ue900')
        @JvmField
        val cmd_console = CommunityMaterialIcon("cmd_console", '\ue900')
        @JvmField
        val cmd_consolidate = CommunityMaterialIcon("cmd_consolidate", '\ue900')
        @JvmField
        val cmd_contact_mail_outline = CommunityMaterialIcon("cmd_contact_mail_outline", '\ue900')
        @JvmField
        val cmd_contact_mail = CommunityMaterialIcon("cmd_contact_mail", '\ue900')
        @JvmField
        val cmd_contact_phone_outline = CommunityMaterialIcon("cmd_contact_phone_outline", '\ue900')
        @JvmField
        val cmd_contact_phone = CommunityMaterialIcon("cmd_contact_phone", '\ue900')
        @JvmField
        val cmd_contactless_payment = CommunityMaterialIcon("cmd_contactless_payment", '\ue900')
        @JvmField
        val cmd_contacts = CommunityMaterialIcon("cmd_contacts", '\ue900')
        @JvmField
        val cmd_contain_end = CommunityMaterialIcon("cmd_contain_end", '\ue900')
        @JvmField
        val cmd_contain_start = CommunityMaterialIcon("cmd_contain_start", '\ue900')
        @JvmField
        val cmd_contain = CommunityMaterialIcon("cmd_contain", '\ue900')
        @JvmField
        val cmd_content_copy = CommunityMaterialIcon("cmd_content_copy", '\ue900')
        @JvmField
        val cmd_content_cut = CommunityMaterialIcon("cmd_content_cut", '\ue900')
        @JvmField
        val cmd_content_duplicate = CommunityMaterialIcon("cmd_content_duplicate", '\ue900')
        @JvmField
        val cmd_content_paste = CommunityMaterialIcon("cmd_content_paste", '\ue900')
        @JvmField
        val cmd_content_save_alert_outline = CommunityMaterialIcon("cmd_content_save_alert_outline", '\ue900')
        @JvmField
        val cmd_content_save_alert = CommunityMaterialIcon("cmd_content_save_alert", '\ue900')
        @JvmField
        val cmd_content_save_all_outline = CommunityMaterialIcon("cmd_content_save_all_outline", '\ue900')
        @JvmField
        val cmd_content_save_all = CommunityMaterialIcon("cmd_content_save_all", '\ue900')
        @JvmField
        val cmd_content_save_edit_outline = CommunityMaterialIcon("cmd_content_save_edit_outline", '\ue900')
        @JvmField
        val cmd_content_save_edit = CommunityMaterialIcon("cmd_content_save_edit", '\ue900')
        @JvmField
        val cmd_content_save_move_outline = CommunityMaterialIcon("cmd_content_save_move_outline", '\ue900')
        @JvmField
        val cmd_content_save_move = CommunityMaterialIcon("cmd_content_save_move", '\ue900')
        @JvmField
        val cmd_content_save_outline = CommunityMaterialIcon("cmd_content_save_outline", '\ue900')
        @JvmField
        val cmd_content_save_settings_outline = CommunityMaterialIcon("cmd_content_save_settings_outline", '\ue900')
        @JvmField
        val cmd_content_save_settings = CommunityMaterialIcon("cmd_content_save_settings", '\ue900')
        @JvmField
        val cmd_content_save = CommunityMaterialIcon("cmd_content_save", '\ue900')
        @JvmField
        val cmd_contrast_box = CommunityMaterialIcon("cmd_contrast_box", '\ue900')
        @JvmField
        val cmd_contrast_circle = CommunityMaterialIcon("cmd_contrast_circle", '\ue900')
        @JvmField
        val cmd_contrast = CommunityMaterialIcon("cmd_contrast", '\ue900')
        @JvmField
        val cmd_controller_classic_outline = CommunityMaterialIcon("cmd_controller_classic_outline", '\ue900')
        @JvmField
        val cmd_controller_classic = CommunityMaterialIcon("cmd_controller_classic", '\ue900')
        @JvmField
        val cmd_cookie = CommunityMaterialIcon("cmd_cookie", '\ue900')
        @JvmField
        val cmd_coolant_temperature = CommunityMaterialIcon("cmd_coolant_temperature", '\ue900')
        @JvmField
        val cmd_copyright = CommunityMaterialIcon("cmd_copyright", '\ue900')
        @JvmField
        val cmd_cordova = CommunityMaterialIcon("cmd_cordova", '\ue900')
        @JvmField
        val cmd_corn = CommunityMaterialIcon("cmd_corn", '\ue900')
        @JvmField
        val cmd_counter = CommunityMaterialIcon("cmd_counter", '\ue900')
        @JvmField
        val cmd_cow = CommunityMaterialIcon("cmd_cow", '\ue900')
        @JvmField
        val cmd_cowboy = CommunityMaterialIcon("cmd_cowboy", '\ue900')
        @JvmField
        val cmd_cpu_32_bit = CommunityMaterialIcon("cmd_cpu_32_bit", '\ue900')
        @JvmField
        val cmd_cpu_64_bit = CommunityMaterialIcon("cmd_cpu_64_bit", '\ue900')
        @JvmField
        val cmd_crane = CommunityMaterialIcon("cmd_crane", '\ue900')
        @JvmField
        val cmd_creation = CommunityMaterialIcon("cmd_creation", '\ue900')
        @JvmField
        val cmd_creative_commons = CommunityMaterialIcon("cmd_creative_commons", '\ue900')
        @JvmField
        val cmd_credit_card_clock_outline = CommunityMaterialIcon("cmd_credit_card_clock_outline", '\ue900')
        @JvmField
        val cmd_credit_card_clock = CommunityMaterialIcon("cmd_credit_card_clock", '\ue900')
        @JvmField
        val cmd_credit_card_marker_outline = CommunityMaterialIcon("cmd_credit_card_marker_outline", '\ue900')
        @JvmField
        val cmd_credit_card_marker = CommunityMaterialIcon("cmd_credit_card_marker", '\ue900')
        @JvmField
        val cmd_credit_card_minus_outline = CommunityMaterialIcon("cmd_credit_card_minus_outline", '\ue900')
        @JvmField
        val cmd_credit_card_minus = CommunityMaterialIcon("cmd_credit_card_minus", '\ue900')
        @JvmField
        val cmd_credit_card_multiple_outline = CommunityMaterialIcon("cmd_credit_card_multiple_outline", '\ue900')
        @JvmField
        val cmd_credit_card_multiple = CommunityMaterialIcon("cmd_credit_card_multiple", '\ue900')
        @JvmField
        val cmd_credit_card_off_outline = CommunityMaterialIcon("cmd_credit_card_off_outline", '\ue900')
        @JvmField
        val cmd_credit_card_off = CommunityMaterialIcon("cmd_credit_card_off", '\ue900')
        @JvmField
        val cmd_credit_card_outline = CommunityMaterialIcon("cmd_credit_card_outline", '\ue900')
        @JvmField
        val cmd_credit_card_plus_outline = CommunityMaterialIcon("cmd_credit_card_plus_outline", '\ue900')
        @JvmField
        val cmd_credit_card_plus = CommunityMaterialIcon("cmd_credit_card_plus", '\ue900')
        @JvmField
        val cmd_credit_card_refund_outline = CommunityMaterialIcon("cmd_credit_card_refund_outline", '\ue900')
        @JvmField
        val cmd_credit_card_refund = CommunityMaterialIcon("cmd_credit_card_refund", '\ue900')
        @JvmField
        val cmd_credit_card_remove_outline = CommunityMaterialIcon("cmd_credit_card_remove_outline", '\ue900')
        @JvmField
        val cmd_credit_card_remove = CommunityMaterialIcon("cmd_credit_card_remove", '\ue900')
        @JvmField
        val cmd_credit_card_scan_outline = CommunityMaterialIcon("cmd_credit_card_scan_outline", '\ue900')
        @JvmField
        val cmd_credit_card_scan = CommunityMaterialIcon("cmd_credit_card_scan", '\ue900')
        @JvmField
        val cmd_credit_card_settings_outline = CommunityMaterialIcon("cmd_credit_card_settings_outline", '\ue900')
        @JvmField
        val cmd_credit_card_settings = CommunityMaterialIcon("cmd_credit_card_settings", '\ue900')
        @JvmField
        val cmd_credit_card_wireless_outline = CommunityMaterialIcon("cmd_credit_card_wireless_outline", '\ue900')
        @JvmField
        val cmd_credit_card_wireless = CommunityMaterialIcon("cmd_credit_card_wireless", '\ue900')
        @JvmField
        val cmd_credit_card = CommunityMaterialIcon("cmd_credit_card", '\ue900')
        @JvmField
        val cmd_cricket = CommunityMaterialIcon("cmd_cricket", '\ue900')
        @JvmField
        val cmd_crop_free = CommunityMaterialIcon("cmd_crop_free", '\ue900')
        @JvmField
        val cmd_crop_landscape = CommunityMaterialIcon("cmd_crop_landscape", '\ue900')
        @JvmField
        val cmd_crop_portrait = CommunityMaterialIcon("cmd_crop_portrait", '\ue900')
        @JvmField
        val cmd_crop_rotate = CommunityMaterialIcon("cmd_crop_rotate", '\ue900')
        @JvmField
        val cmd_crop_square = CommunityMaterialIcon("cmd_crop_square", '\ue900')
        @JvmField
        val cmd_crop = CommunityMaterialIcon("cmd_crop", '\ue900')
        @JvmField
        val cmd_crosshairs_gps = CommunityMaterialIcon("cmd_crosshairs_gps", '\ue900')
        @JvmField
        val cmd_crosshairs_off = CommunityMaterialIcon("cmd_crosshairs_off", '\ue900')
        @JvmField
        val cmd_crosshairs_question = CommunityMaterialIcon("cmd_crosshairs_question", '\ue900')
        @JvmField
        val cmd_crosshairs = CommunityMaterialIcon("cmd_crosshairs", '\ue900')
        @JvmField
        val cmd_crown_outline = CommunityMaterialIcon("cmd_crown_outline", '\ue900')
        @JvmField
        val cmd_crown = CommunityMaterialIcon("cmd_crown", '\ue900')
        @JvmField
        val cmd_cryengine = CommunityMaterialIcon("cmd_cryengine", '\ue900')
        @JvmField
        val cmd_crystal_ball = CommunityMaterialIcon("cmd_crystal_ball", '\ue900')
        @JvmField
        val cmd_cube_outline = CommunityMaterialIcon("cmd_cube_outline", '\ue900')
        @JvmField
        val cmd_cube_scan = CommunityMaterialIcon("cmd_cube_scan", '\ue900')
        @JvmField
        val cmd_cube_send = CommunityMaterialIcon("cmd_cube_send", '\ue900')
        @JvmField
        val cmd_cube_unfolded = CommunityMaterialIcon("cmd_cube_unfolded", '\ue900')
        @JvmField
        val cmd_cube = CommunityMaterialIcon("cmd_cube", '\ue900')
        @JvmField
        val cmd_cup_off = CommunityMaterialIcon("cmd_cup_off", '\ue900')
        @JvmField
        val cmd_cup_water = CommunityMaterialIcon("cmd_cup_water", '\ue900')
        @JvmField
        val cmd_cup = CommunityMaterialIcon("cmd_cup", '\ue900')
        @JvmField
        val cmd_cupboard_outline = CommunityMaterialIcon("cmd_cupboard_outline", '\ue900')
        @JvmField
        val cmd_cupboard = CommunityMaterialIcon("cmd_cupboard", '\ue900')
        @JvmField
        val cmd_cupcake = CommunityMaterialIcon("cmd_cupcake", '\ue900')
        @JvmField
        val cmd_curling = CommunityMaterialIcon("cmd_curling", '\ue900')
        @JvmField
        val cmd_currency_bdt = CommunityMaterialIcon("cmd_currency_bdt", '\ue900')
        @JvmField
        val cmd_currency_brl = CommunityMaterialIcon("cmd_currency_brl", '\ue900')
        @JvmField
        val cmd_currency_btc = CommunityMaterialIcon("cmd_currency_btc", '\ue900')
        @JvmField
        val cmd_currency_cny = CommunityMaterialIcon("cmd_currency_cny", '\ue900')
        @JvmField
        val cmd_currency_eth = CommunityMaterialIcon("cmd_currency_eth", '\ue900')
        @JvmField
        val cmd_currency_eur = CommunityMaterialIcon("cmd_currency_eur", '\ue900')
        @JvmField
        val cmd_currency_gbp = CommunityMaterialIcon("cmd_currency_gbp", '\ue900')
        @JvmField
        val cmd_currency_ils = CommunityMaterialIcon("cmd_currency_ils", '\ue900')
        @JvmField
        val cmd_currency_inr = CommunityMaterialIcon("cmd_currency_inr", '\ue900')
        @JvmField
        val cmd_currency_jpy = CommunityMaterialIcon("cmd_currency_jpy", '\ue900')
        @JvmField
        val cmd_currency_krw = CommunityMaterialIcon("cmd_currency_krw", '\ue900')
        @JvmField
        val cmd_currency_kzt = CommunityMaterialIcon("cmd_currency_kzt", '\ue900')
        @JvmField
        val cmd_currency_ngn = CommunityMaterialIcon("cmd_currency_ngn", '\ue900')
        @JvmField
        val cmd_currency_php = CommunityMaterialIcon("cmd_currency_php", '\ue900')
        @JvmField
        val cmd_currency_rial = CommunityMaterialIcon("cmd_currency_rial", '\ue900')
        @JvmField
        val cmd_currency_rub = CommunityMaterialIcon("cmd_currency_rub", '\ue900')
        @JvmField
        val cmd_currency_sign = CommunityMaterialIcon("cmd_currency_sign", '\ue900')
        @JvmField
        val cmd_currency_try = CommunityMaterialIcon("cmd_currency_try", '\ue900')
        @JvmField
        val cmd_currency_twd = CommunityMaterialIcon("cmd_currency_twd", '\ue900')
        @JvmField
        val cmd_currency_usd_off = CommunityMaterialIcon("cmd_currency_usd_off", '\ue900')
        @JvmField
        val cmd_currency_usd = CommunityMaterialIcon("cmd_currency_usd", '\ue900')
        @JvmField
        val cmd_current_ac = CommunityMaterialIcon("cmd_current_ac", '\ue900')
        @JvmField
        val cmd_current_dc = CommunityMaterialIcon("cmd_current_dc", '\ue900')
        @JvmField
        val cmd_cursor_default_click_outline = CommunityMaterialIcon("cmd_cursor_default_click_outline", '\ue900')
        @JvmField
        val cmd_cursor_default_click = CommunityMaterialIcon("cmd_cursor_default_click", '\ue900')
        @JvmField
        val cmd_cursor_default_gesture_outline = CommunityMaterialIcon("cmd_cursor_default_gesture_outline", '\ue900')
        @JvmField
        val cmd_cursor_default_gesture = CommunityMaterialIcon("cmd_cursor_default_gesture", '\ue900')
        @JvmField
        val cmd_cursor_default_outline = CommunityMaterialIcon("cmd_cursor_default_outline", '\ue900')
        @JvmField
        val cmd_cursor_default = CommunityMaterialIcon("cmd_cursor_default", '\ue900')
        @JvmField
        val cmd_cursor_move = CommunityMaterialIcon("cmd_cursor_move", '\ue900')
        @JvmField
        val cmd_cursor_pointer = CommunityMaterialIcon("cmd_cursor_pointer", '\ue900')
        @JvmField
        val cmd_cursor_text = CommunityMaterialIcon("cmd_cursor_text", '\ue900')
        @JvmField
        val cmd_database_check = CommunityMaterialIcon("cmd_database_check", '\ue900')
        @JvmField
        val cmd_database_edit = CommunityMaterialIcon("cmd_database_edit", '\ue900')
        @JvmField
        val cmd_database_export = CommunityMaterialIcon("cmd_database_export", '\ue900')
        @JvmField
        val cmd_database_import = CommunityMaterialIcon("cmd_database_import", '\ue900')
        @JvmField
        val cmd_database_lock = CommunityMaterialIcon("cmd_database_lock", '\ue900')
        @JvmField
        val cmd_database_minus = CommunityMaterialIcon("cmd_database_minus", '\ue900')
        @JvmField
        val cmd_database_plus = CommunityMaterialIcon("cmd_database_plus", '\ue900')
        @JvmField
        val cmd_database_refresh = CommunityMaterialIcon("cmd_database_refresh", '\ue900')
        @JvmField
        val cmd_database_remove = CommunityMaterialIcon("cmd_database_remove", '\ue900')
        @JvmField
        val cmd_database_search = CommunityMaterialIcon("cmd_database_search", '\ue900')
        @JvmField
        val cmd_database_settings = CommunityMaterialIcon("cmd_database_settings", '\ue900')
        @JvmField
        val cmd_database = CommunityMaterialIcon("cmd_database", '\ue900')
        @JvmField
        val cmd_death_star_variant = CommunityMaterialIcon("cmd_death_star_variant", '\ue900')
        @JvmField
        val cmd_death_star = CommunityMaterialIcon("cmd_death_star", '\ue900')
        @JvmField
        val cmd_deathly_hallows = CommunityMaterialIcon("cmd_deathly_hallows", '\ue900')
        @JvmField
        val cmd_debian = CommunityMaterialIcon("cmd_debian", '\ue900')
        @JvmField
        val cmd_debug_step_into = CommunityMaterialIcon("cmd_debug_step_into", '\ue900')
        @JvmField
        val cmd_debug_step_out = CommunityMaterialIcon("cmd_debug_step_out", '\ue900')
        @JvmField
        val cmd_debug_step_over = CommunityMaterialIcon("cmd_debug_step_over", '\ue900')
        @JvmField
        val cmd_decagram_outline = CommunityMaterialIcon("cmd_decagram_outline", '\ue900')
        @JvmField
        val cmd_decagram = CommunityMaterialIcon("cmd_decagram", '\ue900')
        @JvmField
        val cmd_decimal_comma_decrease = CommunityMaterialIcon("cmd_decimal_comma_decrease", '\ue900')
        @JvmField
        val cmd_decimal_comma_increase = CommunityMaterialIcon("cmd_decimal_comma_increase", '\ue900')
        @JvmField
        val cmd_decimal_comma = CommunityMaterialIcon("cmd_decimal_comma", '\ue900')
        @JvmField
        val cmd_decimal_decrease = CommunityMaterialIcon("cmd_decimal_decrease", '\ue900')
        @JvmField
        val cmd_decimal_increase = CommunityMaterialIcon("cmd_decimal_increase", '\ue900')
        @JvmField
        val cmd_decimal = CommunityMaterialIcon("cmd_decimal", '\ue900')
        @JvmField
        val cmd_delete_alert_outline = CommunityMaterialIcon("cmd_delete_alert_outline", '\ue900')
        @JvmField
        val cmd_delete_alert = CommunityMaterialIcon("cmd_delete_alert", '\ue900')
        @JvmField
        val cmd_delete_circle_outline = CommunityMaterialIcon("cmd_delete_circle_outline", '\ue900')
        @JvmField
        val cmd_delete_circle = CommunityMaterialIcon("cmd_delete_circle", '\ue900')
        @JvmField
        val cmd_delete_empty_outline = CommunityMaterialIcon("cmd_delete_empty_outline", '\ue900')
        @JvmField
        val cmd_delete_empty = CommunityMaterialIcon("cmd_delete_empty", '\ue900')
        @JvmField
        val cmd_delete_forever_outline = CommunityMaterialIcon("cmd_delete_forever_outline", '\ue900')
        @JvmField
        val cmd_delete_forever = CommunityMaterialIcon("cmd_delete_forever", '\ue900')
        @JvmField
        val cmd_delete_off_outline = CommunityMaterialIcon("cmd_delete_off_outline", '\ue900')
        @JvmField
        val cmd_delete_off = CommunityMaterialIcon("cmd_delete_off", '\ue900')
        @JvmField
        val cmd_delete_outline = CommunityMaterialIcon("cmd_delete_outline", '\ue900')
        @JvmField
        val cmd_delete_restore = CommunityMaterialIcon("cmd_delete_restore", '\ue900')
        @JvmField
        val cmd_delete_sweep_outline = CommunityMaterialIcon("cmd_delete_sweep_outline", '\ue900')
        @JvmField
        val cmd_delete_sweep = CommunityMaterialIcon("cmd_delete_sweep", '\ue900')
        @JvmField
        val cmd_delete_variant = CommunityMaterialIcon("cmd_delete_variant", '\ue900')
        @JvmField
        val cmd_delete = CommunityMaterialIcon("cmd_delete", '\ue900')
        @JvmField
        val cmd_delta = CommunityMaterialIcon("cmd_delta", '\ue900')
        @JvmField
        val cmd_desk_lamp = CommunityMaterialIcon("cmd_desk_lamp", '\ue900')
        @JvmField
        val cmd_desk = CommunityMaterialIcon("cmd_desk", '\ue900')
        @JvmField
        val cmd_deskphone = CommunityMaterialIcon("cmd_deskphone", '\ue900')
        @JvmField
        val cmd_desktop_classic = CommunityMaterialIcon("cmd_desktop_classic", '\ue900')
        @JvmField
        val cmd_desktop_mac_dashboard = CommunityMaterialIcon("cmd_desktop_mac_dashboard", '\ue900')
        @JvmField
        val cmd_desktop_mac = CommunityMaterialIcon("cmd_desktop_mac", '\ue900')
        @JvmField
        val cmd_desktop_tower_monitor = CommunityMaterialIcon("cmd_desktop_tower_monitor", '\ue900')
        @JvmField
        val cmd_desktop_tower = CommunityMaterialIcon("cmd_desktop_tower", '\ue900')
        @JvmField
        val cmd_details = CommunityMaterialIcon("cmd_details", '\ue900')
        @JvmField
        val cmd_dev_to = CommunityMaterialIcon("cmd_dev_to", '\ue900')
        @JvmField
        val cmd_developer_board = CommunityMaterialIcon("cmd_developer_board", '\ue900')
        @JvmField
        val cmd_deviantart = CommunityMaterialIcon("cmd_deviantart", '\ue900')
        @JvmField
        val cmd_devices = CommunityMaterialIcon("cmd_devices", '\ue900')
        @JvmField
        val cmd_diabetes = CommunityMaterialIcon("cmd_diabetes", '\ue900')
        @JvmField
        val cmd_dialpad = CommunityMaterialIcon("cmd_dialpad", '\ue900')
        @JvmField
        val cmd_diameter_outline = CommunityMaterialIcon("cmd_diameter_outline", '\ue900')
        @JvmField
        val cmd_diameter_variant = CommunityMaterialIcon("cmd_diameter_variant", '\ue900')
        @JvmField
        val cmd_diameter = CommunityMaterialIcon("cmd_diameter", '\ue900')
        @JvmField
        val cmd_diamond_outline = CommunityMaterialIcon("cmd_diamond_outline", '\ue900')
        @JvmField
        val cmd_diamond_stone = CommunityMaterialIcon("cmd_diamond_stone", '\ue900')
        @JvmField
        val cmd_diamond = CommunityMaterialIcon("cmd_diamond", '\ue900')
        @JvmField
        val cmd_dice_1_outline = CommunityMaterialIcon("cmd_dice_1_outline", '\ue900')
        @JvmField
        val cmd_dice_1 = CommunityMaterialIcon("cmd_dice_1", '\ue900')
        @JvmField
        val cmd_dice_2_outline = CommunityMaterialIcon("cmd_dice_2_outline", '\ue900')
        @JvmField
        val cmd_dice_2 = CommunityMaterialIcon("cmd_dice_2", '\ue900')
        @JvmField
        val cmd_dice_3_outline = CommunityMaterialIcon("cmd_dice_3_outline", '\ue900')
        @JvmField
        val cmd_dice_3 = CommunityMaterialIcon("cmd_dice_3", '\ue900')
        @JvmField
        val cmd_dice_4_outline = CommunityMaterialIcon("cmd_dice_4_outline", '\ue900')
        @JvmField
        val cmd_dice_4 = CommunityMaterialIcon("cmd_dice_4", '\ue900')
        @JvmField
        val cmd_dice_5_outline = CommunityMaterialIcon("cmd_dice_5_outline", '\ue900')
        @JvmField
        val cmd_dice_5 = CommunityMaterialIcon("cmd_dice_5", '\ue900')
        @JvmField
        val cmd_dice_6_outline = CommunityMaterialIcon("cmd_dice_6_outline", '\ue900')
        @JvmField
        val cmd_dice_6 = CommunityMaterialIcon("cmd_dice_6", '\ue900')
        @JvmField
        val cmd_dice_d4_outline = CommunityMaterialIcon("cmd_dice_d4_outline", '\ue900')
        @JvmField
        val cmd_dice_d4 = CommunityMaterialIcon("cmd_dice_d4", '\ue900')
        @JvmField
        val cmd_dice_d6_outline = CommunityMaterialIcon("cmd_dice_d6_outline", '\ue900')
        @JvmField
        val cmd_dice_d6 = CommunityMaterialIcon("cmd_dice_d6", '\ue900')
        @JvmField
        val cmd_dice_d8_outline = CommunityMaterialIcon("cmd_dice_d8_outline", '\ue900')
        @JvmField
        val cmd_dice_d8 = CommunityMaterialIcon("cmd_dice_d8", '\ue900')
        @JvmField
        val cmd_dice_d10_outline = CommunityMaterialIcon("cmd_dice_d10_outline", '\ue900')
        @JvmField
        val cmd_dice_d10 = CommunityMaterialIcon("cmd_dice_d10", '\ue900')
        @JvmField
        val cmd_dice_d12_outline = CommunityMaterialIcon("cmd_dice_d12_outline", '\ue900')
        @JvmField
        val cmd_dice_d12 = CommunityMaterialIcon("cmd_dice_d12", '\ue900')
        @JvmField
        val cmd_dice_d20_outline = CommunityMaterialIcon("cmd_dice_d20_outline", '\ue900')
        @JvmField
        val cmd_dice_d20 = CommunityMaterialIcon("cmd_dice_d20", '\ue900')
        @JvmField
        val cmd_dice_multiple_outline = CommunityMaterialIcon("cmd_dice_multiple_outline", '\ue900')
        @JvmField
        val cmd_dice_multiple = CommunityMaterialIcon("cmd_dice_multiple", '\ue900')
        @JvmField
        val cmd_dictionary = CommunityMaterialIcon("cmd_dictionary", '\ue900')
        @JvmField
        val cmd_digital_ocean = CommunityMaterialIcon("cmd_digital_ocean", '\ue900')
        @JvmField
        val cmd_dip_switch = CommunityMaterialIcon("cmd_dip_switch", '\ue900')
        @JvmField
        val cmd_directions_fork = CommunityMaterialIcon("cmd_directions_fork", '\ue900')
        @JvmField
        val cmd_directions = CommunityMaterialIcon("cmd_directions", '\ue900')
        @JvmField
        val cmd_disc_alert = CommunityMaterialIcon("cmd_disc_alert", '\ue900')
        @JvmField
        val cmd_disc_player = CommunityMaterialIcon("cmd_disc_player", '\ue900')
        @JvmField
        val cmd_disc = CommunityMaterialIcon("cmd_disc", '\ue900')
        @JvmField
        val cmd_discord = CommunityMaterialIcon("cmd_discord", '\ue900')
        @JvmField
        val cmd_dishwasher_alert = CommunityMaterialIcon("cmd_dishwasher_alert", '\ue900')
        @JvmField
        val cmd_dishwasher_off = CommunityMaterialIcon("cmd_dishwasher_off", '\ue900')
        @JvmField
        val cmd_dishwasher = CommunityMaterialIcon("cmd_dishwasher", '\ue900')
        @JvmField
        val cmd_disqus_outline = CommunityMaterialIcon("cmd_disqus_outline", '\ue900')
        @JvmField
        val cmd_disqus = CommunityMaterialIcon("cmd_disqus", '\ue900')
        @JvmField
        val cmd_distribute_horizontal_center = CommunityMaterialIcon("cmd_distribute_horizontal_center", '\ue900')
        @JvmField
        val cmd_distribute_horizontal_left = CommunityMaterialIcon("cmd_distribute_horizontal_left", '\ue900')
        @JvmField
        val cmd_distribute_horizontal_right = CommunityMaterialIcon("cmd_distribute_horizontal_right", '\ue900')
        @JvmField
        val cmd_distribute_vertical_bottom = CommunityMaterialIcon("cmd_distribute_vertical_bottom", '\ue900')
        @JvmField
        val cmd_distribute_vertical_center = CommunityMaterialIcon("cmd_distribute_vertical_center", '\ue900')
        @JvmField
        val cmd_distribute_vertical_top = CommunityMaterialIcon("cmd_distribute_vertical_top", '\ue900')
        @JvmField
        val cmd_diving_flippers = CommunityMaterialIcon("cmd_diving_flippers", '\ue900')
        @JvmField
        val cmd_diving_helmet = CommunityMaterialIcon("cmd_diving_helmet", '\ue900')
        @JvmField
        val cmd_diving_scuba_flag = CommunityMaterialIcon("cmd_diving_scuba_flag", '\ue900')
        @JvmField
        val cmd_diving_scuba_tank_multiple = CommunityMaterialIcon("cmd_diving_scuba_tank_multiple", '\ue900')
        @JvmField
        val cmd_diving_scuba_tank = CommunityMaterialIcon("cmd_diving_scuba_tank", '\ue900')
        @JvmField
        val cmd_diving_scuba = CommunityMaterialIcon("cmd_diving_scuba", '\ue900')
        @JvmField
        val cmd_diving_snorkel = CommunityMaterialIcon("cmd_diving_snorkel", '\ue900')
        @JvmField
        val cmd_division_box = CommunityMaterialIcon("cmd_division_box", '\ue900')
        @JvmField
        val cmd_division = CommunityMaterialIcon("cmd_division", '\ue900')
        @JvmField
        val cmd_dlna = CommunityMaterialIcon("cmd_dlna", '\ue900')
        @JvmField
        val cmd_dna = CommunityMaterialIcon("cmd_dna", '\ue900')
        @JvmField
        val cmd_dns_outline = CommunityMaterialIcon("cmd_dns_outline", '\ue900')
        @JvmField
        val cmd_dns = CommunityMaterialIcon("cmd_dns", '\ue900')
        @JvmField
        val cmd_do_not_disturb_off = CommunityMaterialIcon("cmd_do_not_disturb_off", '\ue900')
        @JvmField
        val cmd_do_not_disturb = CommunityMaterialIcon("cmd_do_not_disturb", '\ue900')
        @JvmField
        val cmd_dock_bottom = CommunityMaterialIcon("cmd_dock_bottom", '\ue900')
        @JvmField
        val cmd_dock_left = CommunityMaterialIcon("cmd_dock_left", '\ue900')
        @JvmField
        val cmd_dock_right = CommunityMaterialIcon("cmd_dock_right", '\ue900')
        @JvmField
        val cmd_dock_window = CommunityMaterialIcon("cmd_dock_window", '\ue900')
        @JvmField
        val cmd_docker = CommunityMaterialIcon("cmd_docker", '\ue900')
        @JvmField
        val cmd_doctor = CommunityMaterialIcon("cmd_doctor", '\ue900')
        @JvmField
        val cmd_dog_service = CommunityMaterialIcon("cmd_dog_service", '\ue900')
        @JvmField
        val cmd_dog_side = CommunityMaterialIcon("cmd_dog_side", '\ue900')
        @JvmField
        val cmd_dog = CommunityMaterialIcon("cmd_dog", '\ue900')
        @JvmField
        val cmd_dolby = CommunityMaterialIcon("cmd_dolby", '\ue900')
        @JvmField
        val cmd_dolly = CommunityMaterialIcon("cmd_dolly", '\ue900')
        @JvmField
        val cmd_domain_off = CommunityMaterialIcon("cmd_domain_off", '\ue900')
        @JvmField
        val cmd_domain_plus = CommunityMaterialIcon("cmd_domain_plus", '\ue900')
        @JvmField
        val cmd_domain_remove = CommunityMaterialIcon("cmd_domain_remove", '\ue900')
        @JvmField
        val cmd_domain = CommunityMaterialIcon("cmd_domain", '\ue900')
        @JvmField
        val cmd_domino_mask = CommunityMaterialIcon("cmd_domino_mask", '\ue900')
        @JvmField
        val cmd_donkey = CommunityMaterialIcon("cmd_donkey", '\ue900')
        @JvmField
        val cmd_door_closed_lock = CommunityMaterialIcon("cmd_door_closed_lock", '\ue900')
        @JvmField
        val cmd_door_closed = CommunityMaterialIcon("cmd_door_closed", '\ue900')
        @JvmField
        val cmd_door_open = CommunityMaterialIcon("cmd_door_open", '\ue900')
        @JvmField
        val cmd_door = CommunityMaterialIcon("cmd_door", '\ue900')
        @JvmField
        val cmd_doorbell_video = CommunityMaterialIcon("cmd_doorbell_video", '\ue900')
        @JvmField
        val cmd_dot_net = CommunityMaterialIcon("cmd_dot_net", '\ue900')
        @JvmField
        val cmd_dots_horizontal_circle_outline = CommunityMaterialIcon("cmd_dots_horizontal_circle_outline", '\ue900')
        @JvmField
        val cmd_dots_horizontal_circle = CommunityMaterialIcon("cmd_dots_horizontal_circle", '\ue900')
        @JvmField
        val cmd_dots_horizontal = CommunityMaterialIcon("cmd_dots_horizontal", '\ue900')
        @JvmField
        val cmd_dots_vertical_circle_outline = CommunityMaterialIcon("cmd_dots_vertical_circle_outline", '\ue900')
        @JvmField
        val cmd_dots_vertical_circle = CommunityMaterialIcon("cmd_dots_vertical_circle", '\ue900')
        @JvmField
        val cmd_dots_vertical = CommunityMaterialIcon("cmd_dots_vertical", '\ue900')
        @JvmField
        val cmd_douban = CommunityMaterialIcon("cmd_douban", '\ue900')
        @JvmField
        val cmd_download_multiple = CommunityMaterialIcon("cmd_download_multiple", '\ue900')
        @JvmField
        val cmd_download_network_outline = CommunityMaterialIcon("cmd_download_network_outline", '\ue900')
        @JvmField
        val cmd_download_network = CommunityMaterialIcon("cmd_download_network", '\ue900')
        @JvmField
        val cmd_download_off_outline = CommunityMaterialIcon("cmd_download_off_outline", '\ue900')
        @JvmField
        val cmd_download_off = CommunityMaterialIcon("cmd_download_off", '\ue900')
        @JvmField
        val cmd_download_outline = CommunityMaterialIcon("cmd_download_outline", '\ue900')
        @JvmField
        val cmd_download = CommunityMaterialIcon("cmd_download", '\ue900')
        @JvmField
        val cmd_drag_horizontal = CommunityMaterialIcon("cmd_drag_horizontal", '\ue900')
        @JvmField
        val cmd_drag_variant = CommunityMaterialIcon("cmd_drag_variant", '\ue900')
        @JvmField
        val cmd_drag_vertical = CommunityMaterialIcon("cmd_drag_vertical", '\ue900')
        @JvmField
        val cmd_drag = CommunityMaterialIcon("cmd_drag", '\ue900')
        @JvmField
        val cmd_drama_masks = CommunityMaterialIcon("cmd_drama_masks", '\ue900')
        @JvmField
        val cmd_draw = CommunityMaterialIcon("cmd_draw", '\ue900')
        @JvmField
        val cmd_drawing_box = CommunityMaterialIcon("cmd_drawing_box", '\ue900')
        @JvmField
        val cmd_drawing = CommunityMaterialIcon("cmd_drawing", '\ue900')
        @JvmField
        val cmd_dresser_outline = CommunityMaterialIcon("cmd_dresser_outline", '\ue900')
        @JvmField
        val cmd_dresser = CommunityMaterialIcon("cmd_dresser", '\ue900')
        @JvmField
        val cmd_dribbble_box = CommunityMaterialIcon("cmd_dribbble_box", '\ue900')
        @JvmField
        val cmd_dribbble = CommunityMaterialIcon("cmd_dribbble", '\ue900')
        @JvmField
        val cmd_drone = CommunityMaterialIcon("cmd_drone", '\ue900')
        @JvmField
        val cmd_dropbox = CommunityMaterialIcon("cmd_dropbox", '\ue900')
        @JvmField
        val cmd_drupal = CommunityMaterialIcon("cmd_drupal", '\ue900')
        @JvmField
        val cmd_duck = CommunityMaterialIcon("cmd_duck", '\ue900')
        @JvmField
        val cmd_dumbbell = CommunityMaterialIcon("cmd_dumbbell", '\ue900')
        @JvmField
        val cmd_dump_truck = CommunityMaterialIcon("cmd_dump_truck", '\ue900')
        @JvmField
        val cmd_ear_hearing_off = CommunityMaterialIcon("cmd_ear_hearing_off", '\ue900')
        @JvmField
        val cmd_ear_hearing = CommunityMaterialIcon("cmd_ear_hearing", '\ue900')
        @JvmField
        val cmd_earth_box_off = CommunityMaterialIcon("cmd_earth_box_off", '\ue900')
        @JvmField
        val cmd_earth_box = CommunityMaterialIcon("cmd_earth_box", '\ue900')
        @JvmField
        val cmd_earth_off = CommunityMaterialIcon("cmd_earth_off", '\ue900')
        @JvmField
        val cmd_earth = CommunityMaterialIcon("cmd_earth", '\ue900')
        @JvmField
        val cmd_edge_legacy = CommunityMaterialIcon("cmd_edge_legacy", '\ue900')
        @JvmField
        val cmd_edge = CommunityMaterialIcon("cmd_edge", '\ue900')
        @JvmField
        val cmd_egg_easter = CommunityMaterialIcon("cmd_egg_easter", '\ue900')
        @JvmField
        val cmd_egg = CommunityMaterialIcon("cmd_egg", '\ue900')
        @JvmField
        val cmd_eight_track = CommunityMaterialIcon("cmd_eight_track", '\ue900')
        @JvmField
        val cmd_eject_outline = CommunityMaterialIcon("cmd_eject_outline", '\ue900')
        @JvmField
        val cmd_eject = CommunityMaterialIcon("cmd_eject", '\ue900')
        @JvmField
        val cmd_electric_switch_closed = CommunityMaterialIcon("cmd_electric_switch_closed", '\ue900')
        @JvmField
        val cmd_electric_switch = CommunityMaterialIcon("cmd_electric_switch", '\ue900')
        @JvmField
        val cmd_electron_framework = CommunityMaterialIcon("cmd_electron_framework", '\ue900')
        @JvmField
        val cmd_elephant = CommunityMaterialIcon("cmd_elephant", '\ue900')
        @JvmField
        val cmd_elevation_decline = CommunityMaterialIcon("cmd_elevation_decline", '\ue900')
        @JvmField
        val cmd_elevation_rise = CommunityMaterialIcon("cmd_elevation_rise", '\ue900')
        @JvmField
        val cmd_elevator_down = CommunityMaterialIcon("cmd_elevator_down", '\ue900')
        @JvmField
        val cmd_elevator_up = CommunityMaterialIcon("cmd_elevator_up", '\ue900')
        @JvmField
        val cmd_elevator = CommunityMaterialIcon("cmd_elevator", '\ue900')
        @JvmField
        val cmd_ellipse_outline = CommunityMaterialIcon("cmd_ellipse_outline", '\ue900')
        @JvmField
        val cmd_ellipse = CommunityMaterialIcon("cmd_ellipse", '\ue900')
        @JvmField
        val cmd_email_alert = CommunityMaterialIcon("cmd_email_alert", '\ue900')
        @JvmField
        val cmd_email_box = CommunityMaterialIcon("cmd_email_box", '\ue900')
        @JvmField
        val cmd_email_check_outline = CommunityMaterialIcon("cmd_email_check_outline", '\ue900')
        @JvmField
        val cmd_email_check = CommunityMaterialIcon("cmd_email_check", '\ue900')
        @JvmField
        val cmd_email_edit_outline = CommunityMaterialIcon("cmd_email_edit_outline", '\ue900')
        @JvmField
        val cmd_email_edit = CommunityMaterialIcon("cmd_email_edit", '\ue900')
        @JvmField
        val cmd_email_lock = CommunityMaterialIcon("cmd_email_lock", '\ue900')
        @JvmField
        val cmd_email_mark_as_unread = CommunityMaterialIcon("cmd_email_mark_as_unread", '\ue900')
        @JvmField
        val cmd_email_minus_outline = CommunityMaterialIcon("cmd_email_minus_outline", '\ue900')
        @JvmField
        val cmd_email_minus = CommunityMaterialIcon("cmd_email_minus", '\ue900')
        @JvmField
        val cmd_email_multiple_outline = CommunityMaterialIcon("cmd_email_multiple_outline", '\ue900')
        @JvmField
        val cmd_email_multiple = CommunityMaterialIcon("cmd_email_multiple", '\ue900')
        @JvmField
        val cmd_email_newsletter = CommunityMaterialIcon("cmd_email_newsletter", '\ue900')
        @JvmField
        val cmd_email_open_multiple_outline = CommunityMaterialIcon("cmd_email_open_multiple_outline", '\ue900')
        @JvmField
        val cmd_email_open_multiple = CommunityMaterialIcon("cmd_email_open_multiple", '\ue900')
        @JvmField
        val cmd_email_open_outline = CommunityMaterialIcon("cmd_email_open_outline", '\ue900')
        @JvmField
        val cmd_email_open = CommunityMaterialIcon("cmd_email_open", '\ue900')
        @JvmField
        val cmd_email_outline = CommunityMaterialIcon("cmd_email_outline", '\ue900')
        @JvmField
        val cmd_email_plus_outline = CommunityMaterialIcon("cmd_email_plus_outline", '\ue900')
        @JvmField
        val cmd_email_plus = CommunityMaterialIcon("cmd_email_plus", '\ue900')
        @JvmField
        val cmd_email_receive_outline = CommunityMaterialIcon("cmd_email_receive_outline", '\ue900')
        @JvmField
        val cmd_email_receive = CommunityMaterialIcon("cmd_email_receive", '\ue900')
        @JvmField
        val cmd_email_search_outline = CommunityMaterialIcon("cmd_email_search_outline", '\ue900')
        @JvmField
        val cmd_email_search = CommunityMaterialIcon("cmd_email_search", '\ue900')
        @JvmField
        val cmd_email_send_outline = CommunityMaterialIcon("cmd_email_send_outline", '\ue900')
        @JvmField
        val cmd_email_send = CommunityMaterialIcon("cmd_email_send", '\ue900')
        @JvmField
        val cmd_email_sync_outline = CommunityMaterialIcon("cmd_email_sync_outline", '\ue900')
        @JvmField
        val cmd_email_sync = CommunityMaterialIcon("cmd_email_sync", '\ue900')
        @JvmField
        val cmd_email_variant = CommunityMaterialIcon("cmd_email_variant", '\ue900')
        @JvmField
        val cmd_email = CommunityMaterialIcon("cmd_email", '\ue900')
        @JvmField
        val cmd_ember = CommunityMaterialIcon("cmd_ember", '\ue900')
        @JvmField
        val cmd_emby = CommunityMaterialIcon("cmd_emby", '\ue900')
        @JvmField
        val cmd_emoticon_angry_outline = CommunityMaterialIcon("cmd_emoticon_angry_outline", '\ue900')
        @JvmField
        val cmd_emoticon_angry = CommunityMaterialIcon("cmd_emoticon_angry", '\ue900')
        @JvmField
        val cmd_emoticon_confused_outline = CommunityMaterialIcon("cmd_emoticon_confused_outline", '\ue900')
        @JvmField
        val cmd_emoticon_confused = CommunityMaterialIcon("cmd_emoticon_confused", '\ue900')
        @JvmField
        val cmd_emoticon_cool_outline = CommunityMaterialIcon("cmd_emoticon_cool_outline", '\ue900')
        @JvmField
        val cmd_emoticon_cool = CommunityMaterialIcon("cmd_emoticon_cool", '\ue900')
        @JvmField
        val cmd_emoticon_cry_outline = CommunityMaterialIcon("cmd_emoticon_cry_outline", '\ue900')
        @JvmField
        val cmd_emoticon_cry = CommunityMaterialIcon("cmd_emoticon_cry", '\ue900')
        @JvmField
        val cmd_emoticon_dead_outline = CommunityMaterialIcon("cmd_emoticon_dead_outline", '\ue900')
        @JvmField
        val cmd_emoticon_dead = CommunityMaterialIcon("cmd_emoticon_dead", '\ue900')
        @JvmField
        val cmd_emoticon_devil_outline = CommunityMaterialIcon("cmd_emoticon_devil_outline", '\ue900')
        @JvmField
        val cmd_emoticon_devil = CommunityMaterialIcon("cmd_emoticon_devil", '\ue900')
        @JvmField
        val cmd_emoticon_excited_outline = CommunityMaterialIcon("cmd_emoticon_excited_outline", '\ue900')
        @JvmField
        val cmd_emoticon_excited = CommunityMaterialIcon("cmd_emoticon_excited", '\ue900')
        @JvmField
        val cmd_emoticon_frown_outline = CommunityMaterialIcon("cmd_emoticon_frown_outline", '\ue900')
        @JvmField
        val cmd_emoticon_frown = CommunityMaterialIcon("cmd_emoticon_frown", '\ue900')
        @JvmField
        val cmd_emoticon_happy_outline = CommunityMaterialIcon("cmd_emoticon_happy_outline", '\ue900')
        @JvmField
        val cmd_emoticon_happy = CommunityMaterialIcon("cmd_emoticon_happy", '\ue900')
        @JvmField
        val cmd_emoticon_kiss_outline = CommunityMaterialIcon("cmd_emoticon_kiss_outline", '\ue900')
        @JvmField
        val cmd_emoticon_kiss = CommunityMaterialIcon("cmd_emoticon_kiss", '\ue900')
        @JvmField
        val cmd_emoticon_lol_outline = CommunityMaterialIcon("cmd_emoticon_lol_outline", '\ue900')
        @JvmField
        val cmd_emoticon_lol = CommunityMaterialIcon("cmd_emoticon_lol", '\ue900')
        @JvmField
        val cmd_emoticon_neutral_outline = CommunityMaterialIcon("cmd_emoticon_neutral_outline", '\ue900')
        @JvmField
        val cmd_emoticon_neutral = CommunityMaterialIcon("cmd_emoticon_neutral", '\ue900')
        @JvmField
        val cmd_emoticon_outline = CommunityMaterialIcon("cmd_emoticon_outline", '\ue900')
        @JvmField
        val cmd_emoticon_poop_outline = CommunityMaterialIcon("cmd_emoticon_poop_outline", '\ue900')
        @JvmField
        val cmd_emoticon_poop = CommunityMaterialIcon("cmd_emoticon_poop", '\ue900')
        @JvmField
        val cmd_emoticon_sad_outline = CommunityMaterialIcon("cmd_emoticon_sad_outline", '\ue900')
        @JvmField
        val cmd_emoticon_sad = CommunityMaterialIcon("cmd_emoticon_sad", '\ue900')
        @JvmField
        val cmd_emoticon_tongue_outline = CommunityMaterialIcon("cmd_emoticon_tongue_outline", '\ue900')
        @JvmField
        val cmd_emoticon_tongue = CommunityMaterialIcon("cmd_emoticon_tongue", '\ue900')
        @JvmField
        val cmd_emoticon_wink_outline = CommunityMaterialIcon("cmd_emoticon_wink_outline", '\ue900')
        @JvmField
        val cmd_emoticon_wink = CommunityMaterialIcon("cmd_emoticon_wink", '\ue900')
        @JvmField
        val cmd_emoticon = CommunityMaterialIcon("cmd_emoticon", '\ue900')
        @JvmField
        val cmd_engine_off_outline = CommunityMaterialIcon("cmd_engine_off_outline", '\ue900')
        @JvmField
        val cmd_engine_off = CommunityMaterialIcon("cmd_engine_off", '\ue900')
        @JvmField
        val cmd_engine_outline = CommunityMaterialIcon("cmd_engine_outline", '\ue900')
        @JvmField
        val cmd_engine = CommunityMaterialIcon("cmd_engine", '\ue900')
        @JvmField
        val cmd_epsilon = CommunityMaterialIcon("cmd_epsilon", '\ue900')
        @JvmField
        val cmd_equal_box = CommunityMaterialIcon("cmd_equal_box", '\ue900')
        @JvmField
        val cmd_equal = CommunityMaterialIcon("cmd_equal", '\ue900')
        @JvmField
        val cmd_equalizer_outline = CommunityMaterialIcon("cmd_equalizer_outline", '\ue900')
        @JvmField
        val cmd_equalizer = CommunityMaterialIcon("cmd_equalizer", '\ue900')
        @JvmField
        val cmd_eraser_variant = CommunityMaterialIcon("cmd_eraser_variant", '\ue900')
        @JvmField
        val cmd_eraser = CommunityMaterialIcon("cmd_eraser", '\ue900')
        @JvmField
        val cmd_escalator_down = CommunityMaterialIcon("cmd_escalator_down", '\ue900')
        @JvmField
        val cmd_escalator_up = CommunityMaterialIcon("cmd_escalator_up", '\ue900')
        @JvmField
        val cmd_escalator = CommunityMaterialIcon("cmd_escalator", '\ue900')
        @JvmField
        val cmd_eslint = CommunityMaterialIcon("cmd_eslint", '\ue900')
        @JvmField
        val cmd_et = CommunityMaterialIcon("cmd_et", '\ue900')
        @JvmField
        val cmd_ethereum = CommunityMaterialIcon("cmd_ethereum", '\ue900')
        @JvmField
        val cmd_ethernet_cable_off = CommunityMaterialIcon("cmd_ethernet_cable_off", '\ue900')
        @JvmField
        val cmd_ethernet_cable = CommunityMaterialIcon("cmd_ethernet_cable", '\ue900')
        @JvmField
        val cmd_ethernet = CommunityMaterialIcon("cmd_ethernet", '\ue900')
        @JvmField
        val cmd_etsy = CommunityMaterialIcon("cmd_etsy", '\ue900')
        @JvmField
        val cmd_ev_station = CommunityMaterialIcon("cmd_ev_station", '\ue900')
        @JvmField
        val cmd_eventbrite = CommunityMaterialIcon("cmd_eventbrite", '\ue900')
        @JvmField
        val cmd_evernote = CommunityMaterialIcon("cmd_evernote", '\ue900')
        @JvmField
        val cmd_excavator = CommunityMaterialIcon("cmd_excavator", '\ue900')
        @JvmField
        val cmd_exclamation_thick = CommunityMaterialIcon("cmd_exclamation_thick", '\ue900')
        @JvmField
        val cmd_exclamation = CommunityMaterialIcon("cmd_exclamation", '\ue900')
        @JvmField
        val cmd_exit_run = CommunityMaterialIcon("cmd_exit_run", '\ue900')
        @JvmField
        val cmd_exit_to_app = CommunityMaterialIcon("cmd_exit_to_app", '\ue900')
        @JvmField
        val cmd_expand_all_outline = CommunityMaterialIcon("cmd_expand_all_outline", '\ue900')
        @JvmField
        val cmd_expand_all = CommunityMaterialIcon("cmd_expand_all", '\ue900')
        @JvmField
        val cmd_expansion_card_variant = CommunityMaterialIcon("cmd_expansion_card_variant", '\ue900')
        @JvmField
        val cmd_expansion_card = CommunityMaterialIcon("cmd_expansion_card", '\ue900')
        @JvmField
        val cmd_exponent_box = CommunityMaterialIcon("cmd_exponent_box", '\ue900')
        @JvmField
        val cmd_exponent = CommunityMaterialIcon("cmd_exponent", '\ue900')
        @JvmField
        val cmd_export_variant = CommunityMaterialIcon("cmd_export_variant", '\ue900')
        @JvmField
        val cmd_export = CommunityMaterialIcon("cmd_export", '\ue900')
        @JvmField
        val cmd_eye_check_outline = CommunityMaterialIcon("cmd_eye_check_outline", '\ue900')
        @JvmField
        val cmd_eye_check = CommunityMaterialIcon("cmd_eye_check", '\ue900')
        @JvmField
        val cmd_eye_circle_outline = CommunityMaterialIcon("cmd_eye_circle_outline", '\ue900')
        @JvmField
        val cmd_eye_circle = CommunityMaterialIcon("cmd_eye_circle", '\ue900')
        @JvmField
        val cmd_eye_minus_outline = CommunityMaterialIcon("cmd_eye_minus_outline", '\ue900')
        @JvmField
        val cmd_eye_minus = CommunityMaterialIcon("cmd_eye_minus", '\ue900')
        @JvmField
        val cmd_eye_off_outline = CommunityMaterialIcon("cmd_eye_off_outline", '\ue900')
        @JvmField
        val cmd_eye_off = CommunityMaterialIcon("cmd_eye_off", '\ue900')
        @JvmField
        val cmd_eye_outline = CommunityMaterialIcon("cmd_eye_outline", '\ue900')
        @JvmField
        val cmd_eye_plus_outline = CommunityMaterialIcon("cmd_eye_plus_outline", '\ue900')
        @JvmField
        val cmd_eye_plus = CommunityMaterialIcon("cmd_eye_plus", '\ue900')
        @JvmField
        val cmd_eye_settings_outline = CommunityMaterialIcon("cmd_eye_settings_outline", '\ue900')
        @JvmField
        val cmd_eye_settings = CommunityMaterialIcon("cmd_eye_settings", '\ue900')
        @JvmField
        val cmd_eye = CommunityMaterialIcon("cmd_eye", '\ue900')
        @JvmField
        val cmd_eyedropper_variant = CommunityMaterialIcon("cmd_eyedropper_variant", '\ue900')
        @JvmField
        val cmd_eyedropper = CommunityMaterialIcon("cmd_eyedropper", '\ue900')
        @JvmField
        val cmd_face_agent = CommunityMaterialIcon("cmd_face_agent", '\ue900')
        @JvmField
        val cmd_face_outline = CommunityMaterialIcon("cmd_face_outline", '\ue900')
        @JvmField
        val cmd_face_profile_woman = CommunityMaterialIcon("cmd_face_profile_woman", '\ue900')
        @JvmField
        val cmd_face_profile = CommunityMaterialIcon("cmd_face_profile", '\ue900')
        @JvmField
        val cmd_face_recognition = CommunityMaterialIcon("cmd_face_recognition", '\ue900')
        @JvmField
        val cmd_face_woman_outline = CommunityMaterialIcon("cmd_face_woman_outline", '\ue900')
        @JvmField
        val cmd_face_woman = CommunityMaterialIcon("cmd_face_woman", '\ue900')
        @JvmField
        val cmd_face = CommunityMaterialIcon("cmd_face", '\ue900')
        @JvmField
        val cmd_facebook_box = CommunityMaterialIcon("cmd_facebook_box", '\ue900')
        @JvmField
        val cmd_facebook_messenger = CommunityMaterialIcon("cmd_facebook_messenger", '\ue900')
        @JvmField
        val cmd_facebook_workplace = CommunityMaterialIcon("cmd_facebook_workplace", '\ue900')
        @JvmField
        val cmd_facebook = CommunityMaterialIcon("cmd_facebook", '\ue900')
        @JvmField
        val cmd_factory = CommunityMaterialIcon("cmd_factory", '\ue900')
        @JvmField
        val cmd_fan_off = CommunityMaterialIcon("cmd_fan_off", '\ue900')
        @JvmField
        val cmd_fan = CommunityMaterialIcon("cmd_fan", '\ue900')
        @JvmField
        val cmd_fast_forward_5 = CommunityMaterialIcon("cmd_fast_forward_5", '\ue900')
        @JvmField
        val cmd_fast_forward_10 = CommunityMaterialIcon("cmd_fast_forward_10", '\ue900')
        @JvmField
        val cmd_fast_forward_30 = CommunityMaterialIcon("cmd_fast_forward_30", '\ue900')
        @JvmField
        val cmd_fast_forward_outline = CommunityMaterialIcon("cmd_fast_forward_outline", '\ue900')
        @JvmField
        val cmd_fast_forward = CommunityMaterialIcon("cmd_fast_forward", '\ue900')
        @JvmField
        val cmd_fax = CommunityMaterialIcon("cmd_fax", '\ue900')
        @JvmField
        val cmd_feather = CommunityMaterialIcon("cmd_feather", '\ue900')
        @JvmField
        val cmd_feature_search_outline = CommunityMaterialIcon("cmd_feature_search_outline", '\ue900')
        @JvmField
        val cmd_feature_search = CommunityMaterialIcon("cmd_feature_search", '\ue900')
        @JvmField
        val cmd_fedora = CommunityMaterialIcon("cmd_fedora", '\ue900')
        @JvmField
        val cmd_ferris_wheel = CommunityMaterialIcon("cmd_ferris_wheel", '\ue900')
        @JvmField
        val cmd_ferry = CommunityMaterialIcon("cmd_ferry", '\ue900')
        @JvmField
        val cmd_file_account_outline = CommunityMaterialIcon("cmd_file_account_outline", '\ue900')
        @JvmField
        val cmd_file_account = CommunityMaterialIcon("cmd_file_account", '\ue900')
        @JvmField
        val cmd_file_alert_outline = CommunityMaterialIcon("cmd_file_alert_outline", '\ue900')
        @JvmField
        val cmd_file_alert = CommunityMaterialIcon("cmd_file_alert", '\ue900')
        @JvmField
        val cmd_file_cabinet = CommunityMaterialIcon("cmd_file_cabinet", '\ue900')
        @JvmField
        val cmd_file_cad_box = CommunityMaterialIcon("cmd_file_cad_box", '\ue900')
        @JvmField
        val cmd_file_cad = CommunityMaterialIcon("cmd_file_cad", '\ue900')
        @JvmField
        val cmd_file_cancel_outline = CommunityMaterialIcon("cmd_file_cancel_outline", '\ue900')
        @JvmField
        val cmd_file_cancel = CommunityMaterialIcon("cmd_file_cancel", '\ue900')
        @JvmField
        val cmd_file_certificate_outline = CommunityMaterialIcon("cmd_file_certificate_outline", '\ue900')
        @JvmField
        val cmd_file_certificate = CommunityMaterialIcon("cmd_file_certificate", '\ue900')
        @JvmField
        val cmd_file_chart_outline = CommunityMaterialIcon("cmd_file_chart_outline", '\ue900')
        @JvmField
        val cmd_file_chart = CommunityMaterialIcon("cmd_file_chart", '\ue900')
        @JvmField
        val cmd_file_check_outline = CommunityMaterialIcon("cmd_file_check_outline", '\ue900')
        @JvmField
        val cmd_file_check = CommunityMaterialIcon("cmd_file_check", '\ue900')
        @JvmField
        val cmd_file_clock_outline = CommunityMaterialIcon("cmd_file_clock_outline", '\ue900')
        @JvmField
        val cmd_file_clock = CommunityMaterialIcon("cmd_file_clock", '\ue900')
        @JvmField
        val cmd_file_cloud_outline = CommunityMaterialIcon("cmd_file_cloud_outline", '\ue900')
        @JvmField
        val cmd_file_cloud = CommunityMaterialIcon("cmd_file_cloud", '\ue900')
        @JvmField
        val cmd_file_code_outline = CommunityMaterialIcon("cmd_file_code_outline", '\ue900')
        @JvmField
        val cmd_file_code = CommunityMaterialIcon("cmd_file_code", '\ue900')
        @JvmField
        val cmd_file_compare = CommunityMaterialIcon("cmd_file_compare", '\ue900')
        @JvmField
        val cmd_file_delimited_outline = CommunityMaterialIcon("cmd_file_delimited_outline", '\ue900')
        @JvmField
        val cmd_file_delimited = CommunityMaterialIcon("cmd_file_delimited", '\ue900')
        @JvmField
        val cmd_file_document_box_check_outline = CommunityMaterialIcon("cmd_file_document_box_check_outline", '\ue900')
        @JvmField
        val cmd_file_document_box_check = CommunityMaterialIcon("cmd_file_document_box_check", '\ue900')
        @JvmField
        val cmd_file_document_box_minus_outline = CommunityMaterialIcon("cmd_file_document_box_minus_outline", '\ue900')
        @JvmField
        val cmd_file_document_box_minus = CommunityMaterialIcon("cmd_file_document_box_minus", '\ue900')
        @JvmField
        val cmd_file_document_box_multiple_outline = CommunityMaterialIcon("cmd_file_document_box_multiple_outline", '\ue900')
        @JvmField
        val cmd_file_document_box_multiple = CommunityMaterialIcon("cmd_file_document_box_multiple", '\ue900')
        @JvmField
        val cmd_file_document_box_outline = CommunityMaterialIcon("cmd_file_document_box_outline", '\ue900')
        @JvmField
        val cmd_file_document_box_plus_outline = CommunityMaterialIcon("cmd_file_document_box_plus_outline", '\ue900')
        @JvmField
        val cmd_file_document_box_plus = CommunityMaterialIcon("cmd_file_document_box_plus", '\ue900')
        @JvmField
        val cmd_file_document_box_remove_outline = CommunityMaterialIcon("cmd_file_document_box_remove_outline", '\ue900')
        @JvmField
        val cmd_file_document_box_remove = CommunityMaterialIcon("cmd_file_document_box_remove", '\ue900')
        @JvmField
        val cmd_file_document_box_search_outline = CommunityMaterialIcon("cmd_file_document_box_search_outline", '\ue900')
        @JvmField
        val cmd_file_document_box_search = CommunityMaterialIcon("cmd_file_document_box_search", '\ue900')
        @JvmField
        val cmd_file_document_box = CommunityMaterialIcon("cmd_file_document_box", '\ue900')
        @JvmField
        val cmd_file_document_edit_outline = CommunityMaterialIcon("cmd_file_document_edit_outline", '\ue900')
        @JvmField
        val cmd_file_document_edit = CommunityMaterialIcon("cmd_file_document_edit", '\ue900')
        @JvmField
        val cmd_file_document_outline = CommunityMaterialIcon("cmd_file_document_outline", '\ue900')
        @JvmField
        val cmd_file_document = CommunityMaterialIcon("cmd_file_document", '\ue900')
        @JvmField
        val cmd_file_download_outline = CommunityMaterialIcon("cmd_file_download_outline", '\ue900')
        @JvmField
        val cmd_file_download = CommunityMaterialIcon("cmd_file_download", '\ue900')
        @JvmField
        val cmd_file_edit_outline = CommunityMaterialIcon("cmd_file_edit_outline", '\ue900')
        @JvmField
        val cmd_file_edit = CommunityMaterialIcon("cmd_file_edit", '\ue900')
        @JvmField
        val cmd_file_excel_box_outline = CommunityMaterialIcon("cmd_file_excel_box_outline", '\ue900')
        @JvmField
        val cmd_file_excel_box = CommunityMaterialIcon("cmd_file_excel_box", '\ue900')
        @JvmField
        val cmd_file_excel_outline = CommunityMaterialIcon("cmd_file_excel_outline", '\ue900')
        @JvmField
        val cmd_file_excel = CommunityMaterialIcon("cmd_file_excel", '\ue900')
        @JvmField
        val cmd_file_export_outline = CommunityMaterialIcon("cmd_file_export_outline", '\ue900')
        @JvmField
        val cmd_file_export = CommunityMaterialIcon("cmd_file_export", '\ue900')
        @JvmField
        val cmd_file_eye_outline = CommunityMaterialIcon("cmd_file_eye_outline", '\ue900')
        @JvmField
        val cmd_file_eye = CommunityMaterialIcon("cmd_file_eye", '\ue900')
        @JvmField
        val cmd_file_find_outline = CommunityMaterialIcon("cmd_file_find_outline", '\ue900')
        @JvmField
        val cmd_file_find = CommunityMaterialIcon("cmd_file_find", '\ue900')
        @JvmField
        val cmd_file_hidden = CommunityMaterialIcon("cmd_file_hidden", '\ue900')
        @JvmField
        val cmd_file_image_outline = CommunityMaterialIcon("cmd_file_image_outline", '\ue900')
        @JvmField
        val cmd_file_image = CommunityMaterialIcon("cmd_file_image", '\ue900')
        @JvmField
        val cmd_file_import_outline = CommunityMaterialIcon("cmd_file_import_outline", '\ue900')
        @JvmField
        val cmd_file_import = CommunityMaterialIcon("cmd_file_import", '\ue900')
        @JvmField
        val cmd_file_key_outline = CommunityMaterialIcon("cmd_file_key_outline", '\ue900')
        @JvmField
        val cmd_file_key = CommunityMaterialIcon("cmd_file_key", '\ue900')
        @JvmField
        val cmd_file_link_outline = CommunityMaterialIcon("cmd_file_link_outline", '\ue900')
        @JvmField
        val cmd_file_link = CommunityMaterialIcon("cmd_file_link", '\ue900')
        @JvmField
        val cmd_file_lock_outline = CommunityMaterialIcon("cmd_file_lock_outline", '\ue900')
        @JvmField
        val cmd_file_lock = CommunityMaterialIcon("cmd_file_lock", '\ue900')
        @JvmField
        val cmd_file_move_outline = CommunityMaterialIcon("cmd_file_move_outline", '\ue900')
        @JvmField
        val cmd_file_move = CommunityMaterialIcon("cmd_file_move", '\ue900')
        @JvmField
        val cmd_file_multiple_outline = CommunityMaterialIcon("cmd_file_multiple_outline", '\ue900')
        @JvmField
        val cmd_file_multiple = CommunityMaterialIcon("cmd_file_multiple", '\ue900')
        @JvmField
        val cmd_file_music_outline = CommunityMaterialIcon("cmd_file_music_outline", '\ue900')
        @JvmField
        val cmd_file_music = CommunityMaterialIcon("cmd_file_music", '\ue900')
        @JvmField
        val cmd_file_outline = CommunityMaterialIcon("cmd_file_outline", '\ue900')
        @JvmField
        val cmd_file_pdf_box_outline = CommunityMaterialIcon("cmd_file_pdf_box_outline", '\ue900')
        @JvmField
        val cmd_file_pdf_box = CommunityMaterialIcon("cmd_file_pdf_box", '\ue900')
        @JvmField
        val cmd_file_pdf_outline = CommunityMaterialIcon("cmd_file_pdf_outline", '\ue900')
        @JvmField
        val cmd_file_pdf = CommunityMaterialIcon("cmd_file_pdf", '\ue900')
        @JvmField
        val cmd_file_percent_outline = CommunityMaterialIcon("cmd_file_percent_outline", '\ue900')
        @JvmField
        val cmd_file_percent = CommunityMaterialIcon("cmd_file_percent", '\ue900')
        @JvmField
        val cmd_file_phone_outline = CommunityMaterialIcon("cmd_file_phone_outline", '\ue900')
        @JvmField
        val cmd_file_phone = CommunityMaterialIcon("cmd_file_phone", '\ue900')
        @JvmField
        val cmd_file_plus_outline = CommunityMaterialIcon("cmd_file_plus_outline", '\ue900')
        @JvmField
        val cmd_file_plus = CommunityMaterialIcon("cmd_file_plus", '\ue900')
        @JvmField
        val cmd_file_powerpoint_box_outline = CommunityMaterialIcon("cmd_file_powerpoint_box_outline", '\ue900')
        @JvmField
        val cmd_file_powerpoint_box = CommunityMaterialIcon("cmd_file_powerpoint_box", '\ue900')
        @JvmField
        val cmd_file_powerpoint_outline = CommunityMaterialIcon("cmd_file_powerpoint_outline", '\ue900')
        @JvmField
        val cmd_file_powerpoint = CommunityMaterialIcon("cmd_file_powerpoint", '\ue900')
        @JvmField
        val cmd_file_presentation_box = CommunityMaterialIcon("cmd_file_presentation_box", '\ue900')
        @JvmField
        val cmd_file_question_outline = CommunityMaterialIcon("cmd_file_question_outline", '\ue900')
        @JvmField
        val cmd_file_question = CommunityMaterialIcon("cmd_file_question", '\ue900')
        @JvmField
        val cmd_file_remove_outline = CommunityMaterialIcon("cmd_file_remove_outline", '\ue900')
        @JvmField
        val cmd_file_remove = CommunityMaterialIcon("cmd_file_remove", '\ue900')
        @JvmField
        val cmd_file_replace_outline = CommunityMaterialIcon("cmd_file_replace_outline", '\ue900')
        @JvmField
        val cmd_file_replace = CommunityMaterialIcon("cmd_file_replace", '\ue900')
        @JvmField
        val cmd_file_restore_outline = CommunityMaterialIcon("cmd_file_restore_outline", '\ue900')
        @JvmField
        val cmd_file_restore = CommunityMaterialIcon("cmd_file_restore", '\ue900')
        @JvmField
        val cmd_file_search_outline = CommunityMaterialIcon("cmd_file_search_outline", '\ue900')
        @JvmField
        val cmd_file_search = CommunityMaterialIcon("cmd_file_search", '\ue900')
        @JvmField
        val cmd_file_send_outline = CommunityMaterialIcon("cmd_file_send_outline", '\ue900')
        @JvmField
        val cmd_file_send = CommunityMaterialIcon("cmd_file_send", '\ue900')
        @JvmField
        val cmd_file_settings_outline = CommunityMaterialIcon("cmd_file_settings_outline", '\ue900')
        @JvmField
        val cmd_file_settings_variant_outline = CommunityMaterialIcon("cmd_file_settings_variant_outline", '\ue900')
        @JvmField
        val cmd_file_settings_variant = CommunityMaterialIcon("cmd_file_settings_variant", '\ue900')
        @JvmField
        val cmd_file_settings = CommunityMaterialIcon("cmd_file_settings", '\ue900')
        @JvmField
        val cmd_file_star_outline = CommunityMaterialIcon("cmd_file_star_outline", '\ue900')
        @JvmField
        val cmd_file_star = CommunityMaterialIcon("cmd_file_star", '\ue900')
        @JvmField
        val cmd_file_swap_outline = CommunityMaterialIcon("cmd_file_swap_outline", '\ue900')
        @JvmField
        val cmd_file_swap = CommunityMaterialIcon("cmd_file_swap", '\ue900')
        @JvmField
        val cmd_file_sync_outline = CommunityMaterialIcon("cmd_file_sync_outline", '\ue900')
        @JvmField
        val cmd_file_sync = CommunityMaterialIcon("cmd_file_sync", '\ue900')
        @JvmField
        val cmd_file_table_box_multiple_outline = CommunityMaterialIcon("cmd_file_table_box_multiple_outline", '\ue900')
        @JvmField
        val cmd_file_table_box_multiple = CommunityMaterialIcon("cmd_file_table_box_multiple", '\ue900')
        @JvmField
        val cmd_file_table_box_outline = CommunityMaterialIcon("cmd_file_table_box_outline", '\ue900')
        @JvmField
        val cmd_file_table_box = CommunityMaterialIcon("cmd_file_table_box", '\ue900')
        @JvmField
        val cmd_file_table_outline = CommunityMaterialIcon("cmd_file_table_outline", '\ue900')
        @JvmField
        val cmd_file_table = CommunityMaterialIcon("cmd_file_table", '\ue900')
        @JvmField
        val cmd_file_tree = CommunityMaterialIcon("cmd_file_tree", '\ue900')
        @JvmField
        val cmd_file_undo_outline = CommunityMaterialIcon("cmd_file_undo_outline", '\ue900')
        @JvmField
        val cmd_file_undo = CommunityMaterialIcon("cmd_file_undo", '\ue900')
        @JvmField
        val cmd_file_upload_outline = CommunityMaterialIcon("cmd_file_upload_outline", '\ue900')
        @JvmField
        val cmd_file_upload = CommunityMaterialIcon("cmd_file_upload", '\ue900')
        @JvmField
        val cmd_file_video_outline = CommunityMaterialIcon("cmd_file_video_outline", '\ue900')
        @JvmField
        val cmd_file_video = CommunityMaterialIcon("cmd_file_video", '\ue900')
        @JvmField
        val cmd_file_word_box_outline = CommunityMaterialIcon("cmd_file_word_box_outline", '\ue900')
        @JvmField
        val cmd_file_word_box = CommunityMaterialIcon("cmd_file_word_box", '\ue900')
        @JvmField
        val cmd_file_word_outline = CommunityMaterialIcon("cmd_file_word_outline", '\ue900')
        @JvmField
        val cmd_file_word = CommunityMaterialIcon("cmd_file_word", '\ue900')
        @JvmField
        val cmd_file = CommunityMaterialIcon("cmd_file", '\ue900')
        @JvmField
        val cmd_film = CommunityMaterialIcon("cmd_film", '\ue900')
        @JvmField
        val cmd_filmstrip_off = CommunityMaterialIcon("cmd_filmstrip_off", '\ue900')
        @JvmField
        val cmd_filmstrip = CommunityMaterialIcon("cmd_filmstrip", '\ue900')
        @JvmField
        val cmd_filter_menu_outline = CommunityMaterialIcon("cmd_filter_menu_outline", '\ue900')
        @JvmField
        val cmd_filter_menu = CommunityMaterialIcon("cmd_filter_menu", '\ue900')
        @JvmField
        val cmd_filter_minus_outline = CommunityMaterialIcon("cmd_filter_minus_outline", '\ue900')
        @JvmField
        val cmd_filter_minus = CommunityMaterialIcon("cmd_filter_minus", '\ue900')
        @JvmField
        val cmd_filter_outline = CommunityMaterialIcon("cmd_filter_outline", '\ue900')
        @JvmField
        val cmd_filter_plus_outline = CommunityMaterialIcon("cmd_filter_plus_outline", '\ue900')
        @JvmField
        val cmd_filter_plus = CommunityMaterialIcon("cmd_filter_plus", '\ue900')
        @JvmField
        val cmd_filter_remove_outline = CommunityMaterialIcon("cmd_filter_remove_outline", '\ue900')
        @JvmField
        val cmd_filter_remove = CommunityMaterialIcon("cmd_filter_remove", '\ue900')
        @JvmField
        val cmd_filter_variant_minus = CommunityMaterialIcon("cmd_filter_variant_minus", '\ue900')
        @JvmField
        val cmd_filter_variant_plus = CommunityMaterialIcon("cmd_filter_variant_plus", '\ue900')
        @JvmField
        val cmd_filter_variant_remove = CommunityMaterialIcon("cmd_filter_variant_remove", '\ue900')
        @JvmField
        val cmd_filter_variant = CommunityMaterialIcon("cmd_filter_variant", '\ue900')
        @JvmField
        val cmd_filter = CommunityMaterialIcon("cmd_filter", '\ue900')
        @JvmField
        val cmd_finance = CommunityMaterialIcon("cmd_finance", '\ue900')
        @JvmField
        val cmd_find_replace = CommunityMaterialIcon("cmd_find_replace", '\ue900')
        @JvmField
        val cmd_fingerprint_off = CommunityMaterialIcon("cmd_fingerprint_off", '\ue900')
        @JvmField
        val cmd_fingerprint = CommunityMaterialIcon("cmd_fingerprint", '\ue900')
        @JvmField
        val cmd_fire_extinguisher = CommunityMaterialIcon("cmd_fire_extinguisher", '\ue900')
        @JvmField
        val cmd_fire_hydrant_alert = CommunityMaterialIcon("cmd_fire_hydrant_alert", '\ue900')
        @JvmField
        val cmd_fire_hydrant_off = CommunityMaterialIcon("cmd_fire_hydrant_off", '\ue900')
        @JvmField
        val cmd_fire_hydrant = CommunityMaterialIcon("cmd_fire_hydrant", '\ue900')
        @JvmField
        val cmd_fire_truck = CommunityMaterialIcon("cmd_fire_truck", '\ue900')
        @JvmField
        val cmd_fire = CommunityMaterialIcon("cmd_fire", '\ue900')
        @JvmField
        val cmd_firebase = CommunityMaterialIcon("cmd_firebase", '\ue900')
        @JvmField
        val cmd_firefox = CommunityMaterialIcon("cmd_firefox", '\ue900')
        @JvmField
        val cmd_fireplace_off = CommunityMaterialIcon("cmd_fireplace_off", '\ue900')
        @JvmField
        val cmd_fireplace = CommunityMaterialIcon("cmd_fireplace", '\ue900')
        @JvmField
        val cmd_firework = CommunityMaterialIcon("cmd_firework", '\ue900')
        @JvmField
        val cmd_fish = CommunityMaterialIcon("cmd_fish", '\ue900')
        @JvmField
        val cmd_fishbowl_outline = CommunityMaterialIcon("cmd_fishbowl_outline", '\ue900')
        @JvmField
        val cmd_fishbowl = CommunityMaterialIcon("cmd_fishbowl", '\ue900')
        @JvmField
        val cmd_fit_to_page_outline = CommunityMaterialIcon("cmd_fit_to_page_outline", '\ue900')
        @JvmField
        val cmd_fit_to_page = CommunityMaterialIcon("cmd_fit_to_page", '\ue900')
        @JvmField
        val cmd_flag_checkered = CommunityMaterialIcon("cmd_flag_checkered", '\ue900')
        @JvmField
        val cmd_flag_minus_outline = CommunityMaterialIcon("cmd_flag_minus_outline", '\ue900')
        @JvmField
        val cmd_flag_minus = CommunityMaterialIcon("cmd_flag_minus", '\ue900')
        @JvmField
        val cmd_flag_outline = CommunityMaterialIcon("cmd_flag_outline", '\ue900')
        @JvmField
        val cmd_flag_plus_outline = CommunityMaterialIcon("cmd_flag_plus_outline", '\ue900')
        @JvmField
        val cmd_flag_plus = CommunityMaterialIcon("cmd_flag_plus", '\ue900')
        @JvmField
        val cmd_flag_remove_outline = CommunityMaterialIcon("cmd_flag_remove_outline", '\ue900')
        @JvmField
        val cmd_flag_remove = CommunityMaterialIcon("cmd_flag_remove", '\ue900')
        @JvmField
        val cmd_flag_triangle = CommunityMaterialIcon("cmd_flag_triangle", '\ue900')
        @JvmField
        val cmd_flag_variant_outline = CommunityMaterialIcon("cmd_flag_variant_outline", '\ue900')
        @JvmField
        val cmd_flag_variant = CommunityMaterialIcon("cmd_flag_variant", '\ue900')
        @JvmField
        val cmd_flag = CommunityMaterialIcon("cmd_flag", '\ue900')
        @JvmField
        val cmd_flare = CommunityMaterialIcon("cmd_flare", '\ue900')
        @JvmField
        val cmd_flash_alert_outline = CommunityMaterialIcon("cmd_flash_alert_outline", '\ue900')
        @JvmField
        val cmd_flash_alert = CommunityMaterialIcon("cmd_flash_alert", '\ue900')
        @JvmField
        val cmd_flash_auto = CommunityMaterialIcon("cmd_flash_auto", '\ue900')
        @JvmField
        val cmd_flash_circle = CommunityMaterialIcon("cmd_flash_circle", '\ue900')
        @JvmField
        val cmd_flash_off = CommunityMaterialIcon("cmd_flash_off", '\ue900')
        @JvmField
        val cmd_flash_outline = CommunityMaterialIcon("cmd_flash_outline", '\ue900')
        @JvmField
        val cmd_flash_red_eye = CommunityMaterialIcon("cmd_flash_red_eye", '\ue900')
        @JvmField
        val cmd_flash = CommunityMaterialIcon("cmd_flash", '\ue900')
        @JvmField
        val cmd_flashlight_off = CommunityMaterialIcon("cmd_flashlight_off", '\ue900')
        @JvmField
        val cmd_flashlight = CommunityMaterialIcon("cmd_flashlight", '\ue900')
        @JvmField
        val cmd_flask_empty_minus_outline = CommunityMaterialIcon("cmd_flask_empty_minus_outline", '\ue900')
        @JvmField
        val cmd_flask_empty_minus = CommunityMaterialIcon("cmd_flask_empty_minus", '\ue900')
        @JvmField
        val cmd_flask_empty_outline = CommunityMaterialIcon("cmd_flask_empty_outline", '\ue900')
        @JvmField
        val cmd_flask_empty_plus_outline = CommunityMaterialIcon("cmd_flask_empty_plus_outline", '\ue900')
        @JvmField
        val cmd_flask_empty_plus = CommunityMaterialIcon("cmd_flask_empty_plus", '\ue900')
        @JvmField
        val cmd_flask_empty_remove_outline = CommunityMaterialIcon("cmd_flask_empty_remove_outline", '\ue900')
        @JvmField
        val cmd_flask_empty_remove = CommunityMaterialIcon("cmd_flask_empty_remove", '\ue900')
        @JvmField
        val cmd_flask_empty = CommunityMaterialIcon("cmd_flask_empty", '\ue900')
        @JvmField
        val cmd_flask_minus_outline = CommunityMaterialIcon("cmd_flask_minus_outline", '\ue900')
        @JvmField
        val cmd_flask_minus = CommunityMaterialIcon("cmd_flask_minus", '\ue900')
        @JvmField
        val cmd_flask_outline = CommunityMaterialIcon("cmd_flask_outline", '\ue900')
        @JvmField
        val cmd_flask_plus_outline = CommunityMaterialIcon("cmd_flask_plus_outline", '\ue900')
        @JvmField
        val cmd_flask_plus = CommunityMaterialIcon("cmd_flask_plus", '\ue900')
        @JvmField
        val cmd_flask_remove_outline = CommunityMaterialIcon("cmd_flask_remove_outline", '\ue900')
        @JvmField
        val cmd_flask_remove = CommunityMaterialIcon("cmd_flask_remove", '\ue900')
        @JvmField
        val cmd_flask_round_bottom_empty_outline = CommunityMaterialIcon("cmd_flask_round_bottom_empty_outline", '\ue900')
        @JvmField
        val cmd_flask_round_bottom_empty = CommunityMaterialIcon("cmd_flask_round_bottom_empty", '\ue900')
        @JvmField
        val cmd_flask_round_bottom_outline = CommunityMaterialIcon("cmd_flask_round_bottom_outline", '\ue900')
        @JvmField
        val cmd_flask_round_bottom = CommunityMaterialIcon("cmd_flask_round_bottom", '\ue900')
        @JvmField
        val cmd_flask = CommunityMaterialIcon("cmd_flask", '\ue900')
        @JvmField
        val cmd_flattr = CommunityMaterialIcon("cmd_flattr", '\ue900')
        @JvmField
        val cmd_flickr = CommunityMaterialIcon("cmd_flickr", '\ue900')
        @JvmField
        val cmd_flip_horizontal = CommunityMaterialIcon("cmd_flip_horizontal", '\ue900')
        @JvmField
        val cmd_flip_to_back = CommunityMaterialIcon("cmd_flip_to_back", '\ue900')
        @JvmField
        val cmd_flip_to_front = CommunityMaterialIcon("cmd_flip_to_front", '\ue900')
        @JvmField
        val cmd_flip_vertical = CommunityMaterialIcon("cmd_flip_vertical", '\ue900')
        @JvmField
        val cmd_floor_lamp_dual = CommunityMaterialIcon("cmd_floor_lamp_dual", '\ue900')
        @JvmField
        val cmd_floor_lamp_variant = CommunityMaterialIcon("cmd_floor_lamp_variant", '\ue900')
        @JvmField
        val cmd_floor_lamp = CommunityMaterialIcon("cmd_floor_lamp", '\ue900')
        @JvmField
        val cmd_floor_plan = CommunityMaterialIcon("cmd_floor_plan", '\ue900')
        @JvmField
        val cmd_floppy_variant = CommunityMaterialIcon("cmd_floppy_variant", '\ue900')
        @JvmField
        val cmd_floppy = CommunityMaterialIcon("cmd_floppy", '\ue900')
        @JvmField
        val cmd_flower_outline = CommunityMaterialIcon("cmd_flower_outline", '\ue900')
        @JvmField
        val cmd_flower_poppy = CommunityMaterialIcon("cmd_flower_poppy", '\ue900')
        @JvmField
        val cmd_flower_tulip_outline = CommunityMaterialIcon("cmd_flower_tulip_outline", '\ue900')
        @JvmField
        val cmd_flower_tulip = CommunityMaterialIcon("cmd_flower_tulip", '\ue900')
        @JvmField
        val cmd_flower = CommunityMaterialIcon("cmd_flower", '\ue900')
        @JvmField
        val cmd_focus_auto = CommunityMaterialIcon("cmd_focus_auto", '\ue900')
        @JvmField
        val cmd_focus_field_horizontal = CommunityMaterialIcon("cmd_focus_field_horizontal", '\ue900')
        @JvmField
        val cmd_focus_field_vertical = CommunityMaterialIcon("cmd_focus_field_vertical", '\ue900')
        @JvmField
        val cmd_focus_field = CommunityMaterialIcon("cmd_focus_field", '\ue900')
        @JvmField
        val cmd_folder_account_outline = CommunityMaterialIcon("cmd_folder_account_outline", '\ue900')
        @JvmField
        val cmd_folder_account = CommunityMaterialIcon("cmd_folder_account", '\ue900')
        @JvmField
        val cmd_folder_alert_outline = CommunityMaterialIcon("cmd_folder_alert_outline", '\ue900')
        @JvmField
        val cmd_folder_alert = CommunityMaterialIcon("cmd_folder_alert", '\ue900')
        @JvmField
        val cmd_folder_clock_outline = CommunityMaterialIcon("cmd_folder_clock_outline", '\ue900')
        @JvmField
        val cmd_folder_clock = CommunityMaterialIcon("cmd_folder_clock", '\ue900')
        @JvmField
        val cmd_folder_download_outline = CommunityMaterialIcon("cmd_folder_download_outline", '\ue900')
        @JvmField
        val cmd_folder_download = CommunityMaterialIcon("cmd_folder_download", '\ue900')
        @JvmField
        val cmd_folder_edit_outline = CommunityMaterialIcon("cmd_folder_edit_outline", '\ue900')
        @JvmField
        val cmd_folder_edit = CommunityMaterialIcon("cmd_folder_edit", '\ue900')
        @JvmField
        val cmd_folder_google_drive = CommunityMaterialIcon("cmd_folder_google_drive", '\ue900')
        @JvmField
        val cmd_folder_heart_outline = CommunityMaterialIcon("cmd_folder_heart_outline", '\ue900')
        @JvmField
        val cmd_folder_heart = CommunityMaterialIcon("cmd_folder_heart", '\ue900')
        @JvmField
        val cmd_folder_home_outline = CommunityMaterialIcon("cmd_folder_home_outline", '\ue900')
        @JvmField
        val cmd_folder_home = CommunityMaterialIcon("cmd_folder_home", '\ue900')
        @JvmField
        val cmd_folder_image = CommunityMaterialIcon("cmd_folder_image", '\ue900')
        @JvmField
        val cmd_folder_information_outline = CommunityMaterialIcon("cmd_folder_information_outline", '\ue900')
        @JvmField
        val cmd_folder_information = CommunityMaterialIcon("cmd_folder_information", '\ue900')
        @JvmField
        val cmd_folder_key_network_outline = CommunityMaterialIcon("cmd_folder_key_network_outline", '\ue900')
        @JvmField
        val cmd_folder_key_network = CommunityMaterialIcon("cmd_folder_key_network", '\ue900')
        @JvmField
        val cmd_folder_key_outline = CommunityMaterialIcon("cmd_folder_key_outline", '\ue900')
        @JvmField
        val cmd_folder_key = CommunityMaterialIcon("cmd_folder_key", '\ue900')
        @JvmField
        val cmd_folder_lock_open = CommunityMaterialIcon("cmd_folder_lock_open", '\ue900')
        @JvmField
        val cmd_folder_lock = CommunityMaterialIcon("cmd_folder_lock", '\ue900')
        @JvmField
        val cmd_folder_marker_outline = CommunityMaterialIcon("cmd_folder_marker_outline", '\ue900')
        @JvmField
        val cmd_folder_marker = CommunityMaterialIcon("cmd_folder_marker", '\ue900')
        @JvmField
        val cmd_folder_move_outline = CommunityMaterialIcon("cmd_folder_move_outline", '\ue900')
        @JvmField
        val cmd_folder_move = CommunityMaterialIcon("cmd_folder_move", '\ue900')
        @JvmField
        val cmd_folder_multiple_image = CommunityMaterialIcon("cmd_folder_multiple_image", '\ue900')
        @JvmField
        val cmd_folder_multiple_outline = CommunityMaterialIcon("cmd_folder_multiple_outline", '\ue900')
        @JvmField
        val cmd_folder_multiple = CommunityMaterialIcon("cmd_folder_multiple", '\ue900')
        @JvmField
        val cmd_folder_network_outline = CommunityMaterialIcon("cmd_folder_network_outline", '\ue900')
        @JvmField
        val cmd_folder_network = CommunityMaterialIcon("cmd_folder_network", '\ue900')
        @JvmField
        val cmd_folder_open_outline = CommunityMaterialIcon("cmd_folder_open_outline", '\ue900')
        @JvmField
        val cmd_folder_open = CommunityMaterialIcon("cmd_folder_open", '\ue900')
        @JvmField
        val cmd_folder_outline = CommunityMaterialIcon("cmd_folder_outline", '\ue900')
        @JvmField
        val cmd_folder_plus_outline = CommunityMaterialIcon("cmd_folder_plus_outline", '\ue900')
        @JvmField
        val cmd_folder_plus = CommunityMaterialIcon("cmd_folder_plus", '\ue900')
        @JvmField
        val cmd_folder_pound_outline = CommunityMaterialIcon("cmd_folder_pound_outline", '\ue900')
        @JvmField
        val cmd_folder_pound = CommunityMaterialIcon("cmd_folder_pound", '\ue900')
        @JvmField
        val cmd_folder_remove_outline = CommunityMaterialIcon("cmd_folder_remove_outline", '\ue900')
        @JvmField
        val cmd_folder_remove = CommunityMaterialIcon("cmd_folder_remove", '\ue900')
        @JvmField
        val cmd_folder_search_outline = CommunityMaterialIcon("cmd_folder_search_outline", '\ue900')
        @JvmField
        val cmd_folder_search = CommunityMaterialIcon("cmd_folder_search", '\ue900')
        @JvmField
        val cmd_folder_settings_outline = CommunityMaterialIcon("cmd_folder_settings_outline", '\ue900')
        @JvmField
        val cmd_folder_settings_variant_outline = CommunityMaterialIcon("cmd_folder_settings_variant_outline", '\ue900')
        @JvmField
        val cmd_folder_settings_variant = CommunityMaterialIcon("cmd_folder_settings_variant", '\ue900')
        @JvmField
        val cmd_folder_settings = CommunityMaterialIcon("cmd_folder_settings", '\ue900')
        @JvmField
        val cmd_folder_star_outline = CommunityMaterialIcon("cmd_folder_star_outline", '\ue900')
        @JvmField
        val cmd_folder_star = CommunityMaterialIcon("cmd_folder_star", '\ue900')
        @JvmField
        val cmd_folder_swap_outline = CommunityMaterialIcon("cmd_folder_swap_outline", '\ue900')
        @JvmField
        val cmd_folder_swap = CommunityMaterialIcon("cmd_folder_swap", '\ue900')
        @JvmField
        val cmd_folder_sync_outline = CommunityMaterialIcon("cmd_folder_sync_outline", '\ue900')
        @JvmField
        val cmd_folder_sync = CommunityMaterialIcon("cmd_folder_sync", '\ue900')
        @JvmField
        val cmd_folder_table_outline = CommunityMaterialIcon("cmd_folder_table_outline", '\ue900')
        @JvmField
        val cmd_folder_table = CommunityMaterialIcon("cmd_folder_table", '\ue900')
        @JvmField
        val cmd_folder_text_outline = CommunityMaterialIcon("cmd_folder_text_outline", '\ue900')
        @JvmField
        val cmd_folder_text = CommunityMaterialIcon("cmd_folder_text", '\ue900')
        @JvmField
        val cmd_folder_upload_outline = CommunityMaterialIcon("cmd_folder_upload_outline", '\ue900')
        @JvmField
        val cmd_folder_upload = CommunityMaterialIcon("cmd_folder_upload", '\ue900')
        @JvmField
        val cmd_folder_zip_outline = CommunityMaterialIcon("cmd_folder_zip_outline", '\ue900')
        @JvmField
        val cmd_folder_zip = CommunityMaterialIcon("cmd_folder_zip", '\ue900')
        @JvmField
        val cmd_folder = CommunityMaterialIcon("cmd_folder", '\ue900')
        @JvmField
        val cmd_font_awesome = CommunityMaterialIcon("cmd_font_awesome", '\ue900')
        @JvmField
        val cmd_food_apple_outline = CommunityMaterialIcon("cmd_food_apple_outline", '\ue900')
        @JvmField
        val cmd_food_apple = CommunityMaterialIcon("cmd_food_apple", '\ue900')
        @JvmField
        val cmd_food_croissant = CommunityMaterialIcon("cmd_food_croissant", '\ue900')
        @JvmField
        val cmd_food_fork_drink = CommunityMaterialIcon("cmd_food_fork_drink", '\ue900')
        @JvmField
        val cmd_food_off = CommunityMaterialIcon("cmd_food_off", '\ue900')
        @JvmField
        val cmd_food_variant = CommunityMaterialIcon("cmd_food_variant", '\ue900')
        @JvmField
        val cmd_food = CommunityMaterialIcon("cmd_food", '\ue900')
        @JvmField
        val cmd_foot_print = CommunityMaterialIcon("cmd_foot_print", '\ue900')
        @JvmField
        val cmd_football_australian = CommunityMaterialIcon("cmd_football_australian", '\ue900')
        @JvmField
        val cmd_football_helmet = CommunityMaterialIcon("cmd_football_helmet", '\ue900')
        @JvmField
        val cmd_football = CommunityMaterialIcon("cmd_football", '\ue900')
        @JvmField
        val cmd_forklift = CommunityMaterialIcon("cmd_forklift", '\ue900')
        @JvmField
        val cmd_format_align_bottom = CommunityMaterialIcon("cmd_format_align_bottom", '\ue900')
        @JvmField
        val cmd_format_align_center = CommunityMaterialIcon("cmd_format_align_center", '\ue900')
        @JvmField
        val cmd_format_align_justify = CommunityMaterialIcon("cmd_format_align_justify", '\ue900')
        @JvmField
        val cmd_format_align_left = CommunityMaterialIcon("cmd_format_align_left", '\ue900')
        @JvmField
        val cmd_format_align_middle = CommunityMaterialIcon("cmd_format_align_middle", '\ue900')
        @JvmField
        val cmd_format_align_right = CommunityMaterialIcon("cmd_format_align_right", '\ue900')
        @JvmField
        val cmd_format_align_top = CommunityMaterialIcon("cmd_format_align_top", '\ue900')
        @JvmField
        val cmd_format_annotation_minus = CommunityMaterialIcon("cmd_format_annotation_minus", '\ue900')
        @JvmField
        val cmd_format_annotation_plus = CommunityMaterialIcon("cmd_format_annotation_plus", '\ue900')
        @JvmField
        val cmd_format_bold = CommunityMaterialIcon("cmd_format_bold", '\ue900')
        @JvmField
        val cmd_format_clear = CommunityMaterialIcon("cmd_format_clear", '\ue900')
        @JvmField
        val cmd_format_color_fill = CommunityMaterialIcon("cmd_format_color_fill", '\ue900')
        @JvmField
        val cmd_format_color_highlight = CommunityMaterialIcon("cmd_format_color_highlight", '\ue900')
        @JvmField
        val cmd_format_color_text = CommunityMaterialIcon("cmd_format_color_text", '\ue900')
        @JvmField
        val cmd_format_columns = CommunityMaterialIcon("cmd_format_columns", '\ue900')
        @JvmField
        val cmd_format_float_center = CommunityMaterialIcon("cmd_format_float_center", '\ue900')
        @JvmField
        val cmd_format_float_left = CommunityMaterialIcon("cmd_format_float_left", '\ue900')
        @JvmField
        val cmd_format_float_none = CommunityMaterialIcon("cmd_format_float_none", '\ue900')
        @JvmField
        val cmd_format_float_right = CommunityMaterialIcon("cmd_format_float_right", '\ue900')
        @JvmField
        val cmd_format_font_size_decrease = CommunityMaterialIcon("cmd_format_font_size_decrease", '\ue900')
        @JvmField
        val cmd_format_font_size_increase = CommunityMaterialIcon("cmd_format_font_size_increase", '\ue900')
        @JvmField
        val cmd_format_font = CommunityMaterialIcon("cmd_format_font", '\ue900')
        @JvmField
        val cmd_format_header_1 = CommunityMaterialIcon("cmd_format_header_1", '\ue900')
        @JvmField
        val cmd_format_header_2 = CommunityMaterialIcon("cmd_format_header_2", '\ue900')
        @JvmField
        val cmd_format_header_3 = CommunityMaterialIcon("cmd_format_header_3", '\ue900')
        @JvmField
        val cmd_format_header_4 = CommunityMaterialIcon("cmd_format_header_4", '\ue900')
        @JvmField
        val cmd_format_header_5 = CommunityMaterialIcon("cmd_format_header_5", '\ue900')
        @JvmField
        val cmd_format_header_6 = CommunityMaterialIcon("cmd_format_header_6", '\ue900')
        @JvmField
        val cmd_format_header_decrease = CommunityMaterialIcon("cmd_format_header_decrease", '\ue900')
        @JvmField
        val cmd_format_header_equal = CommunityMaterialIcon("cmd_format_header_equal", '\ue900')
        @JvmField
        val cmd_format_header_increase = CommunityMaterialIcon("cmd_format_header_increase", '\ue900')
        @JvmField
        val cmd_format_header_pound = CommunityMaterialIcon("cmd_format_header_pound", '\ue900')
        @JvmField
        val cmd_format_horizontal_align_center = CommunityMaterialIcon("cmd_format_horizontal_align_center", '\ue900')
        @JvmField
        val cmd_format_horizontal_align_left = CommunityMaterialIcon("cmd_format_horizontal_align_left", '\ue900')
        @JvmField
        val cmd_format_horizontal_align_right = CommunityMaterialIcon("cmd_format_horizontal_align_right", '\ue900')
        @JvmField
        val cmd_format_indent_decrease = CommunityMaterialIcon("cmd_format_indent_decrease", '\ue900')
        @JvmField
        val cmd_format_indent_increase = CommunityMaterialIcon("cmd_format_indent_increase", '\ue900')
        @JvmField
        val cmd_format_italic = CommunityMaterialIcon("cmd_format_italic", '\ue900')
        @JvmField
        val cmd_format_letter_case_lower = CommunityMaterialIcon("cmd_format_letter_case_lower", '\ue900')
        @JvmField
        val cmd_format_letter_case_upper = CommunityMaterialIcon("cmd_format_letter_case_upper", '\ue900')
        @JvmField
        val cmd_format_letter_case = CommunityMaterialIcon("cmd_format_letter_case", '\ue900')
        @JvmField
        val cmd_format_letter_ends_with = CommunityMaterialIcon("cmd_format_letter_ends_with", '\ue900')
        @JvmField
        val cmd_format_letter_matches = CommunityMaterialIcon("cmd_format_letter_matches", '\ue900')
        @JvmField
        val cmd_format_letter_starts_with = CommunityMaterialIcon("cmd_format_letter_starts_with", '\ue900')
        @JvmField
        val cmd_format_line_spacing = CommunityMaterialIcon("cmd_format_line_spacing", '\ue900')
        @JvmField
        val cmd_format_line_style = CommunityMaterialIcon("cmd_format_line_style", '\ue900')
        @JvmField
        val cmd_format_line_weight = CommunityMaterialIcon("cmd_format_line_weight", '\ue900')
        @JvmField
        val cmd_format_list_bulleted_square = CommunityMaterialIcon("cmd_format_list_bulleted_square", '\ue900')
        @JvmField
        val cmd_format_list_bulleted_triangle = CommunityMaterialIcon("cmd_format_list_bulleted_triangle", '\ue900')
        @JvmField
        val cmd_format_list_bulleted_type = CommunityMaterialIcon("cmd_format_list_bulleted_type", '\ue900')
        @JvmField
        val cmd_format_list_bulleted = CommunityMaterialIcon("cmd_format_list_bulleted", '\ue900')
        @JvmField
        val cmd_format_list_checkbox = CommunityMaterialIcon("cmd_format_list_checkbox", '\ue900')
        @JvmField
        val cmd_format_list_checks = CommunityMaterialIcon("cmd_format_list_checks", '\ue900')
        @JvmField
        val cmd_format_list_numbered_rtl = CommunityMaterialIcon("cmd_format_list_numbered_rtl", '\ue900')
        @JvmField
        val cmd_format_list_numbered = CommunityMaterialIcon("cmd_format_list_numbered", '\ue900')
        @JvmField
        val cmd_format_list_text = CommunityMaterialIcon("cmd_format_list_text", '\ue900')
        @JvmField
        val cmd_format_overline = CommunityMaterialIcon("cmd_format_overline", '\ue900')
        @JvmField
        val cmd_format_page_break = CommunityMaterialIcon("cmd_format_page_break", '\ue900')
        @JvmField
        val cmd_format_paint = CommunityMaterialIcon("cmd_format_paint", '\ue900')
        @JvmField
        val cmd_format_paragraph = CommunityMaterialIcon("cmd_format_paragraph", '\ue900')
        @JvmField
        val cmd_format_pilcrow = CommunityMaterialIcon("cmd_format_pilcrow", '\ue900')
        @JvmField
        val cmd_format_quote_close_outline = CommunityMaterialIcon("cmd_format_quote_close_outline", '\ue900')
        @JvmField
        val cmd_format_quote_close = CommunityMaterialIcon("cmd_format_quote_close", '\ue900')
        @JvmField
        val cmd_format_quote_open_outline = CommunityMaterialIcon("cmd_format_quote_open_outline", '\ue900')
        @JvmField
        val cmd_format_quote_open = CommunityMaterialIcon("cmd_format_quote_open", '\ue900')
        @JvmField
        val cmd_format_rotate_90 = CommunityMaterialIcon("cmd_format_rotate_90", '\ue900')
        @JvmField
        val cmd_format_section = CommunityMaterialIcon("cmd_format_section", '\ue900')
        @JvmField
        val cmd_format_size = CommunityMaterialIcon("cmd_format_size", '\ue900')
        @JvmField
        val cmd_format_strikethrough_variant = CommunityMaterialIcon("cmd_format_strikethrough_variant", '\ue900')
        @JvmField
        val cmd_format_strikethrough = CommunityMaterialIcon("cmd_format_strikethrough", '\ue900')
        @JvmField
        val cmd_format_subscript = CommunityMaterialIcon("cmd_format_subscript", '\ue900')
        @JvmField
        val cmd_format_superscript = CommunityMaterialIcon("cmd_format_superscript", '\ue900')
        @JvmField
        val cmd_format_text_rotation_angle_down = CommunityMaterialIcon("cmd_format_text_rotation_angle_down", '\ue900')
        @JvmField
        val cmd_format_text_rotation_angle_up = CommunityMaterialIcon("cmd_format_text_rotation_angle_up", '\ue900')
        @JvmField
        val cmd_format_text_rotation_down_vertical = CommunityMaterialIcon("cmd_format_text_rotation_down_vertical", '\ue900')
        @JvmField
        val cmd_format_text_rotation_down = CommunityMaterialIcon("cmd_format_text_rotation_down", '\ue900')
        @JvmField
        val cmd_format_text_rotation_none = CommunityMaterialIcon("cmd_format_text_rotation_none", '\ue900')
        @JvmField
        val cmd_format_text_rotation_up = CommunityMaterialIcon("cmd_format_text_rotation_up", '\ue900')
        @JvmField
        val cmd_format_text_rotation_vertical = CommunityMaterialIcon("cmd_format_text_rotation_vertical", '\ue900')
        @JvmField
        val cmd_format_text_variant = CommunityMaterialIcon("cmd_format_text_variant", '\ue900')
        @JvmField
        val cmd_format_text_wrapping_clip = CommunityMaterialIcon("cmd_format_text_wrapping_clip", '\ue900')
        @JvmField
        val cmd_format_text_wrapping_overflow = CommunityMaterialIcon("cmd_format_text_wrapping_overflow", '\ue900')
        @JvmField
        val cmd_format_text_wrapping_wrap = CommunityMaterialIcon("cmd_format_text_wrapping_wrap", '\ue900')
        @JvmField
        val cmd_format_text = CommunityMaterialIcon("cmd_format_text", '\ue900')
        @JvmField
        val cmd_format_textbox = CommunityMaterialIcon("cmd_format_textbox", '\ue900')
        @JvmField
        val cmd_format_textdirection_l_to_r = CommunityMaterialIcon("cmd_format_textdirection_l_to_r", '\ue900')
        @JvmField
        val cmd_format_textdirection_r_to_l = CommunityMaterialIcon("cmd_format_textdirection_r_to_l", '\ue900')
        @JvmField
        val cmd_format_title = CommunityMaterialIcon("cmd_format_title", '\ue900')
        @JvmField
        val cmd_format_underline = CommunityMaterialIcon("cmd_format_underline", '\ue900')
        @JvmField
        val cmd_format_vertical_align_bottom = CommunityMaterialIcon("cmd_format_vertical_align_bottom", '\ue900')
        @JvmField
        val cmd_format_vertical_align_center = CommunityMaterialIcon("cmd_format_vertical_align_center", '\ue900')
        @JvmField
        val cmd_format_vertical_align_top = CommunityMaterialIcon("cmd_format_vertical_align_top", '\ue900')
        @JvmField
        val cmd_format_wrap_inline = CommunityMaterialIcon("cmd_format_wrap_inline", '\ue900')
        @JvmField
        val cmd_format_wrap_square = CommunityMaterialIcon("cmd_format_wrap_square", '\ue900')
        @JvmField
        val cmd_format_wrap_tight = CommunityMaterialIcon("cmd_format_wrap_tight", '\ue900')
        @JvmField
        val cmd_format_wrap_top_bottom = CommunityMaterialIcon("cmd_format_wrap_top_bottom", '\ue900')
        @JvmField
        val cmd_forum_outline = CommunityMaterialIcon("cmd_forum_outline", '\ue900')
        @JvmField
        val cmd_forum = CommunityMaterialIcon("cmd_forum", '\ue900')
        @JvmField
        val cmd_forward = CommunityMaterialIcon("cmd_forward", '\ue900')
        @JvmField
        val cmd_forwardburger = CommunityMaterialIcon("cmd_forwardburger", '\ue900')
        @JvmField
        val cmd_fountain_pen_tip = CommunityMaterialIcon("cmd_fountain_pen_tip", '\ue900')
        @JvmField
        val cmd_fountain_pen = CommunityMaterialIcon("cmd_fountain_pen", '\ue900')
        @JvmField
        val cmd_fountain = CommunityMaterialIcon("cmd_fountain", '\ue900')
        @JvmField
        val cmd_foursquare = CommunityMaterialIcon("cmd_foursquare", '\ue900')
        @JvmField
        val cmd_freebsd = CommunityMaterialIcon("cmd_freebsd", '\ue900')
        @JvmField
        val cmd_frequently_asked_questions = CommunityMaterialIcon("cmd_frequently_asked_questions", '\ue900')
        @JvmField
        val cmd_fridge_alert_outline = CommunityMaterialIcon("cmd_fridge_alert_outline", '\ue900')
        @JvmField
        val cmd_fridge_alert = CommunityMaterialIcon("cmd_fridge_alert", '\ue900')
        @JvmField
        val cmd_fridge_bottom = CommunityMaterialIcon("cmd_fridge_bottom", '\ue900')
        @JvmField
        val cmd_fridge_off_outline = CommunityMaterialIcon("cmd_fridge_off_outline", '\ue900')
        @JvmField
        val cmd_fridge_off = CommunityMaterialIcon("cmd_fridge_off", '\ue900')
        @JvmField
        val cmd_fridge_outline = CommunityMaterialIcon("cmd_fridge_outline", '\ue900')
        @JvmField
        val cmd_fridge_top = CommunityMaterialIcon("cmd_fridge_top", '\ue900')
        @JvmField
        val cmd_fridge = CommunityMaterialIcon("cmd_fridge", '\ue900')
        @JvmField
        val cmd_fruit_cherries = CommunityMaterialIcon("cmd_fruit_cherries", '\ue900')
        @JvmField
        val cmd_fruit_citrus = CommunityMaterialIcon("cmd_fruit_citrus", '\ue900')
        @JvmField
        val cmd_fruit_grapes_outline = CommunityMaterialIcon("cmd_fruit_grapes_outline", '\ue900')
        @JvmField
        val cmd_fruit_grapes = CommunityMaterialIcon("cmd_fruit_grapes", '\ue900')
        @JvmField
        val cmd_fruit_pineapple = CommunityMaterialIcon("cmd_fruit_pineapple", '\ue900')
        @JvmField
        val cmd_fruit_watermelon = CommunityMaterialIcon("cmd_fruit_watermelon", '\ue900')
        @JvmField
        val cmd_fuel = CommunityMaterialIcon("cmd_fuel", '\ue900')
        @JvmField
        val cmd_fullscreen_exit = CommunityMaterialIcon("cmd_fullscreen_exit", '\ue900')
        @JvmField
        val cmd_fullscreen = CommunityMaterialIcon("cmd_fullscreen", '\ue900')
        @JvmField
        val cmd_function_variant = CommunityMaterialIcon("cmd_function_variant", '\ue900')
        @JvmField
        val cmd_function = CommunityMaterialIcon("cmd_function", '\ue900')
        @JvmField
        val cmd_furigana_horizontal = CommunityMaterialIcon("cmd_furigana_horizontal", '\ue900')
        @JvmField
        val cmd_furigana_vertical = CommunityMaterialIcon("cmd_furigana_vertical", '\ue900')
        @JvmField
        val cmd_fuse_blade = CommunityMaterialIcon("cmd_fuse_blade", '\ue900')
        @JvmField
        val cmd_fuse = CommunityMaterialIcon("cmd_fuse", '\ue900')
        @JvmField
        val cmd_gamepad_circle_down = CommunityMaterialIcon("cmd_gamepad_circle_down", '\ue900')
        @JvmField
        val cmd_gamepad_circle_left = CommunityMaterialIcon("cmd_gamepad_circle_left", '\ue900')
        @JvmField
        val cmd_gamepad_circle_outline = CommunityMaterialIcon("cmd_gamepad_circle_outline", '\ue900')
        @JvmField
        val cmd_gamepad_circle_right = CommunityMaterialIcon("cmd_gamepad_circle_right", '\ue900')
        @JvmField
        val cmd_gamepad_circle_up = CommunityMaterialIcon("cmd_gamepad_circle_up", '\ue900')
        @JvmField
        val cmd_gamepad_circle = CommunityMaterialIcon("cmd_gamepad_circle", '\ue900')
        @JvmField
        val cmd_gamepad_down = CommunityMaterialIcon("cmd_gamepad_down", '\ue900')
        @JvmField
        val cmd_gamepad_left = CommunityMaterialIcon("cmd_gamepad_left", '\ue900')
        @JvmField
        val cmd_gamepad_right = CommunityMaterialIcon("cmd_gamepad_right", '\ue900')
        @JvmField
        val cmd_gamepad_round_down = CommunityMaterialIcon("cmd_gamepad_round_down", '\ue900')
        @JvmField
        val cmd_gamepad_round_left = CommunityMaterialIcon("cmd_gamepad_round_left", '\ue900')
        @JvmField
        val cmd_gamepad_round_outline = CommunityMaterialIcon("cmd_gamepad_round_outline", '\ue900')
        @JvmField
        val cmd_gamepad_round_right = CommunityMaterialIcon("cmd_gamepad_round_right", '\ue900')
        @JvmField
        val cmd_gamepad_round_up = CommunityMaterialIcon("cmd_gamepad_round_up", '\ue900')
        @JvmField
        val cmd_gamepad_round = CommunityMaterialIcon("cmd_gamepad_round", '\ue900')
        @JvmField
        val cmd_gamepad_square_outline = CommunityMaterialIcon("cmd_gamepad_square_outline", '\ue900')
        @JvmField
        val cmd_gamepad_square = CommunityMaterialIcon("cmd_gamepad_square", '\ue900')
        @JvmField
        val cmd_gamepad_up = CommunityMaterialIcon("cmd_gamepad_up", '\ue900')
        @JvmField
        val cmd_gamepad_variant_outline = CommunityMaterialIcon("cmd_gamepad_variant_outline", '\ue900')
        @JvmField
        val cmd_gamepad_variant = CommunityMaterialIcon("cmd_gamepad_variant", '\ue900')
        @JvmField
        val cmd_gamepad = CommunityMaterialIcon("cmd_gamepad", '\ue900')
        @JvmField
        val cmd_gamma = CommunityMaterialIcon("cmd_gamma", '\ue900')
        @JvmField
        val cmd_gantry_crane = CommunityMaterialIcon("cmd_gantry_crane", '\ue900')
        @JvmField
        val cmd_garage_alert_variant = CommunityMaterialIcon("cmd_garage_alert_variant", '\ue900')
        @JvmField
        val cmd_garage_alert = CommunityMaterialIcon("cmd_garage_alert", '\ue900')
        @JvmField
        val cmd_garage_open_variant = CommunityMaterialIcon("cmd_garage_open_variant", '\ue900')
        @JvmField
        val cmd_garage_open = CommunityMaterialIcon("cmd_garage_open", '\ue900')
        @JvmField
        val cmd_garage_variant = CommunityMaterialIcon("cmd_garage_variant", '\ue900')
        @JvmField
        val cmd_garage = CommunityMaterialIcon("cmd_garage", '\ue900')
        @JvmField
        val cmd_gas_cylinder = CommunityMaterialIcon("cmd_gas_cylinder", '\ue900')
        @JvmField
        val cmd_gas_station_outline = CommunityMaterialIcon("cmd_gas_station_outline", '\ue900')
        @JvmField
        val cmd_gas_station = CommunityMaterialIcon("cmd_gas_station", '\ue900')
        @JvmField
        val cmd_gate_and = CommunityMaterialIcon("cmd_gate_and", '\ue900')
        @JvmField
        val cmd_gate_arrow_right = CommunityMaterialIcon("cmd_gate_arrow_right", '\ue900')
        @JvmField
        val cmd_gate_nand = CommunityMaterialIcon("cmd_gate_nand", '\ue900')
        @JvmField
        val cmd_gate_nor = CommunityMaterialIcon("cmd_gate_nor", '\ue900')
        @JvmField
        val cmd_gate_not = CommunityMaterialIcon("cmd_gate_not", '\ue900')
        @JvmField
        val cmd_gate_open = CommunityMaterialIcon("cmd_gate_open", '\ue900')
        @JvmField
        val cmd_gate_or = CommunityMaterialIcon("cmd_gate_or", '\ue900')
        @JvmField
        val cmd_gate_xnor = CommunityMaterialIcon("cmd_gate_xnor", '\ue900')
        @JvmField
        val cmd_gate_xor = CommunityMaterialIcon("cmd_gate_xor", '\ue900')
        @JvmField
        val cmd_gate = CommunityMaterialIcon("cmd_gate", '\ue900')
        @JvmField
        val cmd_gatsby = CommunityMaterialIcon("cmd_gatsby", '\ue900')
        @JvmField
        val cmd_gauge_empty = CommunityMaterialIcon("cmd_gauge_empty", '\ue900')
        @JvmField
        val cmd_gauge_full = CommunityMaterialIcon("cmd_gauge_full", '\ue900')
        @JvmField
        val cmd_gauge_low = CommunityMaterialIcon("cmd_gauge_low", '\ue900')
        @JvmField
        val cmd_gauge = CommunityMaterialIcon("cmd_gauge", '\ue900')
        @JvmField
        val cmd_gavel = CommunityMaterialIcon("cmd_gavel", '\ue900')
        @JvmField
        val cmd_gender_female = CommunityMaterialIcon("cmd_gender_female", '\ue900')
        @JvmField
        val cmd_gender_male_female_variant = CommunityMaterialIcon("cmd_gender_male_female_variant", '\ue900')
        @JvmField
        val cmd_gender_male_female = CommunityMaterialIcon("cmd_gender_male_female", '\ue900')
        @JvmField
        val cmd_gender_male = CommunityMaterialIcon("cmd_gender_male", '\ue900')
        @JvmField
        val cmd_gender_non_binary = CommunityMaterialIcon("cmd_gender_non_binary", '\ue900')
        @JvmField
        val cmd_gender_transgender = CommunityMaterialIcon("cmd_gender_transgender", '\ue900')
        @JvmField
        val cmd_gentoo = CommunityMaterialIcon("cmd_gentoo", '\ue900')
        @JvmField
        val cmd_gesture_double_tap = CommunityMaterialIcon("cmd_gesture_double_tap", '\ue900')
        @JvmField
        val cmd_gesture_pinch = CommunityMaterialIcon("cmd_gesture_pinch", '\ue900')
        @JvmField
        val cmd_gesture_spread = CommunityMaterialIcon("cmd_gesture_spread", '\ue900')
        @JvmField
        val cmd_gesture_swipe_down = CommunityMaterialIcon("cmd_gesture_swipe_down", '\ue900')
        @JvmField
        val cmd_gesture_swipe_horizontal = CommunityMaterialIcon("cmd_gesture_swipe_horizontal", '\ue900')
        @JvmField
        val cmd_gesture_swipe_left = CommunityMaterialIcon("cmd_gesture_swipe_left", '\ue900')
        @JvmField
        val cmd_gesture_swipe_right = CommunityMaterialIcon("cmd_gesture_swipe_right", '\ue900')
        @JvmField
        val cmd_gesture_swipe_up = CommunityMaterialIcon("cmd_gesture_swipe_up", '\ue900')
        @JvmField
        val cmd_gesture_swipe_vertical = CommunityMaterialIcon("cmd_gesture_swipe_vertical", '\ue900')
        @JvmField
        val cmd_gesture_swipe = CommunityMaterialIcon("cmd_gesture_swipe", '\ue900')
        @JvmField
        val cmd_gesture_tap_box = CommunityMaterialIcon("cmd_gesture_tap_box", '\ue900')
        @JvmField
        val cmd_gesture_tap_button = CommunityMaterialIcon("cmd_gesture_tap_button", '\ue900')
        @JvmField
        val cmd_gesture_tap_hold = CommunityMaterialIcon("cmd_gesture_tap_hold", '\ue900')
        @JvmField
        val cmd_gesture_tap = CommunityMaterialIcon("cmd_gesture_tap", '\ue900')
        @JvmField
        val cmd_gesture_two_double_tap = CommunityMaterialIcon("cmd_gesture_two_double_tap", '\ue900')
        @JvmField
        val cmd_gesture_two_tap = CommunityMaterialIcon("cmd_gesture_two_tap", '\ue900')
        @JvmField
        val cmd_gesture = CommunityMaterialIcon("cmd_gesture", '\ue900')
        @JvmField
        val cmd_ghost_off = CommunityMaterialIcon("cmd_ghost_off", '\ue900')
        @JvmField
        val cmd_ghost = CommunityMaterialIcon("cmd_ghost", '\ue900')
        @JvmField
        val cmd_gif = CommunityMaterialIcon("cmd_gif", '\ue900')
        @JvmField
        val cmd_gift_outline = CommunityMaterialIcon("cmd_gift_outline", '\ue900')
        @JvmField
        val cmd_gift = CommunityMaterialIcon("cmd_gift", '\ue900')
        @JvmField
        val cmd_git = CommunityMaterialIcon("cmd_git", '\ue900')
        @JvmField
        val cmd_github_box = CommunityMaterialIcon("cmd_github_box", '\ue900')
        @JvmField
        val cmd_github_circle = CommunityMaterialIcon("cmd_github_circle", '\ue900')
        @JvmField
        val cmd_github_face = CommunityMaterialIcon("cmd_github_face", '\ue900')
        @JvmField
        val cmd_gitlab = CommunityMaterialIcon("cmd_gitlab", '\ue900')
        @JvmField
        val cmd_glass_cocktail = CommunityMaterialIcon("cmd_glass_cocktail", '\ue900')
        @JvmField
        val cmd_glass_flute = CommunityMaterialIcon("cmd_glass_flute", '\ue900')
        @JvmField
        val cmd_glass_mug_variant = CommunityMaterialIcon("cmd_glass_mug_variant", '\ue900')
        @JvmField
        val cmd_glass_mug = CommunityMaterialIcon("cmd_glass_mug", '\ue900')
        @JvmField
        val cmd_glass_stange = CommunityMaterialIcon("cmd_glass_stange", '\ue900')
        @JvmField
        val cmd_glass_tulip = CommunityMaterialIcon("cmd_glass_tulip", '\ue900')
        @JvmField
        val cmd_glass_wine = CommunityMaterialIcon("cmd_glass_wine", '\ue900')
        @JvmField
        val cmd_glassdoor = CommunityMaterialIcon("cmd_glassdoor", '\ue900')
        @JvmField
        val cmd_glasses = CommunityMaterialIcon("cmd_glasses", '\ue900')
        @JvmField
        val cmd_globe_light = CommunityMaterialIcon("cmd_globe_light", '\ue900')
        @JvmField
        val cmd_globe_model = CommunityMaterialIcon("cmd_globe_model", '\ue900')
        @JvmField
        val cmd_gmail = CommunityMaterialIcon("cmd_gmail", '\ue900')
        @JvmField
        val cmd_gnome = CommunityMaterialIcon("cmd_gnome", '\ue900')
        @JvmField
        val cmd_go_kart_track = CommunityMaterialIcon("cmd_go_kart_track", '\ue900')
        @JvmField
        val cmd_go_kart = CommunityMaterialIcon("cmd_go_kart", '\ue900')
        @JvmField
        val cmd_gog = CommunityMaterialIcon("cmd_gog", '\ue900')
        @JvmField
        val cmd_gold = CommunityMaterialIcon("cmd_gold", '\ue900')
        @JvmField
        val cmd_golf_cart = CommunityMaterialIcon("cmd_golf_cart", '\ue900')
        @JvmField
        val cmd_golf_tee = CommunityMaterialIcon("cmd_golf_tee", '\ue900')
        @JvmField
        val cmd_golf = CommunityMaterialIcon("cmd_golf", '\ue900')
        @JvmField
        val cmd_gondola = CommunityMaterialIcon("cmd_gondola", '\ue900')
        @JvmField
        val cmd_goodreads = CommunityMaterialIcon("cmd_goodreads", '\ue900')
        @JvmField
        val cmd_google_adwords = CommunityMaterialIcon("cmd_google_adwords", '\ue900')
        @JvmField
        val cmd_google_analytics = CommunityMaterialIcon("cmd_google_analytics", '\ue900')
        @JvmField
        val cmd_google_assistant = CommunityMaterialIcon("cmd_google_assistant", '\ue900')
        @JvmField
        val cmd_google_cardboard = CommunityMaterialIcon("cmd_google_cardboard", '\ue900')
        @JvmField
        val cmd_google_chrome = CommunityMaterialIcon("cmd_google_chrome", '\ue900')
        @JvmField
        val cmd_google_circles_communities = CommunityMaterialIcon("cmd_google_circles_communities", '\ue900')
        @JvmField
        val cmd_google_circles_extended = CommunityMaterialIcon("cmd_google_circles_extended", '\ue900')
        @JvmField
        val cmd_google_circles_group = CommunityMaterialIcon("cmd_google_circles_group", '\ue900')
        @JvmField
        val cmd_google_circles = CommunityMaterialIcon("cmd_google_circles", '\ue900')
        @JvmField
        val cmd_google_classroom = CommunityMaterialIcon("cmd_google_classroom", '\ue900')
        @JvmField
        val cmd_google_cloud = CommunityMaterialIcon("cmd_google_cloud", '\ue900')
        @JvmField
        val cmd_google_controller_off = CommunityMaterialIcon("cmd_google_controller_off", '\ue900')
        @JvmField
        val cmd_google_controller = CommunityMaterialIcon("cmd_google_controller", '\ue900')
        @JvmField
        val cmd_google_drive = CommunityMaterialIcon("cmd_google_drive", '\ue900')
        @JvmField
        val cmd_google_earth = CommunityMaterialIcon("cmd_google_earth", '\ue900')
        @JvmField
        val cmd_google_fit = CommunityMaterialIcon("cmd_google_fit", '\ue900')
        @JvmField
        val cmd_google_glass = CommunityMaterialIcon("cmd_google_glass", '\ue900')
        @JvmField
        val cmd_google_hangouts = CommunityMaterialIcon("cmd_google_hangouts", '\ue900')
        @JvmField
        val cmd_google_home = CommunityMaterialIcon("cmd_google_home", '\ue900')
        @JvmField
        val cmd_google_keep = CommunityMaterialIcon("cmd_google_keep", '\ue900')
        @JvmField
        val cmd_google_lens = CommunityMaterialIcon("cmd_google_lens", '\ue900')
        @JvmField
        val cmd_google_maps = CommunityMaterialIcon("cmd_google_maps", '\ue900')
        @JvmField
        val cmd_google_my_business = CommunityMaterialIcon("cmd_google_my_business", '\ue900')
        @JvmField
        val cmd_google_nearby = CommunityMaterialIcon("cmd_google_nearby", '\ue900')
        @JvmField
        val cmd_google_pages = CommunityMaterialIcon("cmd_google_pages", '\ue900')
        @JvmField
        val cmd_google_photos = CommunityMaterialIcon("cmd_google_photos", '\ue900')
        @JvmField
        val cmd_google_physical_web = CommunityMaterialIcon("cmd_google_physical_web", '\ue900')
        @JvmField
        val cmd_google_play = CommunityMaterialIcon("cmd_google_play", '\ue900')
        @JvmField
        val cmd_google_plus_box = CommunityMaterialIcon("cmd_google_plus_box", '\ue900')
        @JvmField
        val cmd_google_plus = CommunityMaterialIcon("cmd_google_plus", '\ue900')
        @JvmField
        val cmd_google_podcast = CommunityMaterialIcon("cmd_google_podcast", '\ue900')
        @JvmField
        val cmd_google_spreadsheet = CommunityMaterialIcon("cmd_google_spreadsheet", '\ue900')
        @JvmField
        val cmd_google_street_view = CommunityMaterialIcon("cmd_google_street_view", '\ue900')
        @JvmField
        val cmd_google_translate = CommunityMaterialIcon("cmd_google_translate", '\ue900')
        @JvmField
        val cmd_google = CommunityMaterialIcon("cmd_google", '\ue900')
        @JvmField
        val cmd_gradient = CommunityMaterialIcon("cmd_gradient", '\ue900')
        @JvmField
        val cmd_grain = CommunityMaterialIcon("cmd_grain", '\ue900')
        @JvmField
        val cmd_graph_outline = CommunityMaterialIcon("cmd_graph_outline", '\ue900')
        @JvmField
        val cmd_graph = CommunityMaterialIcon("cmd_graph", '\ue900')
        @JvmField
        val cmd_graphql = CommunityMaterialIcon("cmd_graphql", '\ue900')
        @JvmField
        val cmd_grave_stone = CommunityMaterialIcon("cmd_grave_stone", '\ue900')
        @JvmField
        val cmd_grease_pencil = CommunityMaterialIcon("cmd_grease_pencil", '\ue900')
        @JvmField
        val cmd_greater_than_or_equal = CommunityMaterialIcon("cmd_greater_than_or_equal", '\ue900')
        @JvmField
        val cmd_greater_than = CommunityMaterialIcon("cmd_greater_than", '\ue900')
        @JvmField
        val cmd_grid_large = CommunityMaterialIcon("cmd_grid_large", '\ue900')
        @JvmField
        val cmd_grid_off = CommunityMaterialIcon("cmd_grid_off", '\ue900')
        @JvmField
        val cmd_grid = CommunityMaterialIcon("cmd_grid", '\ue900')
        @JvmField
        val cmd_grill_outline = CommunityMaterialIcon("cmd_grill_outline", '\ue900')
        @JvmField
        val cmd_grill = CommunityMaterialIcon("cmd_grill", '\ue900')
        @JvmField
        val cmd_group = CommunityMaterialIcon("cmd_group", '\ue900')
        @JvmField
        val cmd_guitar_acoustic = CommunityMaterialIcon("cmd_guitar_acoustic", '\ue900')
        @JvmField
        val cmd_guitar_electric = CommunityMaterialIcon("cmd_guitar_electric", '\ue900')
        @JvmField
        val cmd_guitar_pick_outline = CommunityMaterialIcon("cmd_guitar_pick_outline", '\ue900')
        @JvmField
        val cmd_guitar_pick = CommunityMaterialIcon("cmd_guitar_pick", '\ue900')
        @JvmField
        val cmd_guy_fawkes_mask = CommunityMaterialIcon("cmd_guy_fawkes_mask", '\ue900')
        @JvmField
        val cmd_hackernews = CommunityMaterialIcon("cmd_hackernews", '\ue900')
        @JvmField
        val cmd_hail = CommunityMaterialIcon("cmd_hail", '\ue900')
        @JvmField
        val cmd_ab_testing = CommunityMaterialIcon("cmd_ab_testing", '\ue900')
        @JvmField
        val cmd_access_point_network_off = CommunityMaterialIcon("cmd_access_point_network_off", '\ue900')
        @JvmField
        val cmd_access_point_network = CommunityMaterialIcon("cmd_access_point_network", '\ue900')
        @JvmField
        val cmd_access_point = CommunityMaterialIcon("cmd_access_point", '\ue900')
        @JvmField
        val cmd_account_alert_outline = CommunityMaterialIcon("cmd_account_alert_outline", '\ue900')
        @JvmField
        val cmd_account_alert = CommunityMaterialIcon("cmd_account_alert", '\ue900')
        @JvmField
        val cmd_account_arrow_left_outline = CommunityMaterialIcon("cmd_account_arrow_left_outline", '\ue900')
        @JvmField
        val cmd_account_arrow_left = CommunityMaterialIcon("cmd_account_arrow_left", '\ue900')
        @JvmField
        val cmd_account_arrow_right_outline = CommunityMaterialIcon("cmd_account_arrow_right_outline", '\ue900')
        @JvmField
        val cmd_account_arrow_right = CommunityMaterialIcon("cmd_account_arrow_right", '\ue900')
        @JvmField
        val cmd_account_badge_alert_outline = CommunityMaterialIcon("cmd_account_badge_alert_outline", '\ue900')
        @JvmField
        val cmd_account_badge_alert = CommunityMaterialIcon("cmd_account_badge_alert", '\ue900')
        @JvmField
        val cmd_account_badge_horizontal_outline = CommunityMaterialIcon("cmd_account_badge_horizontal_outline", '\ue900')
        @JvmField
        val cmd_account_badge_horizontal = CommunityMaterialIcon("cmd_account_badge_horizontal", '\ue900')
        @JvmField
        val cmd_account_badge_outline = CommunityMaterialIcon("cmd_account_badge_outline", '\ue900')
        @JvmField
        val cmd_account_badge = CommunityMaterialIcon("cmd_account_badge", '\ue900')
        @JvmField
        val cmd_account_box_multiple_outline = CommunityMaterialIcon("cmd_account_box_multiple_outline", '\ue900')
        @JvmField
        val cmd_account_box_multiple = CommunityMaterialIcon("cmd_account_box_multiple", '\ue900')
        @JvmField
        val cmd_account_box_outline = CommunityMaterialIcon("cmd_account_box_outline", '\ue900')
        @JvmField
        val cmd_account_box = CommunityMaterialIcon("cmd_account_box", '\ue900')
        @JvmField
        val cmd_account_cancel_outline = CommunityMaterialIcon("cmd_account_cancel_outline", '\ue900')
        @JvmField
        val cmd_account_cancel = CommunityMaterialIcon("cmd_account_cancel", '\ue900')
        @JvmField
        val cmd_account_card_details_outline = CommunityMaterialIcon("cmd_account_card_details_outline", '\ue900')
        @JvmField
        val cmd_account_card_details = CommunityMaterialIcon("cmd_account_card_details", '\ue900')
        @JvmField
        val cmd_account_cash_outline = CommunityMaterialIcon("cmd_account_cash_outline", '\ue900')
        @JvmField
        val cmd_account_cash = CommunityMaterialIcon("cmd_account_cash", '\ue900')
        @JvmField
        val cmd_account_check_outline = CommunityMaterialIcon("cmd_account_check_outline", '\ue900')
        @JvmField
        val cmd_account_check = CommunityMaterialIcon("cmd_account_check", '\ue900')
        @JvmField
        val cmd_account_child_circle = CommunityMaterialIcon("cmd_account_child_circle", '\ue900')
        @JvmField
        val cmd_account_child_outline = CommunityMaterialIcon("cmd_account_child_outline", '\ue900')
        @JvmField
        val cmd_account_child = CommunityMaterialIcon("cmd_account_child", '\ue900')
        @JvmField
        val cmd_account_circle_outline = CommunityMaterialIcon("cmd_account_circle_outline", '\ue900')
        @JvmField
        val cmd_account_circle = CommunityMaterialIcon("cmd_account_circle", '\ue900')
        @JvmField
        val cmd_account_clock_outline = CommunityMaterialIcon("cmd_account_clock_outline", '\ue900')
        @JvmField
        val cmd_account_clock = CommunityMaterialIcon("cmd_account_clock", '\ue900')
        @JvmField
        val cmd_account_convert = CommunityMaterialIcon("cmd_account_convert", '\ue900')
        @JvmField
        val cmd_account_details = CommunityMaterialIcon("cmd_account_details", '\ue900')
        @JvmField
        val cmd_account_edit_outline = CommunityMaterialIcon("cmd_account_edit_outline", '\ue900')
        @JvmField
        val cmd_account_edit = CommunityMaterialIcon("cmd_account_edit", '\ue900')
        @JvmField
        val cmd_account_group_outline = CommunityMaterialIcon("cmd_account_group_outline", '\ue900')
        @JvmField
        val cmd_account_group = CommunityMaterialIcon("cmd_account_group", '\ue900')
        @JvmField
        val cmd_account_heart_outline = CommunityMaterialIcon("cmd_account_heart_outline", '\ue900')
        @JvmField
        val cmd_account_heart = CommunityMaterialIcon("cmd_account_heart", '\ue900')
        @JvmField
        val cmd_account_key_outline = CommunityMaterialIcon("cmd_account_key_outline", '\ue900')
        @JvmField
        val cmd_account_key = CommunityMaterialIcon("cmd_account_key", '\ue900')
        @JvmField
        val cmd_account_lock_outline = CommunityMaterialIcon("cmd_account_lock_outline", '\ue900')
        @JvmField
        val cmd_account_lock = CommunityMaterialIcon("cmd_account_lock", '\ue900')
        @JvmField
        val cmd_account_minus_outline = CommunityMaterialIcon("cmd_account_minus_outline", '\ue900')
        @JvmField
        val cmd_account_minus = CommunityMaterialIcon("cmd_account_minus", '\ue900')
        @JvmField
        val cmd_account_multiple_check_outline = CommunityMaterialIcon("cmd_account_multiple_check_outline", '\ue900')
        @JvmField
        val cmd_account_multiple_check = CommunityMaterialIcon("cmd_account_multiple_check", '\ue900')
        @JvmField
        val cmd_account_multiple_minus_outline = CommunityMaterialIcon("cmd_account_multiple_minus_outline", '\ue900')
        @JvmField
        val cmd_account_multiple_minus = CommunityMaterialIcon("cmd_account_multiple_minus", '\ue900')
        @JvmField
        val cmd_account_multiple_outline = CommunityMaterialIcon("cmd_account_multiple_outline", '\ue900')
        @JvmField
        val cmd_account_multiple_plus_outline = CommunityMaterialIcon("cmd_account_multiple_plus_outline", '\ue900')
        @JvmField
        val cmd_account_multiple_plus = CommunityMaterialIcon("cmd_account_multiple_plus", '\ue900')
        @JvmField
        val cmd_account_multiple_remove_outline = CommunityMaterialIcon("cmd_account_multiple_remove_outline", '\ue900')
        @JvmField
        val cmd_account_multiple_remove = CommunityMaterialIcon("cmd_account_multiple_remove", '\ue900')
        @JvmField
        val cmd_account_multiple = CommunityMaterialIcon("cmd_account_multiple", '\ue900')
        @JvmField
        val cmd_account_network_outline = CommunityMaterialIcon("cmd_account_network_outline", '\ue900')
        @JvmField
        val cmd_account_network = CommunityMaterialIcon("cmd_account_network", '\ue900')
        @JvmField
        val cmd_account_off_outline = CommunityMaterialIcon("cmd_account_off_outline", '\ue900')
        @JvmField
        val cmd_account_off = CommunityMaterialIcon("cmd_account_off", '\ue900')
        @JvmField
        val cmd_account_outline = CommunityMaterialIcon("cmd_account_outline", '\ue900')
        @JvmField
        val cmd_account_plus_outline = CommunityMaterialIcon("cmd_account_plus_outline", '\ue900')
        @JvmField
        val cmd_account_plus = CommunityMaterialIcon("cmd_account_plus", '\ue900')
        @JvmField
        val cmd_account_question_outline = CommunityMaterialIcon("cmd_account_question_outline", '\ue900')
        @JvmField
        val cmd_account_question = CommunityMaterialIcon("cmd_account_question", '\ue900')
        @JvmField
        val cmd_account_remove_outline = CommunityMaterialIcon("cmd_account_remove_outline", '\ue900')
        @JvmField
        val cmd_account_remove = CommunityMaterialIcon("cmd_account_remove", '\ue900')
        @JvmField
        val cmd_account_search_outline = CommunityMaterialIcon("cmd_account_search_outline", '\ue900')
        @JvmField
        val cmd_account_search = CommunityMaterialIcon("cmd_account_search", '\ue900')
        @JvmField
        val cmd_account_settings_outline = CommunityMaterialIcon("cmd_account_settings_outline", '\ue900')
        @JvmField
        val cmd_account_settings = CommunityMaterialIcon("cmd_account_settings", '\ue900')
        @JvmField
        val cmd_account_star_outline = CommunityMaterialIcon("cmd_account_star_outline", '\ue900')
        @JvmField
        val cmd_account_star = CommunityMaterialIcon("cmd_account_star", '\ue900')
        @JvmField
        val cmd_account_supervisor_circle = CommunityMaterialIcon("cmd_account_supervisor_circle", '\ue900')
        @JvmField
        val cmd_account_supervisor_outline = CommunityMaterialIcon("cmd_account_supervisor_outline", '\ue900')
        @JvmField
        val cmd_account_supervisor = CommunityMaterialIcon("cmd_account_supervisor", '\ue900')
        @JvmField
        val cmd_account_switch = CommunityMaterialIcon("cmd_account_switch", '\ue900')
        @JvmField
        val cmd_account_tie_outline = CommunityMaterialIcon("cmd_account_tie_outline", '\ue900')
        @JvmField
        val cmd_account_tie = CommunityMaterialIcon("cmd_account_tie", '\ue900')
        @JvmField
        val cmd_account = CommunityMaterialIcon("cmd_account", '\ue900')
        @JvmField
        val cmd_accusoft = CommunityMaterialIcon("cmd_accusoft", '\ue900')
        @JvmField
        val cmd_adchoices = CommunityMaterialIcon("cmd_adchoices", '\ue900')
        @JvmField
        val cmd_adjust = CommunityMaterialIcon("cmd_adjust", '\ue900')
        @JvmField
        val cmd_adobe_acrobat = CommunityMaterialIcon("cmd_adobe_acrobat", '\ue900')
        @JvmField
        val cmd_adobe = CommunityMaterialIcon("cmd_adobe", '\ue900')
        @JvmField
        val cmd_air_conditioner = CommunityMaterialIcon("cmd_air_conditioner", '\ue900')
        @JvmField
        val cmd_air_filter = CommunityMaterialIcon("cmd_air_filter", '\ue900')
        @JvmField
        val cmd_air_horn = CommunityMaterialIcon("cmd_air_horn", '\ue900')
        @JvmField
        val cmd_air_humidifier = CommunityMaterialIcon("cmd_air_humidifier", '\ue900')
        @JvmField
        val cmd_air_purifier = CommunityMaterialIcon("cmd_air_purifier", '\ue900')
        @JvmField
        val cmd_airbag = CommunityMaterialIcon("cmd_airbag", '\ue900')
        @JvmField
        val cmd_airballoon_outline = CommunityMaterialIcon("cmd_airballoon_outline", '\ue900')
        @JvmField
        val cmd_airballoon = CommunityMaterialIcon("cmd_airballoon", '\ue900')
        @JvmField
        val cmd_airplane_landing = CommunityMaterialIcon("cmd_airplane_landing", '\ue900')
        @JvmField
        val cmd_airplane_off = CommunityMaterialIcon("cmd_airplane_off", '\ue900')
        @JvmField
        val cmd_airplane_takeoff = CommunityMaterialIcon("cmd_airplane_takeoff", '\ue900')
        @JvmField
        val cmd_airplane = CommunityMaterialIcon("cmd_airplane", '\ue900')
        @JvmField
        val cmd_airplay = CommunityMaterialIcon("cmd_airplay", '\ue900')
        @JvmField
        val cmd_airport = CommunityMaterialIcon("cmd_airport", '\ue900')
        @JvmField
        val cmd_alarm_bell = CommunityMaterialIcon("cmd_alarm_bell", '\ue900')
        @JvmField
        val cmd_alarm_check = CommunityMaterialIcon("cmd_alarm_check", '\ue900')
        @JvmField
        val cmd_alarm_light_outline = CommunityMaterialIcon("cmd_alarm_light_outline", '\ue900')
        @JvmField
        val cmd_alarm_light = CommunityMaterialIcon("cmd_alarm_light", '\ue900')
        @JvmField
        val cmd_alarm_multiple = CommunityMaterialIcon("cmd_alarm_multiple", '\ue900')
        @JvmField
        val cmd_alarm_note_off = CommunityMaterialIcon("cmd_alarm_note_off", '\ue900')
        @JvmField
        val cmd_alarm_note = CommunityMaterialIcon("cmd_alarm_note", '\ue900')
        @JvmField
        val cmd_alarm_off = CommunityMaterialIcon("cmd_alarm_off", '\ue900')
        @JvmField
        val cmd_alarm_plus = CommunityMaterialIcon("cmd_alarm_plus", '\ue900')
        @JvmField
        val cmd_alarm_snooze = CommunityMaterialIcon("cmd_alarm_snooze", '\ue900')
        @JvmField
        val cmd_alarm = CommunityMaterialIcon("cmd_alarm", '\ue900')
        @JvmField
        val cmd_album = CommunityMaterialIcon("cmd_album", '\ue900')
        @JvmField
        val cmd_alert_box_outline = CommunityMaterialIcon("cmd_alert_box_outline", '\ue900')
        @JvmField
        val cmd_alert_box = CommunityMaterialIcon("cmd_alert_box", '\ue900')
        @JvmField
        val cmd_alert_circle_check_outline = CommunityMaterialIcon("cmd_alert_circle_check_outline", '\ue900')
        @JvmField
        val cmd_alert_circle_check = CommunityMaterialIcon("cmd_alert_circle_check", '\ue900')
        @JvmField
        val cmd_alert_circle_outline = CommunityMaterialIcon("cmd_alert_circle_outline", '\ue900')
        @JvmField
        val cmd_alert_circle = CommunityMaterialIcon("cmd_alert_circle", '\ue900')
        @JvmField
        val cmd_alert_decagram_outline = CommunityMaterialIcon("cmd_alert_decagram_outline", '\ue900')
        @JvmField
        val cmd_alert_decagram = CommunityMaterialIcon("cmd_alert_decagram", '\ue900')
        @JvmField
        val cmd_alert_octagon_outline = CommunityMaterialIcon("cmd_alert_octagon_outline", '\ue900')
        @JvmField
        val cmd_alert_octagon = CommunityMaterialIcon("cmd_alert_octagon", '\ue900')
        @JvmField
        val cmd_alert_octagram_outline = CommunityMaterialIcon("cmd_alert_octagram_outline", '\ue900')
        @JvmField
        val cmd_alert_octagram = CommunityMaterialIcon("cmd_alert_octagram", '\ue900')
        @JvmField
        val cmd_alert_outline = CommunityMaterialIcon("cmd_alert_outline", '\ue900')
        @JvmField
        val cmd_alert_rhombus_outline = CommunityMaterialIcon("cmd_alert_rhombus_outline", '\ue900')
        @JvmField
        val cmd_alert_rhombus = CommunityMaterialIcon("cmd_alert_rhombus", '\ue900')
        @JvmField
        val cmd_alert = CommunityMaterialIcon("cmd_alert", '\ue900')
        @JvmField
        val cmd_alien_outline = CommunityMaterialIcon("cmd_alien_outline", '\ue900')
        @JvmField
        val cmd_alien = CommunityMaterialIcon("cmd_alien", '\ue900')
        @JvmField
        val cmd_align_horizontal_center = CommunityMaterialIcon("cmd_align_horizontal_center", '\ue900')
        @JvmField
        val cmd_align_horizontal_left = CommunityMaterialIcon("cmd_align_horizontal_left", '\ue900')
        @JvmField
        val cmd_align_horizontal_right = CommunityMaterialIcon("cmd_align_horizontal_right", '\ue900')
        @JvmField
        val cmd_align_vertical_bottom = CommunityMaterialIcon("cmd_align_vertical_bottom", '\ue900')
        @JvmField
        val cmd_align_vertical_center = CommunityMaterialIcon("cmd_align_vertical_center", '\ue900')
        @JvmField
        val cmd_align_vertical_top = CommunityMaterialIcon("cmd_align_vertical_top", '\ue900')
        @JvmField
        val cmd_all_inclusive = CommunityMaterialIcon("cmd_all_inclusive", '\ue900')
        @JvmField
        val cmd_allergy = CommunityMaterialIcon("cmd_allergy", '\ue900')
        @JvmField
        val cmd_alpha_a_box_outline = CommunityMaterialIcon("cmd_alpha_a_box_outline", '\ue900')
        @JvmField
        val cmd_alpha_a_box = CommunityMaterialIcon("cmd_alpha_a_box", '\ue900')
        @JvmField
        val cmd_alpha_a_circle_outline = CommunityMaterialIcon("cmd_alpha_a_circle_outline", '\ue900')
        @JvmField
        val cmd_alpha_a_circle = CommunityMaterialIcon("cmd_alpha_a_circle", '\ue900')
        @JvmField
        val cmd_alpha_a = CommunityMaterialIcon("cmd_alpha_a", '\ue900')
        @JvmField
        val cmd_alpha_b_box_outline = CommunityMaterialIcon("cmd_alpha_b_box_outline", '\ue900')
        @JvmField
        val cmd_alpha_b_box = CommunityMaterialIcon("cmd_alpha_b_box", '\ue900')
        @JvmField
        val cmd_alpha_b_circle_outline = CommunityMaterialIcon("cmd_alpha_b_circle_outline", '\ue900')
        @JvmField
        val cmd_alpha_b_circle = CommunityMaterialIcon("cmd_alpha_b_circle", '\ue900')
        @JvmField
        val cmd_alpha_b = CommunityMaterialIcon("cmd_alpha_b", '\ue900')
        @JvmField
        val cmd_alpha_c_box_outline = CommunityMaterialIcon("cmd_alpha_c_box_outline", '\ue900')
        @JvmField
        val cmd_alpha_c_box = CommunityMaterialIcon("cmd_alpha_c_box", '\ue900')
        @JvmField
        val cmd_alpha_c_circle_outline = CommunityMaterialIcon("cmd_alpha_c_circle_outline", '\ue900')
        @JvmField
        val cmd_alpha_c_circle = CommunityMaterialIcon("cmd_alpha_c_circle", '\ue900')
        @JvmField
        val cmd_alpha_c = CommunityMaterialIcon("cmd_alpha_c", '\ue900')
        @JvmField
        val cmd_alpha_d_box_outline = CommunityMaterialIcon("cmd_alpha_d_box_outline", '\ue900')
        @JvmField
        val cmd_alpha_d_box = CommunityMaterialIcon("cmd_alpha_d_box", '\ue900')
        @JvmField
        val cmd_alpha_d_circle_outline = CommunityMaterialIcon("cmd_alpha_d_circle_outline", '\ue900')
        @JvmField
        val cmd_alpha_d_circle = CommunityMaterialIcon("cmd_alpha_d_circle", '\ue900')
        @JvmField
        val cmd_alpha_d = CommunityMaterialIcon("cmd_alpha_d", '\ue900')
        @JvmField
        val cmd_alpha_e_box_outline = CommunityMaterialIcon("cmd_alpha_e_box_outline", '\ue900')
        @JvmField
        val cmd_alpha_e_box = CommunityMaterialIcon("cmd_alpha_e_box", '\ue900')
        @JvmField
        val cmd_alpha_e_circle_outline = CommunityMaterialIcon("cmd_alpha_e_circle_outline", '\ue900')
        @JvmField
        val cmd_alpha_e_circle = CommunityMaterialIcon("cmd_alpha_e_circle", '\ue900')
        @JvmField
        val cmd_alpha_e = CommunityMaterialIcon("cmd_alpha_e", '\ue900')
        @JvmField
        val cmd_alpha_f_box_outline = CommunityMaterialIcon("cmd_alpha_f_box_outline", '\ue900')
        @JvmField
        val cmd_alpha_f_box = CommunityMaterialIcon("cmd_alpha_f_box", '\ue900')
        @JvmField
        val cmd_alpha_f_circle_outline = CommunityMaterialIcon("cmd_alpha_f_circle_outline", '\ue900')
        @JvmField
        val cmd_alpha_f_circle = CommunityMaterialIcon("cmd_alpha_f_circle", '\ue900')
        @JvmField
        val cmd_alpha_f = CommunityMaterialIcon("cmd_alpha_f", '\ue900')
        @JvmField
        val cmd_alpha_g_box_outline = CommunityMaterialIcon("cmd_alpha_g_box_outline", '\ue900')
        @JvmField
        val cmd_alpha_g_box = CommunityMaterialIcon("cmd_alpha_g_box", '\ue900')
        @JvmField
        val cmd_alpha_g_circle_outline = CommunityMaterialIcon("cmd_alpha_g_circle_outline", '\ue900')
        @JvmField
        val cmd_alpha_g_circle = CommunityMaterialIcon("cmd_alpha_g_circle", '\ue900')
        @JvmField
        val cmd_alpha_g = CommunityMaterialIcon("cmd_alpha_g", '\ue900')
        @JvmField
        val cmd_alpha_h_box_outline = CommunityMaterialIcon("cmd_alpha_h_box_outline", '\ue900')
        @JvmField
        val cmd_alpha_h_box = CommunityMaterialIcon("cmd_alpha_h_box", '\ue900')
        @JvmField
        val cmd_alpha_h_circle_outline = CommunityMaterialIcon("cmd_alpha_h_circle_outline", '\ue900')
        @JvmField
        val cmd_alpha_h_circle = CommunityMaterialIcon("cmd_alpha_h_circle", '\ue900')
        @JvmField
        val cmd_alpha_h = CommunityMaterialIcon("cmd_alpha_h", '\ue900')
        @JvmField
        val cmd_alpha_i_box_outline = CommunityMaterialIcon("cmd_alpha_i_box_outline", '\ue900')
        @JvmField
        val cmd_alpha_i_box = CommunityMaterialIcon("cmd_alpha_i_box", '\ue900')
        @JvmField
        val cmd_alpha_i_circle_outline = CommunityMaterialIcon("cmd_alpha_i_circle_outline", '\ue900')
        @JvmField
        val cmd_alpha_i_circle = CommunityMaterialIcon("cmd_alpha_i_circle", '\ue900')
        @JvmField
        val cmd_alpha_i = CommunityMaterialIcon("cmd_alpha_i", '\ue900')
        @JvmField
        val cmd_alpha_j_box_outline = CommunityMaterialIcon("cmd_alpha_j_box_outline", '\ue900')
        @JvmField
        val cmd_alpha_j_box = CommunityMaterialIcon("cmd_alpha_j_box", '\ue900')
        @JvmField
        val cmd_alpha_j_circle_outline = CommunityMaterialIcon("cmd_alpha_j_circle_outline", '\ue900')
        @JvmField
        val cmd_alpha_j_circle = CommunityMaterialIcon("cmd_alpha_j_circle", '\ue900')
        @JvmField
        val cmd_alpha_j = CommunityMaterialIcon("cmd_alpha_j", '\ue900')
        @JvmField
        val cmd_alpha_k_box_outline = CommunityMaterialIcon("cmd_alpha_k_box_outline", '\ue900')
        @JvmField
        val cmd_alpha_k_box = CommunityMaterialIcon("cmd_alpha_k_box", '\ue900')
        @JvmField
        val cmd_alpha_k_circle_outline = CommunityMaterialIcon("cmd_alpha_k_circle_outline", '\ue900')
        @JvmField
        val cmd_alpha_k_circle = CommunityMaterialIcon("cmd_alpha_k_circle", '\ue900')
        @JvmField
        val cmd_alpha_k = CommunityMaterialIcon("cmd_alpha_k", '\ue900')
        @JvmField
        val cmd_alpha_l_box_outline = CommunityMaterialIcon("cmd_alpha_l_box_outline", '\ue900')
        @JvmField
        val cmd_alpha_l_box = CommunityMaterialIcon("cmd_alpha_l_box", '\ue900')
        @JvmField
        val cmd_alpha_l_circle_outline = CommunityMaterialIcon("cmd_alpha_l_circle_outline", '\ue900')
        @JvmField
        val cmd_alpha_l_circle = CommunityMaterialIcon("cmd_alpha_l_circle", '\ue900')
        @JvmField
        val cmd_alpha_l = CommunityMaterialIcon("cmd_alpha_l", '\ue900')
        @JvmField
        val cmd_alpha_m_box_outline = CommunityMaterialIcon("cmd_alpha_m_box_outline", '\ue900')
        @JvmField
        val cmd_alpha_m_box = CommunityMaterialIcon("cmd_alpha_m_box", '\ue900')
        @JvmField
        val cmd_alpha_m_circle_outline = CommunityMaterialIcon("cmd_alpha_m_circle_outline", '\ue900')
        @JvmField
        val cmd_alpha_m_circle = CommunityMaterialIcon("cmd_alpha_m_circle", '\ue900')
        @JvmField
        val cmd_alpha_m = CommunityMaterialIcon("cmd_alpha_m", '\ue900')
        @JvmField
        val cmd_alpha_n_box_outline = CommunityMaterialIcon("cmd_alpha_n_box_outline", '\ue900')
        @JvmField
        val cmd_alpha_n_box = CommunityMaterialIcon("cmd_alpha_n_box", '\ue900')
        @JvmField
        val cmd_alpha_n_circle_outline = CommunityMaterialIcon("cmd_alpha_n_circle_outline", '\ue900')
        @JvmField
        val cmd_alpha_n_circle = CommunityMaterialIcon("cmd_alpha_n_circle", '\ue900')
        @JvmField
        val cmd_alpha_n = CommunityMaterialIcon("cmd_alpha_n", '\ue900')
        @JvmField
        val cmd_alpha_o_box_outline = CommunityMaterialIcon("cmd_alpha_o_box_outline", '\ue900')
        @JvmField
        val cmd_alpha_o_box = CommunityMaterialIcon("cmd_alpha_o_box", '\ue900')
        @JvmField
        val cmd_alpha_o_circle_outline = CommunityMaterialIcon("cmd_alpha_o_circle_outline", '\ue900')
        @JvmField
        val cmd_alpha_o_circle = CommunityMaterialIcon("cmd_alpha_o_circle", '\ue900')
        @JvmField
        val cmd_alpha_o = CommunityMaterialIcon("cmd_alpha_o", '\ue900')
        @JvmField
        val cmd_alpha_p_box_outline = CommunityMaterialIcon("cmd_alpha_p_box_outline", '\ue900')
        @JvmField
        val cmd_alpha_p_box = CommunityMaterialIcon("cmd_alpha_p_box", '\ue900')
        @JvmField
        val cmd_alpha_p_circle_outline = CommunityMaterialIcon("cmd_alpha_p_circle_outline", '\ue900')
        @JvmField
        val cmd_alpha_p_circle = CommunityMaterialIcon("cmd_alpha_p_circle", '\ue900')
        @JvmField
        val cmd_alpha_p = CommunityMaterialIcon("cmd_alpha_p", '\ue900')
        @JvmField
        val cmd_alpha_q_box_outline = CommunityMaterialIcon("cmd_alpha_q_box_outline", '\ue900')
        @JvmField
        val cmd_alpha_q_box = CommunityMaterialIcon("cmd_alpha_q_box", '\ue900')
        @JvmField
        val cmd_alpha_q_circle_outline = CommunityMaterialIcon("cmd_alpha_q_circle_outline", '\ue900')
        @JvmField
        val cmd_alpha_q_circle = CommunityMaterialIcon("cmd_alpha_q_circle", '\ue900')
        @JvmField
        val cmd_alpha_q = CommunityMaterialIcon("cmd_alpha_q", '\ue900')
        @JvmField
        val cmd_alpha_r_box_outline = CommunityMaterialIcon("cmd_alpha_r_box_outline", '\ue900')
        @JvmField
        val cmd_alpha_r_box = CommunityMaterialIcon("cmd_alpha_r_box", '\ue900')
        @JvmField
        val cmd_alpha_r_circle_outline = CommunityMaterialIcon("cmd_alpha_r_circle_outline", '\ue900')
        @JvmField
        val cmd_alpha_r_circle = CommunityMaterialIcon("cmd_alpha_r_circle", '\ue900')
        @JvmField
        val cmd_alpha_r = CommunityMaterialIcon("cmd_alpha_r", '\ue900')
        @JvmField
        val cmd_alpha_s_box_outline = CommunityMaterialIcon("cmd_alpha_s_box_outline", '\ue900')
        @JvmField
        val cmd_alpha_s_box = CommunityMaterialIcon("cmd_alpha_s_box", '\ue900')
        @JvmField
        val cmd_alpha_s_circle_outline = CommunityMaterialIcon("cmd_alpha_s_circle_outline", '\ue900')
        @JvmField
        val cmd_alpha_s_circle = CommunityMaterialIcon("cmd_alpha_s_circle", '\ue900')
        @JvmField
        val cmd_alpha_s = CommunityMaterialIcon("cmd_alpha_s", '\ue900')
        @JvmField
        val cmd_alpha_t_box_outline = CommunityMaterialIcon("cmd_alpha_t_box_outline", '\ue900')
        @JvmField
        val cmd_alpha_t_box = CommunityMaterialIcon("cmd_alpha_t_box", '\ue900')
        @JvmField
        val cmd_alpha_t_circle_outline = CommunityMaterialIcon("cmd_alpha_t_circle_outline", '\ue900')
        @JvmField
        val cmd_alpha_t_circle = CommunityMaterialIcon("cmd_alpha_t_circle", '\ue900')
        @JvmField
        val cmd_alpha_t = CommunityMaterialIcon("cmd_alpha_t", '\ue900')
        @JvmField
        val cmd_alpha_u_box_outline = CommunityMaterialIcon("cmd_alpha_u_box_outline", '\ue900')
        @JvmField
        val cmd_alpha_u_box = CommunityMaterialIcon("cmd_alpha_u_box", '\ue900')
        @JvmField
        val cmd_alpha_u_circle_outline = CommunityMaterialIcon("cmd_alpha_u_circle_outline", '\ue900')
        @JvmField
        val cmd_alpha_u_circle = CommunityMaterialIcon("cmd_alpha_u_circle", '\ue900')
        @JvmField
        val cmd_alpha_u = CommunityMaterialIcon("cmd_alpha_u", '\ue900')
        @JvmField
        val cmd_alpha_v_box_outline = CommunityMaterialIcon("cmd_alpha_v_box_outline", '\ue900')
        @JvmField
        val cmd_alpha_v_box = CommunityMaterialIcon("cmd_alpha_v_box", '\ue900')
        @JvmField
        val cmd_alpha_v_circle_outline = CommunityMaterialIcon("cmd_alpha_v_circle_outline", '\ue900')
        @JvmField
        val cmd_alpha_v_circle = CommunityMaterialIcon("cmd_alpha_v_circle", '\ue900')
        @JvmField
        val cmd_alpha_v = CommunityMaterialIcon("cmd_alpha_v", '\ue900')
        @JvmField
        val cmd_alpha_w_box_outline = CommunityMaterialIcon("cmd_alpha_w_box_outline", '\ue900')
        @JvmField
        val cmd_alpha_w_box = CommunityMaterialIcon("cmd_alpha_w_box", '\ue900')
        @JvmField
        val cmd_alpha_w_circle_outline = CommunityMaterialIcon("cmd_alpha_w_circle_outline", '\ue900')
        @JvmField
        val cmd_alpha_w_circle = CommunityMaterialIcon("cmd_alpha_w_circle", '\ue900')
        @JvmField
        val cmd_alpha_w = CommunityMaterialIcon("cmd_alpha_w", '\ue900')
        @JvmField
        val cmd_alpha_x_box_outline = CommunityMaterialIcon("cmd_alpha_x_box_outline", '\ue900')
        @JvmField
        val cmd_alpha_x_box = CommunityMaterialIcon("cmd_alpha_x_box", '\ue900')
        @JvmField
        val cmd_alpha_x_circle_outline = CommunityMaterialIcon("cmd_alpha_x_circle_outline", '\ue900')
        @JvmField
        val cmd_alpha_x_circle = CommunityMaterialIcon("cmd_alpha_x_circle", '\ue900')
        @JvmField
        val cmd_alpha_x = CommunityMaterialIcon("cmd_alpha_x", '\ue900')
        @JvmField
        val cmd_alpha_y_box_outline = CommunityMaterialIcon("cmd_alpha_y_box_outline", '\ue900')
        @JvmField
        val cmd_alpha_y_box = CommunityMaterialIcon("cmd_alpha_y_box", '\ue900')
        @JvmField
        val cmd_alpha_y_circle_outline = CommunityMaterialIcon("cmd_alpha_y_circle_outline", '\ue900')
        @JvmField
        val cmd_alpha_y_circle = CommunityMaterialIcon("cmd_alpha_y_circle", '\ue900')
        @JvmField
        val cmd_alpha_y = CommunityMaterialIcon("cmd_alpha_y", '\ue900')
        @JvmField
        val cmd_alpha_z_box_outline = CommunityMaterialIcon("cmd_alpha_z_box_outline", '\ue900')
        @JvmField
        val cmd_alpha_z_box = CommunityMaterialIcon("cmd_alpha_z_box", '\ue900')
        @JvmField
        val cmd_alpha_z_circle_outline = CommunityMaterialIcon("cmd_alpha_z_circle_outline", '\ue900')
        @JvmField
        val cmd_alpha_z_circle = CommunityMaterialIcon("cmd_alpha_z_circle", '\ue900')
        @JvmField
        val cmd_alpha_z = CommunityMaterialIcon("cmd_alpha_z", '\ue900')
        @JvmField
        val cmd_alpha = CommunityMaterialIcon("cmd_alpha", '\ue900')
        @JvmField
        val cmd_alphabetical_off = CommunityMaterialIcon("cmd_alphabetical_off", '\ue900')
        @JvmField
        val cmd_alphabetical_variant_off = CommunityMaterialIcon("cmd_alphabetical_variant_off", '\ue900')
        @JvmField
        val cmd_alphabetical_variant = CommunityMaterialIcon("cmd_alphabetical_variant", '\ue900')
        @JvmField
        val cmd_alphabetical = CommunityMaterialIcon("cmd_alphabetical", '\ue900')
        @JvmField
        val cmd_altimeter = CommunityMaterialIcon("cmd_altimeter", '\ue900')
        @JvmField
        val cmd_amazon_alexa = CommunityMaterialIcon("cmd_amazon_alexa", '\ue900')
        @JvmField
        val cmd_amazon_drive = CommunityMaterialIcon("cmd_amazon_drive", '\ue900')
        @JvmField
        val cmd_amazon = CommunityMaterialIcon("cmd_amazon", '\ue900')
        @JvmField
        val cmd_ambulance = CommunityMaterialIcon("cmd_ambulance", '\ue900')
        @JvmField
        val cmd_ammunition = CommunityMaterialIcon("cmd_ammunition", '\ue900')
        @JvmField
        val cmd_ampersand = CommunityMaterialIcon("cmd_ampersand", '\ue900')
        @JvmField
        val cmd_amplifier_off = CommunityMaterialIcon("cmd_amplifier_off", '\ue900')
        @JvmField
        val cmd_amplifier = CommunityMaterialIcon("cmd_amplifier", '\ue900')
        @JvmField
        val cmd_anchor = CommunityMaterialIcon("cmd_anchor", '\ue900')
        @JvmField
        val cmd_android_auto = CommunityMaterialIcon("cmd_android_auto", '\ue900')
        @JvmField
        val cmd_android_debug_bridge = CommunityMaterialIcon("cmd_android_debug_bridge", '\ue900')
        @JvmField
        val cmd_android_head = CommunityMaterialIcon("cmd_android_head", '\ue900')
        @JvmField
        val cmd_android_messages = CommunityMaterialIcon("cmd_android_messages", '\ue900')
        @JvmField
        val cmd_android_studio = CommunityMaterialIcon("cmd_android_studio", '\ue900')
        @JvmField
        val cmd_android = CommunityMaterialIcon("cmd_android", '\ue900')
        @JvmField
        val cmd_angle_acute = CommunityMaterialIcon("cmd_angle_acute", '\ue900')
        @JvmField
        val cmd_angle_obtuse = CommunityMaterialIcon("cmd_angle_obtuse", '\ue900')
        @JvmField
        val cmd_angle_right = CommunityMaterialIcon("cmd_angle_right", '\ue900')
        @JvmField
        val cmd_angular = CommunityMaterialIcon("cmd_angular", '\ue900')
        @JvmField
        val cmd_angularjs = CommunityMaterialIcon("cmd_angularjs", '\ue900')
        @JvmField
        val cmd_animation_outline = CommunityMaterialIcon("cmd_animation_outline", '\ue900')
        @JvmField
        val cmd_animation_play_outline = CommunityMaterialIcon("cmd_animation_play_outline", '\ue900')
        @JvmField
        val cmd_animation_play = CommunityMaterialIcon("cmd_animation_play", '\ue900')
        @JvmField
        val cmd_animation = CommunityMaterialIcon("cmd_animation", '\ue900')
        @JvmField
        val cmd_ansible = CommunityMaterialIcon("cmd_ansible", '\ue900')
        @JvmField
        val cmd_antenna = CommunityMaterialIcon("cmd_antenna", '\ue900')
        @JvmField
        val cmd_anvil = CommunityMaterialIcon("cmd_anvil", '\ue900')
        @JvmField
        val cmd_apache_kafka = CommunityMaterialIcon("cmd_apache_kafka", '\ue900')
        @JvmField
        val cmd_api_off = CommunityMaterialIcon("cmd_api_off", '\ue900')
        @JvmField
        val cmd_api = CommunityMaterialIcon("cmd_api", '\ue900')
        @JvmField
        val cmd_apple_finder = CommunityMaterialIcon("cmd_apple_finder", '\ue900')
        @JvmField
        val cmd_apple_icloud = CommunityMaterialIcon("cmd_apple_icloud", '\ue900')
        @JvmField
        val cmd_apple_ios = CommunityMaterialIcon("cmd_apple_ios", '\ue900')
        @JvmField
        val cmd_apple_keyboard_caps = CommunityMaterialIcon("cmd_apple_keyboard_caps", '\ue900')
        @JvmField
        val cmd_apple_keyboard_command = CommunityMaterialIcon("cmd_apple_keyboard_command", '\ue900')
        @JvmField
        val cmd_apple_keyboard_control = CommunityMaterialIcon("cmd_apple_keyboard_control", '\ue900')
        @JvmField
        val cmd_apple_keyboard_option = CommunityMaterialIcon("cmd_apple_keyboard_option", '\ue900')
        @JvmField
        val cmd_apple_keyboard_shift = CommunityMaterialIcon("cmd_apple_keyboard_shift", '\ue900')
        @JvmField
        val cmd_apple_safari = CommunityMaterialIcon("cmd_apple_safari", '\ue900')
        @JvmField
        val cmd_apple = CommunityMaterialIcon("cmd_apple", '\ue900')
        @JvmField
        val cmd_application_export = CommunityMaterialIcon("cmd_application_export", '\ue900')
        @JvmField
        val cmd_application_import = CommunityMaterialIcon("cmd_application_import", '\ue900')
        @JvmField
        val cmd_application = CommunityMaterialIcon("cmd_application", '\ue900')
        @JvmField
        val cmd_approximately_equal_box = CommunityMaterialIcon("cmd_approximately_equal_box", '\ue900')
        @JvmField
        val cmd_approximately_equal = CommunityMaterialIcon("cmd_approximately_equal", '\ue900')
        @JvmField
        val cmd_apps_box = CommunityMaterialIcon("cmd_apps_box", '\ue900')
        @JvmField
        val cmd_apps = CommunityMaterialIcon("cmd_apps", '\ue900')
        @JvmField
        val cmd_arch = CommunityMaterialIcon("cmd_arch", '\ue900')
        @JvmField
        val cmd_archive_arrow_down_outline = CommunityMaterialIcon("cmd_archive_arrow_down_outline", '\ue900')
        @JvmField
        val cmd_archive_arrow_down = CommunityMaterialIcon("cmd_archive_arrow_down", '\ue900')
        @JvmField
        val cmd_archive_arrow_up_outline = CommunityMaterialIcon("cmd_archive_arrow_up_outline", '\ue900')
        @JvmField
        val cmd_archive_arrow_up = CommunityMaterialIcon("cmd_archive_arrow_up", '\ue900')
        @JvmField
        val cmd_archive_outline = CommunityMaterialIcon("cmd_archive_outline", '\ue900')
        @JvmField
        val cmd_archive = CommunityMaterialIcon("cmd_archive", '\ue900')
        @JvmField
        val cmd_arm_flex_outline = CommunityMaterialIcon("cmd_arm_flex_outline", '\ue900')
        @JvmField
        val cmd_arm_flex = CommunityMaterialIcon("cmd_arm_flex", '\ue900')
        @JvmField
        val cmd_arrange_bring_forward = CommunityMaterialIcon("cmd_arrange_bring_forward", '\ue900')
        @JvmField
        val cmd_arrange_bring_to_front = CommunityMaterialIcon("cmd_arrange_bring_to_front", '\ue900')
        @JvmField
        val cmd_arrange_send_backward = CommunityMaterialIcon("cmd_arrange_send_backward", '\ue900')
        @JvmField
        val cmd_arrange_send_to_back = CommunityMaterialIcon("cmd_arrange_send_to_back", '\ue900')
        @JvmField
        val cmd_arrow_all = CommunityMaterialIcon("cmd_arrow_all", '\ue900')
        @JvmField
        val cmd_arrow_bottom_left_bold_outline = CommunityMaterialIcon("cmd_arrow_bottom_left_bold_outline", '\ue900')
        @JvmField
        val cmd_arrow_bottom_left_thick = CommunityMaterialIcon("cmd_arrow_bottom_left_thick", '\ue900')
        @JvmField
        val cmd_arrow_bottom_left = CommunityMaterialIcon("cmd_arrow_bottom_left", '\ue900')
        @JvmField
        val cmd_arrow_bottom_right_bold_outline = CommunityMaterialIcon("cmd_arrow_bottom_right_bold_outline", '\ue900')
        @JvmField
        val cmd_arrow_bottom_right_thick = CommunityMaterialIcon("cmd_arrow_bottom_right_thick", '\ue900')
        @JvmField
        val cmd_arrow_bottom_right = CommunityMaterialIcon("cmd_arrow_bottom_right", '\ue900')
        @JvmField
        val cmd_arrow_collapse_all = CommunityMaterialIcon("cmd_arrow_collapse_all", '\ue900')
        @JvmField
        val cmd_arrow_collapse_down = CommunityMaterialIcon("cmd_arrow_collapse_down", '\ue900')
        @JvmField
        val cmd_arrow_collapse_horizontal = CommunityMaterialIcon("cmd_arrow_collapse_horizontal", '\ue900')
        @JvmField
        val cmd_arrow_collapse_left = CommunityMaterialIcon("cmd_arrow_collapse_left", '\ue900')
        @JvmField
        val cmd_arrow_collapse_right = CommunityMaterialIcon("cmd_arrow_collapse_right", '\ue900')
        @JvmField
        val cmd_arrow_collapse_up = CommunityMaterialIcon("cmd_arrow_collapse_up", '\ue900')
        @JvmField
        val cmd_arrow_collapse_vertical = CommunityMaterialIcon("cmd_arrow_collapse_vertical", '\ue900')
        @JvmField
        val cmd_arrow_collapse = CommunityMaterialIcon("cmd_arrow_collapse", '\ue900')
        @JvmField
        val cmd_arrow_decision_auto_outline = CommunityMaterialIcon("cmd_arrow_decision_auto_outline", '\ue900')
        @JvmField
        val cmd_arrow_decision_auto = CommunityMaterialIcon("cmd_arrow_decision_auto", '\ue900')
        @JvmField
        val cmd_arrow_decision_outline = CommunityMaterialIcon("cmd_arrow_decision_outline", '\ue900')
        @JvmField
        val cmd_arrow_decision = CommunityMaterialIcon("cmd_arrow_decision", '\ue900')
        @JvmField
        val cmd_arrow_down_bold_box_outline = CommunityMaterialIcon("cmd_arrow_down_bold_box_outline", '\ue900')
        @JvmField
        val cmd_arrow_down_bold_box = CommunityMaterialIcon("cmd_arrow_down_bold_box", '\ue900')
        @JvmField
        val cmd_arrow_down_bold_circle_outline = CommunityMaterialIcon("cmd_arrow_down_bold_circle_outline", '\ue900')
        @JvmField
        val cmd_arrow_down_bold_circle = CommunityMaterialIcon("cmd_arrow_down_bold_circle", '\ue900')
        @JvmField
        val cmd_arrow_down_bold_hexagon_outline = CommunityMaterialIcon("cmd_arrow_down_bold_hexagon_outline", '\ue900')
        @JvmField
        val cmd_arrow_down_bold_outline = CommunityMaterialIcon("cmd_arrow_down_bold_outline", '\ue900')
        @JvmField
        val cmd_arrow_down_bold = CommunityMaterialIcon("cmd_arrow_down_bold", '\ue900')
        @JvmField
        val cmd_arrow_down_box = CommunityMaterialIcon("cmd_arrow_down_box", '\ue900')
        @JvmField
        val cmd_arrow_down_circle_outline = CommunityMaterialIcon("cmd_arrow_down_circle_outline", '\ue900')
        @JvmField
        val cmd_arrow_down_circle = CommunityMaterialIcon("cmd_arrow_down_circle", '\ue900')
        @JvmField
        val cmd_arrow_down_drop_circle_outline = CommunityMaterialIcon("cmd_arrow_down_drop_circle_outline", '\ue900')
        @JvmField
        val cmd_arrow_down_drop_circle = CommunityMaterialIcon("cmd_arrow_down_drop_circle", '\ue900')
        @JvmField
        val cmd_arrow_down_thick = CommunityMaterialIcon("cmd_arrow_down_thick", '\ue900')
        @JvmField
        val cmd_arrow_down = CommunityMaterialIcon("cmd_arrow_down", '\ue900')
        @JvmField
        val cmd_arrow_expand_all = CommunityMaterialIcon("cmd_arrow_expand_all", '\ue900')
        @JvmField
        val cmd_arrow_expand_down = CommunityMaterialIcon("cmd_arrow_expand_down", '\ue900')
        @JvmField
        val cmd_arrow_expand_horizontal = CommunityMaterialIcon("cmd_arrow_expand_horizontal", '\ue900')
        @JvmField
        val cmd_arrow_expand_left = CommunityMaterialIcon("cmd_arrow_expand_left", '\ue900')
        @JvmField
        val cmd_arrow_expand_right = CommunityMaterialIcon("cmd_arrow_expand_right", '\ue900')
        @JvmField
        val cmd_arrow_expand_up = CommunityMaterialIcon("cmd_arrow_expand_up", '\ue900')
        @JvmField
        val cmd_arrow_expand_vertical = CommunityMaterialIcon("cmd_arrow_expand_vertical", '\ue900')
        @JvmField
        val cmd_arrow_expand = CommunityMaterialIcon("cmd_arrow_expand", '\ue900')
        @JvmField
        val cmd_arrow_horizontal_lock = CommunityMaterialIcon("cmd_arrow_horizontal_lock", '\ue900')
        @JvmField
        val cmd_arrow_left_bold_box_outline = CommunityMaterialIcon("cmd_arrow_left_bold_box_outline", '\ue900')
        @JvmField
        val cmd_arrow_left_bold_box = CommunityMaterialIcon("cmd_arrow_left_bold_box", '\ue900')
        @JvmField
        val cmd_arrow_left_bold_circle_outline = CommunityMaterialIcon("cmd_arrow_left_bold_circle_outline", '\ue900')
        @JvmField
        val cmd_arrow_left_bold_circle = CommunityMaterialIcon("cmd_arrow_left_bold_circle", '\ue900')
        @JvmField
        val cmd_arrow_left_bold_hexagon_outline = CommunityMaterialIcon("cmd_arrow_left_bold_hexagon_outline", '\ue900')
        @JvmField
        val cmd_arrow_left_bold_outline = CommunityMaterialIcon("cmd_arrow_left_bold_outline", '\ue900')
        @JvmField
        val cmd_arrow_left_bold = CommunityMaterialIcon("cmd_arrow_left_bold", '\ue900')
        @JvmField
        val cmd_arrow_left_box = CommunityMaterialIcon("cmd_arrow_left_box", '\ue900')
        @JvmField
        val cmd_arrow_left_circle_outline = CommunityMaterialIcon("cmd_arrow_left_circle_outline", '\ue900')
        @JvmField
        val cmd_arrow_left_circle = CommunityMaterialIcon("cmd_arrow_left_circle", '\ue900')
        @JvmField
        val cmd_arrow_left_drop_circle_outline = CommunityMaterialIcon("cmd_arrow_left_drop_circle_outline", '\ue900')
        @JvmField
        val cmd_arrow_left_drop_circle = CommunityMaterialIcon("cmd_arrow_left_drop_circle", '\ue900')
        @JvmField
        val cmd_arrow_left_right_bold_outline = CommunityMaterialIcon("cmd_arrow_left_right_bold_outline", '\ue900')
        @JvmField
        val cmd_arrow_left_right_bold = CommunityMaterialIcon("cmd_arrow_left_right_bold", '\ue900')
        @JvmField
        val cmd_arrow_left_right = CommunityMaterialIcon("cmd_arrow_left_right", '\ue900')
        @JvmField
        val cmd_arrow_left_thick = CommunityMaterialIcon("cmd_arrow_left_thick", '\ue900')
        @JvmField
        val cmd_arrow_left = CommunityMaterialIcon("cmd_arrow_left", '\ue900')
        @JvmField
        val cmd_arrow_right_bold_box_outline = CommunityMaterialIcon("cmd_arrow_right_bold_box_outline", '\ue900')
        @JvmField
        val cmd_arrow_right_bold_box = CommunityMaterialIcon("cmd_arrow_right_bold_box", '\ue900')
        @JvmField
        val cmd_arrow_right_bold_circle_outline = CommunityMaterialIcon("cmd_arrow_right_bold_circle_outline", '\ue900')
        @JvmField
        val cmd_arrow_right_bold_circle = CommunityMaterialIcon("cmd_arrow_right_bold_circle", '\ue900')
        @JvmField
        val cmd_arrow_right_bold_hexagon_outline = CommunityMaterialIcon("cmd_arrow_right_bold_hexagon_outline", '\ue900')
        @JvmField
        val cmd_arrow_right_bold_outline = CommunityMaterialIcon("cmd_arrow_right_bold_outline", '\ue900')
        @JvmField
        val cmd_arrow_right_bold = CommunityMaterialIcon("cmd_arrow_right_bold", '\ue900')
        @JvmField
        val cmd_arrow_right_box = CommunityMaterialIcon("cmd_arrow_right_box", '\ue900')
        @JvmField
        val cmd_arrow_right_circle_outline = CommunityMaterialIcon("cmd_arrow_right_circle_outline", '\ue900')
        @JvmField
        val cmd_arrow_right_circle = CommunityMaterialIcon("cmd_arrow_right_circle", '\ue900')
        @JvmField
        val cmd_arrow_right_drop_circle_outline = CommunityMaterialIcon("cmd_arrow_right_drop_circle_outline", '\ue900')
        @JvmField
        val cmd_arrow_right_drop_circle = CommunityMaterialIcon("cmd_arrow_right_drop_circle", '\ue900')
        @JvmField
        val cmd_arrow_right_thick = CommunityMaterialIcon("cmd_arrow_right_thick", '\ue900')
        @JvmField
        val cmd_arrow_right = CommunityMaterialIcon("cmd_arrow_right", '\ue900')
        @JvmField
        val cmd_arrow_split_horizontal = CommunityMaterialIcon("cmd_arrow_split_horizontal", '\ue900')
        @JvmField
        val cmd_arrow_split_vertical = CommunityMaterialIcon("cmd_arrow_split_vertical", '\ue900')
        @JvmField
        val cmd_arrow_top_left_bold_outline = CommunityMaterialIcon("cmd_arrow_top_left_bold_outline", '\ue900')
        @JvmField
        val cmd_arrow_top_left_bottom_right_bold = CommunityMaterialIcon("cmd_arrow_top_left_bottom_right_bold", '\ue900')
        @JvmField
        val cmd_arrow_top_left_bottom_right = CommunityMaterialIcon("cmd_arrow_top_left_bottom_right", '\ue900')
        @JvmField
        val cmd_arrow_top_left_thick = CommunityMaterialIcon("cmd_arrow_top_left_thick", '\ue900')
        @JvmField
        val cmd_arrow_top_left = CommunityMaterialIcon("cmd_arrow_top_left", '\ue900')
        @JvmField
        val cmd_arrow_top_right_bold_outline = CommunityMaterialIcon("cmd_arrow_top_right_bold_outline", '\ue900')
        @JvmField
        val cmd_arrow_top_right_bottom_left_bold = CommunityMaterialIcon("cmd_arrow_top_right_bottom_left_bold", '\ue900')
        @JvmField
        val cmd_arrow_top_right_bottom_left = CommunityMaterialIcon("cmd_arrow_top_right_bottom_left", '\ue900')
        @JvmField
        val cmd_arrow_top_right_thick = CommunityMaterialIcon("cmd_arrow_top_right_thick", '\ue900')
        @JvmField
        val cmd_arrow_top_right = CommunityMaterialIcon("cmd_arrow_top_right", '\ue900')
        @JvmField
        val cmd_arrow_up_bold_box_outline = CommunityMaterialIcon("cmd_arrow_up_bold_box_outline", '\ue900')
        @JvmField
        val cmd_arrow_up_bold_box = CommunityMaterialIcon("cmd_arrow_up_bold_box", '\ue900')
        @JvmField
        val cmd_arrow_up_bold_circle_outline = CommunityMaterialIcon("cmd_arrow_up_bold_circle_outline", '\ue900')
        @JvmField
        val cmd_arrow_up_bold_circle = CommunityMaterialIcon("cmd_arrow_up_bold_circle", '\ue900')
        @JvmField
        val cmd_arrow_up_bold_hexagon_outline = CommunityMaterialIcon("cmd_arrow_up_bold_hexagon_outline", '\ue900')
        @JvmField
        val cmd_arrow_up_bold_outline = CommunityMaterialIcon("cmd_arrow_up_bold_outline", '\ue900')
        @JvmField
        val cmd_arrow_up_bold = CommunityMaterialIcon("cmd_arrow_up_bold", '\ue900')
        @JvmField
        val cmd_arrow_up_box = CommunityMaterialIcon("cmd_arrow_up_box", '\ue900')
        @JvmField
        val cmd_arrow_up_circle_outline = CommunityMaterialIcon("cmd_arrow_up_circle_outline", '\ue900')
        @JvmField
        val cmd_arrow_up_circle = CommunityMaterialIcon("cmd_arrow_up_circle", '\ue900')
        @JvmField
        val cmd_arrow_up_down_bold_outline = CommunityMaterialIcon("cmd_arrow_up_down_bold_outline", '\ue900')
        @JvmField
        val cmd_arrow_up_down_bold = CommunityMaterialIcon("cmd_arrow_up_down_bold", '\ue900')
        @JvmField
        val cmd_arrow_up_down = CommunityMaterialIcon("cmd_arrow_up_down", '\ue900')
        @JvmField
        val cmd_arrow_up_drop_circle_outline = CommunityMaterialIcon("cmd_arrow_up_drop_circle_outline", '\ue900')
        @JvmField
        val cmd_arrow_up_drop_circle = CommunityMaterialIcon("cmd_arrow_up_drop_circle", '\ue900')
        @JvmField
        val cmd_arrow_up_thick = CommunityMaterialIcon("cmd_arrow_up_thick", '\ue900')
        @JvmField
        val cmd_arrow_up = CommunityMaterialIcon("cmd_arrow_up", '\ue900')
        @JvmField
        val cmd_arrow_vertical_lock = CommunityMaterialIcon("cmd_arrow_vertical_lock", '\ue900')
        @JvmField
        val cmd_artist_outline = CommunityMaterialIcon("cmd_artist_outline", '\ue900')
        @JvmField
        val cmd_artist = CommunityMaterialIcon("cmd_artist", '\ue900')
        @JvmField
        val cmd_artstation = CommunityMaterialIcon("cmd_artstation", '\ue900')
        @JvmField
        val cmd_aspect_ratio = CommunityMaterialIcon("cmd_aspect_ratio", '\ue900')
        @JvmField
        val cmd_assistant = CommunityMaterialIcon("cmd_assistant", '\ue900')
        @JvmField
        val cmd_asterisk = CommunityMaterialIcon("cmd_asterisk", '\ue900')
        @JvmField
        val cmd_at = CommunityMaterialIcon("cmd_at", '\ue900')
        @JvmField
        val cmd_atlassian = CommunityMaterialIcon("cmd_atlassian", '\ue900')
        @JvmField
        val cmd_atm = CommunityMaterialIcon("cmd_atm", '\ue900')
        @JvmField
        val cmd_atom_variant = CommunityMaterialIcon("cmd_atom_variant", '\ue900')
        @JvmField
        val cmd_atom = CommunityMaterialIcon("cmd_atom", '\ue900')
        @JvmField
        val cmd_attachment = CommunityMaterialIcon("cmd_attachment", '\ue900')
        @JvmField
        val cmd_audio_video_off = CommunityMaterialIcon("cmd_audio_video_off", '\ue900')
        @JvmField
        val cmd_audio_video = CommunityMaterialIcon("cmd_audio_video", '\ue900')
        @JvmField
        val cmd_audiobook = CommunityMaterialIcon("cmd_audiobook", '\ue900')
        @JvmField
        val cmd_augmented_reality = CommunityMaterialIcon("cmd_augmented_reality", '\ue900')
        @JvmField
        val cmd_auto_fix = CommunityMaterialIcon("cmd_auto_fix", '\ue900')
        @JvmField
        val cmd_auto_upload = CommunityMaterialIcon("cmd_auto_upload", '\ue900')
        @JvmField
        val cmd_autorenew = CommunityMaterialIcon("cmd_autorenew", '\ue900')
        @JvmField
        val cmd_av_timer = CommunityMaterialIcon("cmd_av_timer", '\ue900')
        @JvmField
        val cmd_aws = CommunityMaterialIcon("cmd_aws", '\ue900')
        @JvmField
        val cmd_axe = CommunityMaterialIcon("cmd_axe", '\ue900')
        @JvmField
        val cmd_axis_arrow_lock = CommunityMaterialIcon("cmd_axis_arrow_lock", '\ue900')
        @JvmField
        val cmd_axis_arrow = CommunityMaterialIcon("cmd_axis_arrow", '\ue900')
        @JvmField
        val cmd_axis_lock = CommunityMaterialIcon("cmd_axis_lock", '\ue900')
        @JvmField
        val cmd_axis_x_arrow_lock = CommunityMaterialIcon("cmd_axis_x_arrow_lock", '\ue900')
        @JvmField
        val cmd_axis_x_arrow = CommunityMaterialIcon("cmd_axis_x_arrow", '\ue900')
        @JvmField
        val cmd_axis_x_rotate_clockwise = CommunityMaterialIcon("cmd_axis_x_rotate_clockwise", '\ue900')
        @JvmField
        val cmd_axis_x_rotate_counterclockwise = CommunityMaterialIcon("cmd_axis_x_rotate_counterclockwise", '\ue900')
        @JvmField
        val cmd_axis_x_y_arrow_lock = CommunityMaterialIcon("cmd_axis_x_y_arrow_lock", '\ue900')
        @JvmField
        val cmd_axis_y_arrow_lock = CommunityMaterialIcon("cmd_axis_y_arrow_lock", '\ue900')
        @JvmField
        val cmd_axis_y_arrow = CommunityMaterialIcon("cmd_axis_y_arrow", '\ue900')
        @JvmField
        val cmd_axis_y_rotate_clockwise = CommunityMaterialIcon("cmd_axis_y_rotate_clockwise", '\ue900')
        @JvmField
        val cmd_axis_y_rotate_counterclockwise = CommunityMaterialIcon("cmd_axis_y_rotate_counterclockwise", '\ue900')
        @JvmField
        val cmd_axis_z_arrow_lock = CommunityMaterialIcon("cmd_axis_z_arrow_lock", '\ue900')
        @JvmField
        val cmd_axis_z_arrow = CommunityMaterialIcon("cmd_axis_z_arrow", '\ue900')
        @JvmField
        val cmd_axis_z_rotate_clockwise = CommunityMaterialIcon("cmd_axis_z_rotate_clockwise", '\ue900')
        @JvmField
        val cmd_axis_z_rotate_counterclockwise = CommunityMaterialIcon("cmd_axis_z_rotate_counterclockwise", '\ue900')
        @JvmField
        val cmd_axis = CommunityMaterialIcon("cmd_axis", '\ue900')
        @JvmField
        val cmd_azure_devops = CommunityMaterialIcon("cmd_azure_devops", '\ue900')
        @JvmField
        val cmd_azure = CommunityMaterialIcon("cmd_azure", '\ue900')
        @JvmField
        val cmd_babel = CommunityMaterialIcon("cmd_babel", '\ue900')
        @JvmField
        val cmd_baby_bottle_outline = CommunityMaterialIcon("cmd_baby_bottle_outline", '\ue900')
        @JvmField
        val cmd_baby_bottle = CommunityMaterialIcon("cmd_baby_bottle", '\ue900')
        @JvmField
        val cmd_baby_carriage_off = CommunityMaterialIcon("cmd_baby_carriage_off", '\ue900')
        @JvmField
        val cmd_baby_carriage = CommunityMaterialIcon("cmd_baby_carriage", '\ue900')
        @JvmField
        val cmd_baby_face_outline = CommunityMaterialIcon("cmd_baby_face_outline", '\ue900')
        @JvmField
        val cmd_baby_face = CommunityMaterialIcon("cmd_baby_face", '\ue900')
        @JvmField
        val cmd_baby = CommunityMaterialIcon("cmd_baby", '\ue900')
        @JvmField
        val cmd_backburger = CommunityMaterialIcon("cmd_backburger", '\ue900')
        @JvmField
        val cmd_backspace_outline = CommunityMaterialIcon("cmd_backspace_outline", '\ue900')
        @JvmField
        val cmd_backspace_reverse_outline = CommunityMaterialIcon("cmd_backspace_reverse_outline", '\ue900')
        @JvmField
        val cmd_backspace_reverse = CommunityMaterialIcon("cmd_backspace_reverse", '\ue900')
        @JvmField
        val cmd_backspace = CommunityMaterialIcon("cmd_backspace", '\ue900')
        @JvmField
        val cmd_backup_restore = CommunityMaterialIcon("cmd_backup_restore", '\ue900')
        @JvmField
        val cmd_bacteria_outline = CommunityMaterialIcon("cmd_bacteria_outline", '\ue900')
        @JvmField
        val cmd_bacteria = CommunityMaterialIcon("cmd_bacteria", '\ue900')
        @JvmField
        val cmd_badminton = CommunityMaterialIcon("cmd_badminton", '\ue900')
        @JvmField
        val cmd_bag_carry_on_check = CommunityMaterialIcon("cmd_bag_carry_on_check", '\ue900')
        @JvmField
        val cmd_bag_carry_on_off = CommunityMaterialIcon("cmd_bag_carry_on_off", '\ue900')
        @JvmField
        val cmd_bag_carry_on = CommunityMaterialIcon("cmd_bag_carry_on", '\ue900')
        @JvmField
        val cmd_bag_checked = CommunityMaterialIcon("cmd_bag_checked", '\ue900')
        @JvmField
        val cmd_bag_personal_off_outline = CommunityMaterialIcon("cmd_bag_personal_off_outline", '\ue900')
        @JvmField
        val cmd_bag_personal_off = CommunityMaterialIcon("cmd_bag_personal_off", '\ue900')
        @JvmField
        val cmd_bag_personal_outline = CommunityMaterialIcon("cmd_bag_personal_outline", '\ue900')
        @JvmField
        val cmd_bag_personal = CommunityMaterialIcon("cmd_bag_personal", '\ue900')
        @JvmField
        val cmd_baguette = CommunityMaterialIcon("cmd_baguette", '\ue900')
        @JvmField
        val cmd_balloon = CommunityMaterialIcon("cmd_balloon", '\ue900')
        @JvmField
        val cmd_ballot_outline = CommunityMaterialIcon("cmd_ballot_outline", '\ue900')
        @JvmField
        val cmd_ballot_recount_outline = CommunityMaterialIcon("cmd_ballot_recount_outline", '\ue900')
        @JvmField
        val cmd_ballot_recount = CommunityMaterialIcon("cmd_ballot_recount", '\ue900')
        @JvmField
        val cmd_ballot = CommunityMaterialIcon("cmd_ballot", '\ue900')
        @JvmField
        val cmd_bandage = CommunityMaterialIcon("cmd_bandage", '\ue900')
        @JvmField
        val cmd_bandcamp = CommunityMaterialIcon("cmd_bandcamp", '\ue900')
        @JvmField
        val cmd_bank_minus = CommunityMaterialIcon("cmd_bank_minus", '\ue900')
        @JvmField
        val cmd_bank_outline = CommunityMaterialIcon("cmd_bank_outline", '\ue900')
        @JvmField
        val cmd_bank_plus = CommunityMaterialIcon("cmd_bank_plus", '\ue900')
        @JvmField
        val cmd_bank_remove = CommunityMaterialIcon("cmd_bank_remove", '\ue900')
        @JvmField
        val cmd_bank_transfer_in = CommunityMaterialIcon("cmd_bank_transfer_in", '\ue900')
        @JvmField
        val cmd_bank_transfer_out = CommunityMaterialIcon("cmd_bank_transfer_out", '\ue900')
        @JvmField
        val cmd_bank_transfer = CommunityMaterialIcon("cmd_bank_transfer", '\ue900')
        @JvmField
        val cmd_bank = CommunityMaterialIcon("cmd_bank", '\ue900')
        @JvmField
        val cmd_barcode_off = CommunityMaterialIcon("cmd_barcode_off", '\ue900')
        @JvmField
        val cmd_barcode_scan = CommunityMaterialIcon("cmd_barcode_scan", '\ue900')
        @JvmField
        val cmd_barcode = CommunityMaterialIcon("cmd_barcode", '\ue900')
        @JvmField
        val cmd_barley_off = CommunityMaterialIcon("cmd_barley_off", '\ue900')
        @JvmField
        val cmd_barley = CommunityMaterialIcon("cmd_barley", '\ue900')
        @JvmField
        val cmd_barn = CommunityMaterialIcon("cmd_barn", '\ue900')
        @JvmField
        val cmd_barrel = CommunityMaterialIcon("cmd_barrel", '\ue900')
        @JvmField
        val cmd_baseball_bat = CommunityMaterialIcon("cmd_baseball_bat", '\ue900')
        @JvmField
        val cmd_baseball = CommunityMaterialIcon("cmd_baseball", '\ue900')
        @JvmField
        val cmd_basecamp = CommunityMaterialIcon("cmd_basecamp", '\ue900')
        @JvmField
        val cmd_bash = CommunityMaterialIcon("cmd_bash", '\ue900')
        @JvmField
        val cmd_basket_fill = CommunityMaterialIcon("cmd_basket_fill", '\ue900')
        @JvmField
        val cmd_basket_outline = CommunityMaterialIcon("cmd_basket_outline", '\ue900')
        @JvmField
        val cmd_basket_unfill = CommunityMaterialIcon("cmd_basket_unfill", '\ue900')
        @JvmField
        val cmd_basket = CommunityMaterialIcon("cmd_basket", '\ue900')
        @JvmField
        val cmd_basketball_hoop_outline = CommunityMaterialIcon("cmd_basketball_hoop_outline", '\ue900')
        @JvmField
        val cmd_basketball_hoop = CommunityMaterialIcon("cmd_basketball_hoop", '\ue900')
        @JvmField
        val cmd_basketball = CommunityMaterialIcon("cmd_basketball", '\ue900')
        @JvmField
        val cmd_bat = CommunityMaterialIcon("cmd_bat", '\ue900')
        @JvmField
        val cmd_battery_10_bluetooth = CommunityMaterialIcon("cmd_battery_10_bluetooth", '\ue900')
        @JvmField
        val cmd_battery_10 = CommunityMaterialIcon("cmd_battery_10", '\ue900')
        @JvmField
        val cmd_battery_20_bluetooth = CommunityMaterialIcon("cmd_battery_20_bluetooth", '\ue900')
        @JvmField
        val cmd_battery_20 = CommunityMaterialIcon("cmd_battery_20", '\ue900')
        @JvmField
        val cmd_battery_30_bluetooth = CommunityMaterialIcon("cmd_battery_30_bluetooth", '\ue900')
        @JvmField
        val cmd_battery_30 = CommunityMaterialIcon("cmd_battery_30", '\ue900')
        @JvmField
        val cmd_battery_40_bluetooth = CommunityMaterialIcon("cmd_battery_40_bluetooth", '\ue900')
        @JvmField
        val cmd_battery_40 = CommunityMaterialIcon("cmd_battery_40", '\ue900')
        @JvmField
        val cmd_battery_50_bluetooth = CommunityMaterialIcon("cmd_battery_50_bluetooth", '\ue900')
        @JvmField
        val cmd_battery_50 = CommunityMaterialIcon("cmd_battery_50", '\ue900')
        @JvmField
        val cmd_battery_60_bluetooth = CommunityMaterialIcon("cmd_battery_60_bluetooth", '\ue900')
        @JvmField
        val cmd_battery_60 = CommunityMaterialIcon("cmd_battery_60", '\ue900')
        @JvmField
        val cmd_battery_70_bluetooth = CommunityMaterialIcon("cmd_battery_70_bluetooth", '\ue900')
        @JvmField
        val cmd_battery_70 = CommunityMaterialIcon("cmd_battery_70", '\ue900')
        @JvmField
        val cmd_battery_80_bluetooth = CommunityMaterialIcon("cmd_battery_80_bluetooth", '\ue900')
        @JvmField
        val cmd_battery_80 = CommunityMaterialIcon("cmd_battery_80", '\ue900')
        @JvmField
        val cmd_battery_90_bluetooth = CommunityMaterialIcon("cmd_battery_90_bluetooth", '\ue900')
        @JvmField
        val cmd_battery_90 = CommunityMaterialIcon("cmd_battery_90", '\ue900')
        @JvmField
        val cmd_battery_alert_bluetooth = CommunityMaterialIcon("cmd_battery_alert_bluetooth", '\ue900')
        @JvmField
        val cmd_battery_alert_variant_outline = CommunityMaterialIcon("cmd_battery_alert_variant_outline", '\ue900')
        @JvmField
        val cmd_battery_alert_variant = CommunityMaterialIcon("cmd_battery_alert_variant", '\ue900')
        @JvmField
        val cmd_battery_alert = CommunityMaterialIcon("cmd_battery_alert", '\ue900')
        @JvmField
        val cmd_battery_bluetooth_variant = CommunityMaterialIcon("cmd_battery_bluetooth_variant", '\ue900')
        @JvmField
        val cmd_battery_bluetooth = CommunityMaterialIcon("cmd_battery_bluetooth", '\ue900')
        @JvmField
        val cmd_battery_charging_10 = CommunityMaterialIcon("cmd_battery_charging_10", '\ue900')
        @JvmField
        val cmd_battery_charging_20 = CommunityMaterialIcon("cmd_battery_charging_20", '\ue900')
        @JvmField
        val cmd_battery_charging_30 = CommunityMaterialIcon("cmd_battery_charging_30", '\ue900')
        @JvmField
        val cmd_battery_charging_40 = CommunityMaterialIcon("cmd_battery_charging_40", '\ue900')
        @JvmField
        val cmd_battery_charging_50 = CommunityMaterialIcon("cmd_battery_charging_50", '\ue900')
        @JvmField
        val cmd_battery_charging_60 = CommunityMaterialIcon("cmd_battery_charging_60", '\ue900')
        @JvmField
        val cmd_battery_charging_70 = CommunityMaterialIcon("cmd_battery_charging_70", '\ue900')
        @JvmField
        val cmd_battery_charging_80 = CommunityMaterialIcon("cmd_battery_charging_80", '\ue900')
        @JvmField
        val cmd_battery_charging_90 = CommunityMaterialIcon("cmd_battery_charging_90", '\ue900')
        @JvmField
        val cmd_battery_charging_100 = CommunityMaterialIcon("cmd_battery_charging_100", '\ue900')
        @JvmField
        val cmd_battery_charging_high = CommunityMaterialIcon("cmd_battery_charging_high", '\ue900')
        @JvmField
        val cmd_battery_charging_low = CommunityMaterialIcon("cmd_battery_charging_low", '\ue900')
        @JvmField
        val cmd_battery_charging_medium = CommunityMaterialIcon("cmd_battery_charging_medium", '\ue900')
        @JvmField
        val cmd_battery_charging_outline = CommunityMaterialIcon("cmd_battery_charging_outline", '\ue900')
        @JvmField
        val cmd_battery_charging_wireless_10 = CommunityMaterialIcon("cmd_battery_charging_wireless_10", '\ue900')
        @JvmField
        val cmd_battery_charging_wireless_20 = CommunityMaterialIcon("cmd_battery_charging_wireless_20", '\ue900')
        @JvmField
        val cmd_battery_charging_wireless_30 = CommunityMaterialIcon("cmd_battery_charging_wireless_30", '\ue900')
        @JvmField
        val cmd_battery_charging_wireless_40 = CommunityMaterialIcon("cmd_battery_charging_wireless_40", '\ue900')
        @JvmField
        val cmd_battery_charging_wireless_50 = CommunityMaterialIcon("cmd_battery_charging_wireless_50", '\ue900')
        @JvmField
        val cmd_battery_charging_wireless_60 = CommunityMaterialIcon("cmd_battery_charging_wireless_60", '\ue900')
        @JvmField
        val cmd_battery_charging_wireless_70 = CommunityMaterialIcon("cmd_battery_charging_wireless_70", '\ue900')
        @JvmField
        val cmd_battery_charging_wireless_80 = CommunityMaterialIcon("cmd_battery_charging_wireless_80", '\ue900')
        @JvmField
        val cmd_battery_charging_wireless_90 = CommunityMaterialIcon("cmd_battery_charging_wireless_90", '\ue900')
        @JvmField
        val cmd_battery_charging_wireless_alert = CommunityMaterialIcon("cmd_battery_charging_wireless_alert", '\ue900')
        @JvmField
        val cmd_battery_charging_wireless_outline = CommunityMaterialIcon("cmd_battery_charging_wireless_outline", '\ue900')
        @JvmField
        val cmd_battery_charging_wireless = CommunityMaterialIcon("cmd_battery_charging_wireless", '\ue900')
        @JvmField
        val cmd_battery_charging = CommunityMaterialIcon("cmd_battery_charging", '\ue900')
        @JvmField
        val cmd_battery_heart_outline = CommunityMaterialIcon("cmd_battery_heart_outline", '\ue900')
        @JvmField
        val cmd_battery_heart_variant = CommunityMaterialIcon("cmd_battery_heart_variant", '\ue900')
        @JvmField
        val cmd_battery_heart = CommunityMaterialIcon("cmd_battery_heart", '\ue900')
        @JvmField
        val cmd_battery_high = CommunityMaterialIcon("cmd_battery_high", '\ue900')
        @JvmField
        val cmd_battery_low = CommunityMaterialIcon("cmd_battery_low", '\ue900')
        @JvmField
        val cmd_battery_medium = CommunityMaterialIcon("cmd_battery_medium", '\ue900')
        @JvmField
        val cmd_battery_minus = CommunityMaterialIcon("cmd_battery_minus", '\ue900')
        @JvmField
        val cmd_battery_negative = CommunityMaterialIcon("cmd_battery_negative", '\ue900')
        @JvmField
        val cmd_battery_off_outline = CommunityMaterialIcon("cmd_battery_off_outline", '\ue900')
        @JvmField
        val cmd_battery_off = CommunityMaterialIcon("cmd_battery_off", '\ue900')
        @JvmField
        val cmd_battery_outline = CommunityMaterialIcon("cmd_battery_outline", '\ue900')
        @JvmField
        val cmd_battery_plus = CommunityMaterialIcon("cmd_battery_plus", '\ue900')
        @JvmField
        val cmd_battery_positive = CommunityMaterialIcon("cmd_battery_positive", '\ue900')
        @JvmField
        val cmd_battery_unknown_bluetooth = CommunityMaterialIcon("cmd_battery_unknown_bluetooth", '\ue900')
        @JvmField
        val cmd_battery_unknown = CommunityMaterialIcon("cmd_battery_unknown", '\ue900')
        @JvmField
        val cmd_battery = CommunityMaterialIcon("cmd_battery", '\ue900')
        @JvmField
        val cmd_battlenet = CommunityMaterialIcon("cmd_battlenet", '\ue900')
        @JvmField
        val cmd_beach = CommunityMaterialIcon("cmd_beach", '\ue900')
        @JvmField
        val cmd_beaker_alert_outline = CommunityMaterialIcon("cmd_beaker_alert_outline", '\ue900')
        @JvmField
        val cmd_beaker_alert = CommunityMaterialIcon("cmd_beaker_alert", '\ue900')
        @JvmField
        val cmd_beaker_check_outline = CommunityMaterialIcon("cmd_beaker_check_outline", '\ue900')
        @JvmField
        val cmd_beaker_check = CommunityMaterialIcon("cmd_beaker_check", '\ue900')
        @JvmField
        val cmd_beaker_minus_outline = CommunityMaterialIcon("cmd_beaker_minus_outline", '\ue900')
        @JvmField
        val cmd_beaker_minus = CommunityMaterialIcon("cmd_beaker_minus", '\ue900')
        @JvmField
        val cmd_beaker_outline = CommunityMaterialIcon("cmd_beaker_outline", '\ue900')
        @JvmField
        val cmd_beaker_plus_outline = CommunityMaterialIcon("cmd_beaker_plus_outline", '\ue900')
        @JvmField
        val cmd_beaker_plus = CommunityMaterialIcon("cmd_beaker_plus", '\ue900')
        @JvmField
        val cmd_beaker_question_outline = CommunityMaterialIcon("cmd_beaker_question_outline", '\ue900')
        @JvmField
        val cmd_beaker_question = CommunityMaterialIcon("cmd_beaker_question", '\ue900')
        @JvmField
        val cmd_beaker_remove_outline = CommunityMaterialIcon("cmd_beaker_remove_outline", '\ue900')
        @JvmField
        val cmd_beaker_remove = CommunityMaterialIcon("cmd_beaker_remove", '\ue900')
        @JvmField
        val cmd_beaker = CommunityMaterialIcon("cmd_beaker", '\ue900')
        @JvmField
        val cmd_beats = CommunityMaterialIcon("cmd_beats", '\ue900')
        @JvmField
        val cmd_bed_double_outline = CommunityMaterialIcon("cmd_bed_double_outline", '\ue900')
        @JvmField
        val cmd_bed_double = CommunityMaterialIcon("cmd_bed_double", '\ue900')
        @JvmField
        val cmd_bed_empty = CommunityMaterialIcon("cmd_bed_empty", '\ue900')
        @JvmField
        val cmd_bed_king_outline = CommunityMaterialIcon("cmd_bed_king_outline", '\ue900')
        @JvmField
        val cmd_bed_king = CommunityMaterialIcon("cmd_bed_king", '\ue900')
        @JvmField
        val cmd_bed_queen_outline = CommunityMaterialIcon("cmd_bed_queen_outline", '\ue900')
        @JvmField
        val cmd_bed_queen = CommunityMaterialIcon("cmd_bed_queen", '\ue900')
        @JvmField
        val cmd_bed_single_outline = CommunityMaterialIcon("cmd_bed_single_outline", '\ue900')
        @JvmField
        val cmd_bed_single = CommunityMaterialIcon("cmd_bed_single", '\ue900')
        @JvmField
        val cmd_bee_flower = CommunityMaterialIcon("cmd_bee_flower", '\ue900')
        @JvmField
        val cmd_bee = CommunityMaterialIcon("cmd_bee", '\ue900')
        @JvmField
        val cmd_beehive_outline = CommunityMaterialIcon("cmd_beehive_outline", '\ue900')
        @JvmField
        val cmd_beer = CommunityMaterialIcon("cmd_beer", '\ue900')
        @JvmField
        val cmd_behance = CommunityMaterialIcon("cmd_behance", '\ue900')
        @JvmField
        val cmd_bell_alert_outline = CommunityMaterialIcon("cmd_bell_alert_outline", '\ue900')
        @JvmField
        val cmd_bell_alert = CommunityMaterialIcon("cmd_bell_alert", '\ue900')
        @JvmField
        val cmd_bell_check_outline = CommunityMaterialIcon("cmd_bell_check_outline", '\ue900')
        @JvmField
        val cmd_bell_check = CommunityMaterialIcon("cmd_bell_check", '\ue900')
        @JvmField
        val cmd_bell_circle_outline = CommunityMaterialIcon("cmd_bell_circle_outline", '\ue900')
        @JvmField
        val cmd_bell_circle = CommunityMaterialIcon("cmd_bell_circle", '\ue900')
        @JvmField
        val cmd_bell_off_outline = CommunityMaterialIcon("cmd_bell_off_outline", '\ue900')
        @JvmField
        val cmd_bell_off = CommunityMaterialIcon("cmd_bell_off", '\ue900')
        @JvmField
        val cmd_bell_outline = CommunityMaterialIcon("cmd_bell_outline", '\ue900')
        @JvmField
        val cmd_bell_plus_outline = CommunityMaterialIcon("cmd_bell_plus_outline", '\ue900')
        @JvmField
        val cmd_bell_plus = CommunityMaterialIcon("cmd_bell_plus", '\ue900')
        @JvmField
        val cmd_bell_ring_outline = CommunityMaterialIcon("cmd_bell_ring_outline", '\ue900')
        @JvmField
        val cmd_bell_ring = CommunityMaterialIcon("cmd_bell_ring", '\ue900')
        @JvmField
        val cmd_bell_sleep_outline = CommunityMaterialIcon("cmd_bell_sleep_outline", '\ue900')
        @JvmField
        val cmd_bell_sleep = CommunityMaterialIcon("cmd_bell_sleep", '\ue900')
        @JvmField
        val cmd_bell = CommunityMaterialIcon("cmd_bell", '\ue900')
        @JvmField
        val cmd_beta = CommunityMaterialIcon("cmd_beta", '\ue900')
        @JvmField
        val cmd_betamax = CommunityMaterialIcon("cmd_betamax", '\ue900')
        @JvmField
        val cmd_biathlon = CommunityMaterialIcon("cmd_biathlon", '\ue900')
        @JvmField
        val cmd_bible = CommunityMaterialIcon("cmd_bible", '\ue900')
        @JvmField
        val cmd_bicycle_basket = CommunityMaterialIcon("cmd_bicycle_basket", '\ue900')
        @JvmField
        val cmd_bicycle = CommunityMaterialIcon("cmd_bicycle", '\ue900')
        @JvmField
        val cmd_bike_fast = CommunityMaterialIcon("cmd_bike_fast", '\ue900')
        @JvmField
        val cmd_bike = CommunityMaterialIcon("cmd_bike", '\ue900')
        @JvmField
        val cmd_billboard = CommunityMaterialIcon("cmd_billboard", '\ue900')
        @JvmField
        val cmd_billiards_rack = CommunityMaterialIcon("cmd_billiards_rack", '\ue900')
        @JvmField
        val cmd_billiards = CommunityMaterialIcon("cmd_billiards", '\ue900')
        @JvmField
        val cmd_bing = CommunityMaterialIcon("cmd_bing", '\ue900')
        @JvmField
        val cmd_binoculars = CommunityMaterialIcon("cmd_binoculars", '\ue900')
        @JvmField
        val cmd_bio = CommunityMaterialIcon("cmd_bio", '\ue900')
        @JvmField
        val cmd_biohazard = CommunityMaterialIcon("cmd_biohazard", '\ue900')
        @JvmField
        val cmd_bitbucket = CommunityMaterialIcon("cmd_bitbucket", '\ue900')
        @JvmField
        val cmd_bitcoin = CommunityMaterialIcon("cmd_bitcoin", '\ue900')
        @JvmField
        val cmd_black_mesa = CommunityMaterialIcon("cmd_black_mesa", '\ue900')
        @JvmField
        val cmd_blackberry = CommunityMaterialIcon("cmd_blackberry", '\ue900')
        @JvmField
        val cmd_blender_software = CommunityMaterialIcon("cmd_blender_software", '\ue900')
        @JvmField
        val cmd_blender = CommunityMaterialIcon("cmd_blender", '\ue900')
        @JvmField
        val cmd_blinds_open = CommunityMaterialIcon("cmd_blinds_open", '\ue900')
        @JvmField
        val cmd_blinds = CommunityMaterialIcon("cmd_blinds", '\ue900')
        @JvmField
        val cmd_block_helper = CommunityMaterialIcon("cmd_block_helper", '\ue900')
        @JvmField
        val cmd_blogger = CommunityMaterialIcon("cmd_blogger", '\ue900')
        @JvmField
        val cmd_blood_bag = CommunityMaterialIcon("cmd_blood_bag", '\ue900')
        @JvmField
        val cmd_bluetooth_audio = CommunityMaterialIcon("cmd_bluetooth_audio", '\ue900')
        @JvmField
        val cmd_bluetooth_connect = CommunityMaterialIcon("cmd_bluetooth_connect", '\ue900')
        @JvmField
        val cmd_bluetooth_off = CommunityMaterialIcon("cmd_bluetooth_off", '\ue900')
        @JvmField
        val cmd_bluetooth_settings = CommunityMaterialIcon("cmd_bluetooth_settings", '\ue900')
        @JvmField
        val cmd_bluetooth_transfer = CommunityMaterialIcon("cmd_bluetooth_transfer", '\ue900')
        @JvmField
        val cmd_bluetooth = CommunityMaterialIcon("cmd_bluetooth", '\ue900')
        @JvmField
        val cmd_blur_linear = CommunityMaterialIcon("cmd_blur_linear", '\ue900')
        @JvmField
        val cmd_blur_off = CommunityMaterialIcon("cmd_blur_off", '\ue900')
        @JvmField
        val cmd_blur_radial = CommunityMaterialIcon("cmd_blur_radial", '\ue900')
        @JvmField
        val cmd_blur = CommunityMaterialIcon("cmd_blur", '\ue900')
        @JvmField
        val cmd_bolnisi_cross = CommunityMaterialIcon("cmd_bolnisi_cross", '\ue900')
        @JvmField
        val cmd_bolt = CommunityMaterialIcon("cmd_bolt", '\ue900')
        @JvmField
        val cmd_bomb_off = CommunityMaterialIcon("cmd_bomb_off", '\ue900')
        @JvmField
        val cmd_bomb = CommunityMaterialIcon("cmd_bomb", '\ue900')
        @JvmField
        val cmd_bone = CommunityMaterialIcon("cmd_bone", '\ue900')
        @JvmField
        val cmd_book_information_variant = CommunityMaterialIcon("cmd_book_information_variant", '\ue900')
        @JvmField
        val cmd_book_lock_open = CommunityMaterialIcon("cmd_book_lock_open", '\ue900')
        @JvmField
        val cmd_book_lock = CommunityMaterialIcon("cmd_book_lock", '\ue900')
        @JvmField
        val cmd_book_minus_multiple = CommunityMaterialIcon("cmd_book_minus_multiple", '\ue900')
        @JvmField
        val cmd_book_minus = CommunityMaterialIcon("cmd_book_minus", '\ue900')
        @JvmField
        val cmd_book_multiple = CommunityMaterialIcon("cmd_book_multiple", '\ue900')
        @JvmField
        val cmd_book_open_outline = CommunityMaterialIcon("cmd_book_open_outline", '\ue900')
        @JvmField
        val cmd_book_open_page_variant = CommunityMaterialIcon("cmd_book_open_page_variant", '\ue900')
        @JvmField
        val cmd_book_open_variant = CommunityMaterialIcon("cmd_book_open_variant", '\ue900')
        @JvmField
        val cmd_book_open = CommunityMaterialIcon("cmd_book_open", '\ue900')
        @JvmField
        val cmd_book_outline = CommunityMaterialIcon("cmd_book_outline", '\ue900')
        @JvmField
        val cmd_book_play_outline = CommunityMaterialIcon("cmd_book_play_outline", '\ue900')
        @JvmField
        val cmd_book_play = CommunityMaterialIcon("cmd_book_play", '\ue900')
        @JvmField
        val cmd_book_plus_multiple = CommunityMaterialIcon("cmd_book_plus_multiple", '\ue900')
        @JvmField
        val cmd_book_plus = CommunityMaterialIcon("cmd_book_plus", '\ue900')
        @JvmField
        val cmd_book_remove_multiple = CommunityMaterialIcon("cmd_book_remove_multiple", '\ue900')
        @JvmField
        val cmd_book_remove = CommunityMaterialIcon("cmd_book_remove", '\ue900')
        @JvmField
        val cmd_book_search_outline = CommunityMaterialIcon("cmd_book_search_outline", '\ue900')
        @JvmField
        val cmd_book_search = CommunityMaterialIcon("cmd_book_search", '\ue900')
        @JvmField
        val cmd_book_variant_multiple = CommunityMaterialIcon("cmd_book_variant_multiple", '\ue900')
        @JvmField
        val cmd_book_variant = CommunityMaterialIcon("cmd_book_variant", '\ue900')
        @JvmField
        val cmd_book = CommunityMaterialIcon("cmd_book", '\ue900')
        @JvmField
        val cmd_bookmark_check = CommunityMaterialIcon("cmd_bookmark_check", '\ue900')
        @JvmField
        val cmd_bookmark_minus_outline = CommunityMaterialIcon("cmd_bookmark_minus_outline", '\ue900')
        @JvmField
        val cmd_bookmark_minus = CommunityMaterialIcon("cmd_bookmark_minus", '\ue900')
        @JvmField
        val cmd_bookmark_multiple_outline = CommunityMaterialIcon("cmd_bookmark_multiple_outline", '\ue900')
        @JvmField
        val cmd_bookmark_multiple = CommunityMaterialIcon("cmd_bookmark_multiple", '\ue900')
        @JvmField
        val cmd_bookmark_music = CommunityMaterialIcon("cmd_bookmark_music", '\ue900')
        @JvmField
        val cmd_bookmark_off_outline = CommunityMaterialIcon("cmd_bookmark_off_outline", '\ue900')
        @JvmField
        val cmd_bookmark_off = CommunityMaterialIcon("cmd_bookmark_off", '\ue900')
        @JvmField
        val cmd_bookmark_outline = CommunityMaterialIcon("cmd_bookmark_outline", '\ue900')
        @JvmField
        val cmd_bookmark_plus_outline = CommunityMaterialIcon("cmd_bookmark_plus_outline", '\ue900')
        @JvmField
        val cmd_bookmark_plus = CommunityMaterialIcon("cmd_bookmark_plus", '\ue900')
        @JvmField
        val cmd_bookmark_remove = CommunityMaterialIcon("cmd_bookmark_remove", '\ue900')
        @JvmField
        val cmd_bookmark = CommunityMaterialIcon("cmd_bookmark", '\ue900')
        @JvmField
        val cmd_bookshelf = CommunityMaterialIcon("cmd_bookshelf", '\ue900')
        @JvmField
        val cmd_boom_gate_alert_outline = CommunityMaterialIcon("cmd_boom_gate_alert_outline", '\ue900')
        @JvmField
        val cmd_boom_gate_alert = CommunityMaterialIcon("cmd_boom_gate_alert", '\ue900')
        @JvmField
        val cmd_boom_gate_down_outline = CommunityMaterialIcon("cmd_boom_gate_down_outline", '\ue900')
        @JvmField
        val cmd_boom_gate_down = CommunityMaterialIcon("cmd_boom_gate_down", '\ue900')
        @JvmField
        val cmd_boom_gate_outline = CommunityMaterialIcon("cmd_boom_gate_outline", '\ue900')
        @JvmField
        val cmd_boom_gate_up_outline = CommunityMaterialIcon("cmd_boom_gate_up_outline", '\ue900')
        @JvmField
        val cmd_boom_gate_up = CommunityMaterialIcon("cmd_boom_gate_up", '\ue900')
        @JvmField
        val cmd_boom_gate = CommunityMaterialIcon("cmd_boom_gate", '\ue900')
        @JvmField
        val cmd_boombox = CommunityMaterialIcon("cmd_boombox", '\ue900')
        @JvmField
        val cmd_boomerang = CommunityMaterialIcon("cmd_boomerang", '\ue900')
        @JvmField
        val cmd_bootstrap = CommunityMaterialIcon("cmd_bootstrap", '\ue900')
        @JvmField
        val cmd_border_all_variant = CommunityMaterialIcon("cmd_border_all_variant", '\ue900')
        @JvmField
        val cmd_border_all = CommunityMaterialIcon("cmd_border_all", '\ue900')
        @JvmField
        val cmd_border_bottom_variant = CommunityMaterialIcon("cmd_border_bottom_variant", '\ue900')
        @JvmField
        val cmd_border_bottom = CommunityMaterialIcon("cmd_border_bottom", '\ue900')
        @JvmField
        val cmd_border_color = CommunityMaterialIcon("cmd_border_color", '\ue900')
        @JvmField
        val cmd_border_horizontal = CommunityMaterialIcon("cmd_border_horizontal", '\ue900')
        @JvmField
        val cmd_border_inside = CommunityMaterialIcon("cmd_border_inside", '\ue900')
        @JvmField
        val cmd_border_left_variant = CommunityMaterialIcon("cmd_border_left_variant", '\ue900')
        @JvmField
        val cmd_border_left = CommunityMaterialIcon("cmd_border_left", '\ue900')
        @JvmField
        val cmd_border_none_variant = CommunityMaterialIcon("cmd_border_none_variant", '\ue900')
        @JvmField
        val cmd_border_none = CommunityMaterialIcon("cmd_border_none", '\ue900')
        @JvmField
        val cmd_border_outside = CommunityMaterialIcon("cmd_border_outside", '\ue900')
        @JvmField
        val cmd_border_right_variant = CommunityMaterialIcon("cmd_border_right_variant", '\ue900')
        @JvmField
        val cmd_border_right = CommunityMaterialIcon("cmd_border_right", '\ue900')
        @JvmField
        val cmd_border_style = CommunityMaterialIcon("cmd_border_style", '\ue900')
        @JvmField
        val cmd_border_top_variant = CommunityMaterialIcon("cmd_border_top_variant", '\ue900')
        @JvmField
        val cmd_border_top = CommunityMaterialIcon("cmd_border_top", '\ue900')
        @JvmField
        val cmd_border_vertical = CommunityMaterialIcon("cmd_border_vertical", '\ue900')
        @JvmField
        val cmd_bottle_soda_classic = CommunityMaterialIcon("cmd_bottle_soda_classic", '\ue900')
        @JvmField
        val cmd_bottle_soda_outline = CommunityMaterialIcon("cmd_bottle_soda_outline", '\ue900')
        @JvmField
        val cmd_bottle_soda = CommunityMaterialIcon("cmd_bottle_soda", '\ue900')
        @JvmField
        val cmd_bottle_tonic_outline = CommunityMaterialIcon("cmd_bottle_tonic_outline", '\ue900')
        @JvmField
        val cmd_bottle_tonic_plus_outline = CommunityMaterialIcon("cmd_bottle_tonic_plus_outline", '\ue900')
        @JvmField
        val cmd_bottle_tonic_plus = CommunityMaterialIcon("cmd_bottle_tonic_plus", '\ue900')
        @JvmField
        val cmd_bottle_tonic_skull_outline = CommunityMaterialIcon("cmd_bottle_tonic_skull_outline", '\ue900')
        @JvmField
        val cmd_bottle_tonic_skull = CommunityMaterialIcon("cmd_bottle_tonic_skull", '\ue900')
        @JvmField
        val cmd_bottle_tonic = CommunityMaterialIcon("cmd_bottle_tonic", '\ue900')
        @JvmField
        val cmd_bottle_wine = CommunityMaterialIcon("cmd_bottle_wine", '\ue900')
        @JvmField
        val cmd_bow_tie = CommunityMaterialIcon("cmd_bow_tie", '\ue900')
        @JvmField
        val cmd_bowl = CommunityMaterialIcon("cmd_bowl", '\ue900')
        @JvmField
        val cmd_bowling = CommunityMaterialIcon("cmd_bowling", '\ue900')
        @JvmField
        val cmd_box_cutter = CommunityMaterialIcon("cmd_box_cutter", '\ue900')
        @JvmField
        val cmd_box_shadow = CommunityMaterialIcon("cmd_box_shadow", '\ue900')
        @JvmField
        val cmd_box = CommunityMaterialIcon("cmd_box", '\ue900')
        @JvmField
        val cmd_boxing_glove = CommunityMaterialIcon("cmd_boxing_glove", '\ue900')
        @JvmField
        val cmd_braille = CommunityMaterialIcon("cmd_braille", '\ue900')
        @JvmField
        val cmd_brain = CommunityMaterialIcon("cmd_brain", '\ue900')
        @JvmField
        val cmd_bread_slice_outline = CommunityMaterialIcon("cmd_bread_slice_outline", '\ue900')
        @JvmField
        val cmd_bread_slice = CommunityMaterialIcon("cmd_bread_slice", '\ue900')
        @JvmField
        val cmd_bridge = CommunityMaterialIcon("cmd_bridge", '\ue900')
        @JvmField
        val cmd_briefcase_account_outline = CommunityMaterialIcon("cmd_briefcase_account_outline", '\ue900')
        @JvmField
        val cmd_briefcase_account = CommunityMaterialIcon("cmd_briefcase_account", '\ue900')
        @JvmField
        val cmd_briefcase_check = CommunityMaterialIcon("cmd_briefcase_check", '\ue900')
        @JvmField
        val cmd_briefcase_clock_outline = CommunityMaterialIcon("cmd_briefcase_clock_outline", '\ue900')
        @JvmField
        val cmd_briefcase_clock = CommunityMaterialIcon("cmd_briefcase_clock", '\ue900')
        @JvmField
        val cmd_briefcase_download_outline = CommunityMaterialIcon("cmd_briefcase_download_outline", '\ue900')
        @JvmField
        val cmd_briefcase_download = CommunityMaterialIcon("cmd_briefcase_download", '\ue900')
        @JvmField
        val cmd_briefcase_edit_outline = CommunityMaterialIcon("cmd_briefcase_edit_outline", '\ue900')
        @JvmField
        val cmd_briefcase_edit = CommunityMaterialIcon("cmd_briefcase_edit", '\ue900')
        @JvmField
        val cmd_briefcase_minus_outline = CommunityMaterialIcon("cmd_briefcase_minus_outline", '\ue900')
        @JvmField
        val cmd_briefcase_minus = CommunityMaterialIcon("cmd_briefcase_minus", '\ue900')
        @JvmField
        val cmd_briefcase_outline = CommunityMaterialIcon("cmd_briefcase_outline", '\ue900')
        @JvmField
        val cmd_briefcase_plus_outline = CommunityMaterialIcon("cmd_briefcase_plus_outline", '\ue900')
        @JvmField
        val cmd_briefcase_plus = CommunityMaterialIcon("cmd_briefcase_plus", '\ue900')
        @JvmField
        val cmd_briefcase_remove_outline = CommunityMaterialIcon("cmd_briefcase_remove_outline", '\ue900')
        @JvmField
        val cmd_briefcase_remove = CommunityMaterialIcon("cmd_briefcase_remove", '\ue900')
        @JvmField
        val cmd_briefcase_search_outline = CommunityMaterialIcon("cmd_briefcase_search_outline", '\ue900')
        @JvmField
        val cmd_briefcase_search = CommunityMaterialIcon("cmd_briefcase_search", '\ue900')
        @JvmField
        val cmd_briefcase_upload_outline = CommunityMaterialIcon("cmd_briefcase_upload_outline", '\ue900')
        @JvmField
        val cmd_briefcase_upload = CommunityMaterialIcon("cmd_briefcase_upload", '\ue900')
        @JvmField
        val cmd_briefcase = CommunityMaterialIcon("cmd_briefcase", '\ue900')
        @JvmField
        val cmd_brightness_1 = CommunityMaterialIcon("cmd_brightness_1", '\ue900')
        @JvmField
        val cmd_brightness_2 = CommunityMaterialIcon("cmd_brightness_2", '\ue900')
        @JvmField
        val cmd_brightness_3 = CommunityMaterialIcon("cmd_brightness_3", '\ue900')
        @JvmField
        val cmd_brightness_4 = CommunityMaterialIcon("cmd_brightness_4", '\ue900')
        @JvmField
        val cmd_brightness_5 = CommunityMaterialIcon("cmd_brightness_5", '\ue900')
        @JvmField
        val cmd_brightness_6 = CommunityMaterialIcon("cmd_brightness_6", '\ue900')
        @JvmField
        val cmd_brightness_7 = CommunityMaterialIcon("cmd_brightness_7", '\ue900')
        @JvmField
        val cmd_brightness_auto = CommunityMaterialIcon("cmd_brightness_auto", '\ue900')
        @JvmField
        val cmd_brightness_percent = CommunityMaterialIcon("cmd_brightness_percent", '\ue900')
        @JvmField
        val cmd_broom = CommunityMaterialIcon("cmd_broom", '\ue900')
        @JvmField
        val cmd_brush = CommunityMaterialIcon("cmd_brush", '\ue900')
        @JvmField
        val cmd_buddhism = CommunityMaterialIcon("cmd_buddhism", '\ue900')
        @JvmField
        val cmd_buffer = CommunityMaterialIcon("cmd_buffer", '\ue900')
        @JvmField
        val cmd_bug_check_outline = CommunityMaterialIcon("cmd_bug_check_outline", '\ue900')
        @JvmField
        val cmd_bug_check = CommunityMaterialIcon("cmd_bug_check", '\ue900')
        @JvmField
        val cmd_bug_outline = CommunityMaterialIcon("cmd_bug_outline", '\ue900')
        @JvmField
        val cmd_bug = CommunityMaterialIcon("cmd_bug", '\ue900')
        @JvmField
        val cmd_bugle = CommunityMaterialIcon("cmd_bugle", '\ue900')
        @JvmField
        val cmd_bulldozer = CommunityMaterialIcon("cmd_bulldozer", '\ue900')
        @JvmField
        val cmd_bullet = CommunityMaterialIcon("cmd_bullet", '\ue900')
        @JvmField
        val cmd_bulletin_board = CommunityMaterialIcon("cmd_bulletin_board", '\ue900')
        @JvmField
        val cmd_bullhorn_outline = CommunityMaterialIcon("cmd_bullhorn_outline", '\ue900')
        @JvmField
        val cmd_bullhorn = CommunityMaterialIcon("cmd_bullhorn", '\ue900')
        @JvmField
        val cmd_bullseye_arrow = CommunityMaterialIcon("cmd_bullseye_arrow", '\ue900')
        @JvmField
        val cmd_bullseye = CommunityMaterialIcon("cmd_bullseye", '\ue900')
        @JvmField
        val cmd_bus_alert = CommunityMaterialIcon("cmd_bus_alert", '\ue900')
        @JvmField
        val cmd_bus_articulated_end = CommunityMaterialIcon("cmd_bus_articulated_end", '\ue900')
        @JvmField
        val cmd_bus_articulated_front = CommunityMaterialIcon("cmd_bus_articulated_front", '\ue900')
        @JvmField
        val cmd_bus_clock = CommunityMaterialIcon("cmd_bus_clock", '\ue900')
        @JvmField
        val cmd_bus_double_decker = CommunityMaterialIcon("cmd_bus_double_decker", '\ue900')
        @JvmField
        val cmd_bus_marker = CommunityMaterialIcon("cmd_bus_marker", '\ue900')
        @JvmField
        val cmd_bus_multiple = CommunityMaterialIcon("cmd_bus_multiple", '\ue900')
        @JvmField
        val cmd_bus_school = CommunityMaterialIcon("cmd_bus_school", '\ue900')
        @JvmField
        val cmd_bus_side = CommunityMaterialIcon("cmd_bus_side", '\ue900')
        @JvmField
        val cmd_bus_stop_covered = CommunityMaterialIcon("cmd_bus_stop_covered", '\ue900')
        @JvmField
        val cmd_bus_stop_uncovered = CommunityMaterialIcon("cmd_bus_stop_uncovered", '\ue900')
        @JvmField
        val cmd_bus_stop = CommunityMaterialIcon("cmd_bus_stop", '\ue900')
        @JvmField
        val cmd_bus = CommunityMaterialIcon("cmd_bus", '\ue900')
        @JvmField
        val cmd_cached = CommunityMaterialIcon("cmd_cached", '\ue900')
        @JvmField
        val cmd_cactus = CommunityMaterialIcon("cmd_cactus", '\ue900')
        @JvmField
        val cmd_cake_layered = CommunityMaterialIcon("cmd_cake_layered", '\ue900')
        @JvmField
        val cmd_cake_variant = CommunityMaterialIcon("cmd_cake_variant", '\ue900')
        @JvmField
        val cmd_cake = CommunityMaterialIcon("cmd_cake", '\ue900')
        @JvmField
        val cmd_calculator_variant = CommunityMaterialIcon("cmd_calculator_variant", '\ue900')
        @JvmField
        val cmd_calculator = CommunityMaterialIcon("cmd_calculator", '\ue900')
        @JvmField
        val cmd_calendar_account_outline = CommunityMaterialIcon("cmd_calendar_account_outline", '\ue900')
        @JvmField
        val cmd_calendar_account = CommunityMaterialIcon("cmd_calendar_account", '\ue900')
        @JvmField
        val cmd_calendar_alert = CommunityMaterialIcon("cmd_calendar_alert", '\ue900')
        @JvmField
        val cmd_calendar_arrow_left = CommunityMaterialIcon("cmd_calendar_arrow_left", '\ue900')
        @JvmField
        val cmd_calendar_arrow_right = CommunityMaterialIcon("cmd_calendar_arrow_right", '\ue900')
        @JvmField
        val cmd_calendar_blank_multiple = CommunityMaterialIcon("cmd_calendar_blank_multiple", '\ue900')
        @JvmField
        val cmd_calendar_blank_outline = CommunityMaterialIcon("cmd_calendar_blank_outline", '\ue900')
        @JvmField
        val cmd_calendar_blank = CommunityMaterialIcon("cmd_calendar_blank", '\ue900')
        @JvmField
        val cmd_calendar_check_outline = CommunityMaterialIcon("cmd_calendar_check_outline", '\ue900')
        @JvmField
        val cmd_calendar_check = CommunityMaterialIcon("cmd_calendar_check", '\ue900')
        @JvmField
        val cmd_calendar_clock = CommunityMaterialIcon("cmd_calendar_clock", '\ue900')
        @JvmField
        val cmd_calendar_edit = CommunityMaterialIcon("cmd_calendar_edit", '\ue900')
        @JvmField
        val cmd_calendar_export = CommunityMaterialIcon("cmd_calendar_export", '\ue900')
        @JvmField
        val cmd_calendar_heart = CommunityMaterialIcon("cmd_calendar_heart", '\ue900')
        @JvmField
        val cmd_calendar_import = CommunityMaterialIcon("cmd_calendar_import", '\ue900')
        @JvmField
        val cmd_calendar_minus = CommunityMaterialIcon("cmd_calendar_minus", '\ue900')
        @JvmField
        val cmd_calendar_month_outline = CommunityMaterialIcon("cmd_calendar_month_outline", '\ue900')
        @JvmField
        val cmd_calendar_month = CommunityMaterialIcon("cmd_calendar_month", '\ue900')
        @JvmField
        val cmd_calendar_multiple_check = CommunityMaterialIcon("cmd_calendar_multiple_check", '\ue900')
        @JvmField
        val cmd_calendar_multiple = CommunityMaterialIcon("cmd_calendar_multiple", '\ue900')
        @JvmField
        val cmd_calendar_multiselect = CommunityMaterialIcon("cmd_calendar_multiselect", '\ue900')
        @JvmField
        val cmd_calendar_outline = CommunityMaterialIcon("cmd_calendar_outline", '\ue900')
        @JvmField
        val cmd_calendar_plus = CommunityMaterialIcon("cmd_calendar_plus", '\ue900')
        @JvmField
        val cmd_calendar_question = CommunityMaterialIcon("cmd_calendar_question", '\ue900')
        @JvmField
        val cmd_calendar_range_outline = CommunityMaterialIcon("cmd_calendar_range_outline", '\ue900')
        @JvmField
        val cmd_calendar_range = CommunityMaterialIcon("cmd_calendar_range", '\ue900')
        @JvmField
        val cmd_calendar_remove_outline = CommunityMaterialIcon("cmd_calendar_remove_outline", '\ue900')
        @JvmField
        val cmd_calendar_remove = CommunityMaterialIcon("cmd_calendar_remove", '\ue900')
        @JvmField
        val cmd_calendar_repeat_outline = CommunityMaterialIcon("cmd_calendar_repeat_outline", '\ue900')
        @JvmField
        val cmd_calendar_repeat = CommunityMaterialIcon("cmd_calendar_repeat", '\ue900')
        @JvmField
        val cmd_calendar_search = CommunityMaterialIcon("cmd_calendar_search", '\ue900')
        @JvmField
        val cmd_calendar_star = CommunityMaterialIcon("cmd_calendar_star", '\ue900')
        @JvmField
        val cmd_calendar_text_outline = CommunityMaterialIcon("cmd_calendar_text_outline", '\ue900')
        @JvmField
        val cmd_calendar_text = CommunityMaterialIcon("cmd_calendar_text", '\ue900')
        @JvmField
        val cmd_calendar_today = CommunityMaterialIcon("cmd_calendar_today", '\ue900')
        @JvmField
        val cmd_calendar_week_begin = CommunityMaterialIcon("cmd_calendar_week_begin", '\ue900')
        @JvmField
        val cmd_calendar_week = CommunityMaterialIcon("cmd_calendar_week", '\ue900')
        @JvmField
        val cmd_calendar_weekend_outline = CommunityMaterialIcon("cmd_calendar_weekend_outline", '\ue900')
        @JvmField
        val cmd_calendar_weekend = CommunityMaterialIcon("cmd_calendar_weekend", '\ue900')
        @JvmField
        val cmd_calendar = CommunityMaterialIcon("cmd_calendar", '\ue900')
    }
}

class CommunityMaterialIcon(
    override val name: String,
    override val character: Char
) : IIcon {
    override val formattedName: String = "{$name}"

    override val typeface: ITypeface by lazy { CommunityMaterial }
}