/*
 * Copyright 2019 Mike Penz
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
package com.mikepenz.iconics.typeface.library.pixeden7stroke

import com.mikepenz.iconics.typeface.IIcon
import com.mikepenz.iconics.typeface.ITypeface
import java.util.LinkedList

@Suppress("EnumEntryName")
object Pixeden7Stroke : ITypeface {

    override val fontRes: Int
        get() = R.font.pixeden_7_stroke_font_v1_2_0

    override val characters: Map<String, Char> by lazy {
        Icon.values().associate { it.name to it.character }
    }

    override val mappingPrefix: String
        get() = "pe7"

    override val fontName: String
        get() = "Pixeden 7 Stroke"

    override val version: String
        get() = "1.2.0.0"

    override val iconCount: Int
        get() = characters.size

    override val icons: List<String>
        get() = characters.keys.toCollection(LinkedList())

    override val author: String
        get() = "Riccardo Montagnin"

    override val url: String
        get() = "http://themes-pixeden.com/font-demos/7-stroke/"

    override val description: String
        get() = "A series of iOS 7 inspired vector icons"

    override val license: String
        get() = "Royalty free for use in both personal and commercial projects"

    override val licenseUrl: String
        get() = "http://themes-pixeden.com/font-demos/7-stroke/"

    override fun getIcon(key: String): IIcon = Icon.valueOf(key)

    enum class Icon constructor(override val character: Char) : IIcon {
        pe7_7s_album('\ue6aa'),
        pe7_7s_arc('\ue6ab'),
        pe7_7s_back_2('\ue6ac'),
        pe7_7s_bandaid('\ue6ad'),
        pe7_7s_car('\ue6ae'),
        pe7_7s_diamond('\ue6af'),
        pe7_7s_door_lock('\ue6b0'),
        pe7_7s_eyedropper('\ue6b1'),
        pe7_7s_female('\ue6b2'),
        pe7_7s_gym('\ue6b3'),
        pe7_7s_hammer('\ue6b4'),
        pe7_7s_headphones('\ue6b5'),
        pe7_7s_helm('\ue6b6'),
        pe7_7s_hourglass('\ue6b7'),
        pe7_7s_leaf('\ue6b8'),
        pe7_7s_magic_wand('\ue6b9'),
        pe7_7s_male('\ue6ba'),
        pe7_7s_map_2('\ue6bb'),
        pe7_7s_next_2('\ue6bc'),
        pe7_7s_paint_bucket('\ue6bd'),
        pe7_7s_pendrive('\ue6be'),
        pe7_7s_photo('\ue6bf'),
        pe7_7s_piggy('\ue6c0'),
        pe7_7s_plugin('\ue6c1'),
        pe7_7s_refresh_2('\ue6c2'),
        pe7_7s_rocket('\ue6c3'),
        pe7_7s_settings('\ue6c4'),
        pe7_7s_shield('\ue6c5'),
        pe7_7s_smile('\ue6c6'),
        pe7_7s_usb('\ue6c7'),
        pe7_7s_vector('\ue6c8'),
        pe7_7s_wine('\ue6c9'),
        pe7_7s_cloud_upload('\ue68a'),
        pe7_7s_cash('\ue68c'),
        pe7_7s_close('\ue680'),
        pe7_7s_bluetooth('\ue68d'),
        pe7_7s_cloud_download('\ue68b'),
        pe7_7s_way('\ue68e'),
        pe7_7s_close_circle('\ue681'),
        pe7_7s_id('\ue68f'),
        pe7_7s_angle_up('\ue682'),
        pe7_7s_wristwatch('\ue690'),
        pe7_7s_angle_up_circle('\ue683'),
        pe7_7s_world('\ue691'),
        pe7_7s_angle_right('\ue684'),
        pe7_7s_volume('\ue692'),
        pe7_7s_angle_right_circle('\ue685'),
        pe7_7s_users('\ue693'),
        pe7_7s_angle_left('\ue686'),
        pe7_7s_user_female('\ue694'),
        pe7_7s_angle_left_circle('\ue687'),
        pe7_7s_up_arrow('\ue695'),
        pe7_7s_angle_down('\ue688'),
        pe7_7s_switch('\ue696'),
        pe7_7s_angle_down_circle('\ue689'),
        pe7_7s_scissors('\ue697'),
        pe7_7s_wallet('\ue600'),
        pe7_7s_safe('\ue698'),
        pe7_7s_volume2('\ue601'),
        pe7_7s_volume1('\ue602'),
        pe7_7s_voicemail('\ue603'),
        pe7_7s_video('\ue604'),
        pe7_7s_user('\ue605'),
        pe7_7s_upload('\ue606'),
        pe7_7s_unlock('\ue607'),
        pe7_7s_umbrella('\ue608'),
        pe7_7s_trash('\ue609'),
        pe7_7s_tools('\ue60a'),
        pe7_7s_timer('\ue60b'),
        pe7_7s_ticket('\ue60c'),
        pe7_7s_target('\ue60d'),
        pe7_7s_sun('\ue60e'),
        pe7_7s_study('\ue60f'),
        pe7_7s_stopwatch('\ue610'),
        pe7_7s_star('\ue611'),
        pe7_7s_speaker('\ue612'),
        pe7_7s_signal('\ue613'),
        pe7_7s_shuffle('\ue614'),
        pe7_7s_shopbag('\ue615'),
        pe7_7s_share('\ue616'),
        pe7_7s_server('\ue617'),
        pe7_7s_search('\ue618'),
        pe7_7s_film('\ue6a5'),
        pe7_7s_science('\ue619'),
        pe7_7s_disk('\ue6a6'),
        pe7_7s_ribbon('\ue61a'),
        pe7_7s_repeat('\ue61b'),
        pe7_7s_refresh('\ue61c'),
        pe7_7s_add_user('\ue6a9'),
        pe7_7s_refresh_cloud('\ue61d'),
        pe7_7s_paperclip('\ue69c'),
        pe7_7s_radio('\ue61e'),
        pe7_7s_note2('\ue69d'),
        pe7_7s_print('\ue61f'),
        pe7_7s_network('\ue69e'),
        pe7_7s_prev('\ue620'),
        pe7_7s_mute('\ue69f'),
        pe7_7s_power('\ue621'),
        pe7_7s_medal('\ue6a0'),
        pe7_7s_portfolio('\ue622'),
        pe7_7s_like2('\ue6a1'),
        pe7_7s_plus('\ue623'),
        pe7_7s_left_arrow('\ue6a2'),
        pe7_7s_play('\ue624'),
        pe7_7s_key('\ue6a3'),
        pe7_7s_plane('\ue625'),
        pe7_7s_joy('\ue6a4'),
        pe7_7s_photo_gallery('\ue626'),
        pe7_7s_pin('\ue69b'),
        pe7_7s_phone('\ue627'),
        pe7_7s_plug('\ue69a'),
        pe7_7s_pen('\ue628'),
        pe7_7s_right_arrow('\ue699'),
        pe7_7s_paper_plane('\ue629'),
        pe7_7s_delete_user('\ue6a7'),
        pe7_7s_paint('\ue62a'),
        pe7_7s_bottom_arrow('\ue6a8'),
        pe7_7s_notebook('\ue62b'),
        pe7_7s_note('\ue62c'),
        pe7_7s_next('\ue62d'),
        pe7_7s_news_paper('\ue62e'),
        pe7_7s_musiclist('\ue62f'),
        pe7_7s_music('\ue630'),
        pe7_7s_mouse('\ue631'),
        pe7_7s_more('\ue632'),
        pe7_7s_moon('\ue633'),
        pe7_7s_monitor('\ue634'),
        pe7_7s_micro('\ue635'),
        pe7_7s_menu('\ue636'),
        pe7_7s_map('\ue637'),
        pe7_7s_map_marker('\ue638'),
        pe7_7s_mail('\ue639'),
        pe7_7s_mail_open('\ue63a'),
        pe7_7s_mail_open_file('\ue63b'),
        pe7_7s_magnet('\ue63c'),
        pe7_7s_loop('\ue63d'),
        pe7_7s_look('\ue63e'),
        pe7_7s_lock('\ue63f'),
        pe7_7s_lintern('\ue640'),
        pe7_7s_link('\ue641'),
        pe7_7s_like('\ue642'),
        pe7_7s_light('\ue643'),
        pe7_7s_less('\ue644'),
        pe7_7s_keypad('\ue645'),
        pe7_7s_junk('\ue646'),
        pe7_7s_info('\ue647'),
        pe7_7s_home('\ue648'),
        pe7_7s_help2('\ue649'),
        pe7_7s_help1('\ue64a'),
        pe7_7s_graph3('\ue64b'),
        pe7_7s_graph2('\ue64c'),
        pe7_7s_graph1('\ue64d'),
        pe7_7s_graph('\ue64e'),
        pe7_7s_global('\ue64f'),
        pe7_7s_gleam('\ue650'),
        pe7_7s_glasses('\ue651'),
        pe7_7s_gift('\ue652'),
        pe7_7s_folder('\ue653'),
        pe7_7s_flag('\ue654'),
        pe7_7s_filter('\ue655'),
        pe7_7s_file('\ue656'),
        pe7_7s_expand1('\ue657'),
        pe7_7s_exapnd2('\ue658'),
        pe7_7s_edit('\ue659'),
        pe7_7s_drop('\ue65a'),
        pe7_7s_drawer('\ue65b'),
        pe7_7s_download('\ue65c'),
        pe7_7s_display2('\ue65d'),
        pe7_7s_display1('\ue65e'),
        pe7_7s_diskette('\ue65f'),
        pe7_7s_date('\ue660'),
        pe7_7s_cup('\ue661'),
        pe7_7s_culture('\ue662'),
        pe7_7s_crop('\ue663'),
        pe7_7s_credit('\ue664'),
        pe7_7s_copy_file('\ue665'),
        pe7_7s_config('\ue666'),
        pe7_7s_compass('\ue667'),
        pe7_7s_comment('\ue668'),
        pe7_7s_coffee('\ue669'),
        pe7_7s_cloud('\ue66a'),
        pe7_7s_clock('\ue66b'),
        pe7_7s_check('\ue66c'),
        pe7_7s_chat('\ue66d'),
        pe7_7s_cart('\ue66e'),
        pe7_7s_camera('\ue66f'),
        pe7_7s_call('\ue670'),
        pe7_7s_calculator('\ue671'),
        pe7_7s_browser('\ue672'),
        pe7_7s_box2('\ue673'),
        pe7_7s_box1('\ue674'),
        pe7_7s_bookmarks('\ue675'),
        pe7_7s_bicycle('\ue676'),
        pe7_7s_bell('\ue677'),
        pe7_7s_battery('\ue678'),
        pe7_7s_ball('\ue679'),
        pe7_7s_back('\ue67a'),
        pe7_7s_attention('\ue67b'),
        pe7_7s_anchor('\ue67c'),
        pe7_7s_albums('\ue67d'),
        pe7_7s_alarm('\ue67e'),
        pe7_7s_airplay('\ue67f');

        override val typeface: ITypeface by lazy { Pixeden7Stroke }
    }
}
